
package certificate.ui;

import javax.swing.*;
import java.awt.*;

public class LoginFrame extends JFrame {

    private JTextField username;
    private JPasswordField password;

    public LoginFrame() {

        setTitle("Admin Login");
        setSize(350, 180);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel title = new JLabel("DIGITAL CERTIFICATE SYSTEM");
        title.setHorizontalAlignment(JLabel.CENTER);

        username = new JTextField(12);
        password = new JPasswordField(12);

        JButton login = new JButton("Login");

        JPanel panel = new JPanel(new GridLayout(3, 2, 5, 5));
panel.setBorder(BorderFactory.createEmptyBorder(15, 25, 15, 25));

        panel.add(new JLabel("Username:"));
        panel.add(username);

        panel.add(new JLabel("Password:"));
        panel.add(password);

        panel.add(new JLabel(""));
        panel.add(login);

        add(title, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);

        login.addActionListener(e -> {

            String user = username.getText();
            String pass = new String(password.getPassword());

            if (user.equals("admin") &&
                pass.equals("admin123")) {

                JOptionPane.showMessageDialog(
                    this, "Login Successful!"
                );

                new MainFrame().setVisible(true);
                dispose();

            } else {
                JOptionPane.showMessageDialog(
                    this, "Invalid Username or Password!"
                );
            }
        });
    }
}

