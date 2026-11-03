
package certificate;

public class QRGeneratorTest {

    public static void main(String[] args) {

        try {
            java.io.File qr = QRGenerator.generateQR("CERT-123456");

            System.out.println("QR Code generated successfully!");
            System.out.println("Location: " + qr.getAbsolutePath());

            // Open the generated QR image
            java.awt.Desktop.getDesktop().open(qr);

        } catch (Exception e) {
            System.out.println("QR generation failed!");
            e.printStackTrace();
        }
    }
}

