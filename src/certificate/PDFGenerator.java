
package certificate;

import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfWriter;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.io.FileOutputStream;

public class PDFGenerator {

    public static String generateCertificate(Certificate cert)
            throws Exception {

        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Save Certificate PDF");

        chooser.setSelectedFile(
            new File("Certificate_" +
                     cert.getCertificateNumber() + ".pdf")
        );

        chooser.setFileFilter(
            new FileNameExtensionFilter("PDF Files", "pdf")
        );

        int choice = chooser.showSaveDialog(null);

        if (choice != JFileChooser.APPROVE_OPTION) {
            return null;
        }

        File file = chooser.getSelectedFile();

        if (!file.getName().toLowerCase().endsWith(".pdf")) {
            file = new File(file.getAbsolutePath() + ".pdf");
        }

        Document document = new Document(PageSize.A4.rotate());

        PdfWriter.getInstance(
            document, new FileOutputStream(file)
        );

        document.open();

        Font titleFont = new Font(
            Font.HELVETICA, 28, Font.BOLD
        );

        Font normalFont = new Font(
            Font.HELVETICA, 16, Font.NORMAL
        );

        Font nameFont = new Font(
            Font.HELVETICA, 24, Font.BOLD
        );

        Paragraph title = new Paragraph(
            "CERTIFICATE OF ACHIEVEMENT", titleFont
        );
        title.setAlignment(Element.ALIGN_CENTER);

        document.add(title);
        document.add(new Paragraph(" "));
        
        Paragraph subtitle = new Paragraph(
            "This certificate is proudly presented to",
            normalFont
        );
        subtitle.setAlignment(Element.ALIGN_CENTER);
        document.add(subtitle);

        Paragraph name = new Paragraph(
            cert.getRecipientName(), nameFont
        );
        name.setAlignment(Element.ALIGN_CENTER);
        document.add(name);

        Paragraph course = new Paragraph(
            "For successfully completing the course: " +
            cert.getCourseName(), normalFont
        );
        course.setAlignment(Element.ALIGN_CENTER);
        document.add(course);

        document.add(new Paragraph(" "));
        
        Paragraph number = new Paragraph(
            "Certificate Number: " +
            cert.getCertificateNumber(), normalFont
        );
        number.setAlignment(Element.ALIGN_CENTER);
        document.add(number);

        Paragraph date = new Paragraph(
            "Issue Date: " + cert.getIssueDate(), normalFont
        );
        date.setAlignment(Element.ALIGN_CENTER);
        document.add(date);

        Paragraph id = new Paragraph(
            "Verification ID: " +
            cert.getVerificationId(), normalFont
        );
        id.setAlignment(Element.ALIGN_CENTER);
        document.add(id);
        // Generate QR Code for this certificate
java.io.File qrFile =
        QRGenerator.generateQR(cert.getVerificationId());

// Add QR Code to PDF
com.lowagie.text.Image qrImage =
        com.lowagie.text.Image.getInstance(
                qrFile.getAbsolutePath()
        );

qrImage.scaleToFit(120, 120);
qrImage.setAlignment(
        com.lowagie.text.Image.ALIGN_CENTER
);

document.add(qrImage);

        document.add(new Paragraph(" "));
        document.add(new Paragraph(" "));
        
        Paragraph signature = new Paragraph(
            "________________________\nAuthorized Signature",
            normalFont
        );
        signature.setAlignment(Element.ALIGN_RIGHT);
        document.add(signature);

        document.close();

        return file.getAbsolutePath();
    }
}
