package certificate;

public class Certificate {

    private String verificationId;
    private String certificateNumber;
    private String recipientName;
    private String courseName;
    private String issueDate;

    public Certificate(String verificationId, String certificateNumber,
                       String recipientName, String courseName, String issueDate) {

        this.verificationId = verificationId;
        this.certificateNumber = certificateNumber;
        this.recipientName = recipientName;
        this.courseName = courseName;
        this.issueDate = issueDate;
    }

    public String getVerificationId() {
        return verificationId;
    }

    public String getCertificateNumber() {
        return certificateNumber;
    }

    public String getRecipientName() {
        return recipientName;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getIssueDate() {
        return issueDate;
    }
}