import javax.swing.*;
import java.awt.*;

public class LoginFrame extends JFrame {

    public LoginFrame() {
        setTitle("Login");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create the login panel
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        // Scene title
        JLabel scenetitle = new JLabel("Log in to start learning");
        scenetitle.setFont(new Font("Tahoma", Font.PLAIN, 20));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel.add(scenetitle, gbc);

        // Username label and field
        JLabel userName = new JLabel("Twitter handle:");
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(userName, gbc);

        JTextField userTextField = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(userTextField, gbc);

        // Password label and field
        JLabel pw = new JLabel("Password:");
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(pw, gbc);

        JPasswordField pwBox = new JPasswordField(20);
        gbc.gridx = 1;
        gbc.gridy = 2;
        panel.add(pwBox, gbc);

        // Forgot password link (as a button for simplicity)
        JButton forgotPwBtn = new JButton("Forgot password?");
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.LINE_END;
        panel.add(forgotPwBtn, gbc);

        // Login button
        JButton btn = new JButton("Log in");
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.LINE_END;
        panel.add(btn, gbc);

        // Sign up link
        JLabel signUpLink = new JLabel("Don't have an account? Sign up now!");
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.LINE_START;
        panel.add(signUpLink, gbc);

        // Add panel to the frame
        add(panel, BorderLayout.CENTER);

        setVisible(true);
    }
}
