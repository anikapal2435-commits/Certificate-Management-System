
package certificate;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;

public class QRGenerator {

    public static File generateQR(String verificationId)
            throws Exception {

        BitMatrix matrix = new MultiFormatWriter().encode(
            verificationId,
            BarcodeFormat.QR_CODE,
            200,
            200
        );

        BufferedImage image =
            new BufferedImage(200, 200, BufferedImage.TYPE_INT_RGB);

        for (int x = 0; x < 200; x++) {
            for (int y = 0; y < 200; y++) {
                image.setRGB(x, y,
                    matrix.get(x, y) ? 0x000000 : 0xFFFFFF);
            }
        }

        File file = File.createTempFile("certificate_qr", ".png");
        ImageIO.write(image, "png", file);

        return file;
    }
}

