package certificate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CertificateDAO {

    public boolean saveCertificate(Certificate certificate) {

        String sql = "INSERT INTO certificates "
                   + "(verification_id, certificate_number, recipient_name, course_name, issue_date) "
                   + "VALUES (?, ?, ?, ?, ?)";

        try {
            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, certificate.getVerificationId());
            ps.setString(2, certificate.getCertificateNumber());
            ps.setString(3, certificate.getRecipientName());
            ps.setString(4, certificate.getCourseName());
            ps.setString(5, certificate.getIssueDate());

            ps.executeUpdate();

            System.out.println("Certificate saved successfully!");

            return true;

        } catch (Exception e) {

            System.out.println("Certificate could not be saved!");
            e.printStackTrace();

            return false;
        }
    }

    public boolean verifyCertificate(String verificationId) {

        String sql = "SELECT * FROM certificates WHERE verification_id = ?";

        try {
            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, verificationId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}