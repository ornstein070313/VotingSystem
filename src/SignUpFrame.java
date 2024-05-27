import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUpFrame extends JFrame
{

    private FileHandler fileHandler;

    public SignUpFrame(FileHandler fileHandler)
    {
        this.fileHandler = fileHandler;

        setTitle("Sign Up");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel scenetitle = new JLabel("Sign up to create an account");
        scenetitle.setFont(new Font("Tahoma", Font.PLAIN, 20));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel.add(scenetitle, gbc);

        JLabel userName = new JLabel("Username:");
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(userName, gbc);

        JTextField userTextField = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(userTextField, gbc);

        JLabel pw = new JLabel("Password:");
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(pw, gbc);

        JPasswordField pwBox = new JPasswordField(20);
        gbc.gridx = 1;
        gbc.gridy = 2;
        panel.add(pwBox, gbc);

        JButton btn = new JButton("Sign Up");
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.LINE_END;
        panel.add(btn, gbc);

        add(panel, BorderLayout.CENTER);

        btn.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String username = userTextField.getText();
                char[] password = pwBox.getPassword();

                if (username.isEmpty() || password.length == 0)
                {
                    JOptionPane.showMessageDialog(SignUpFrame.this,
                            "Username and password cannot be empty.",
                            "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                String passwordString = new String(password);

                String userData = username + "," + passwordString;
                fileHandler.writeToFile(userData);

                JOptionPane.showMessageDialog(SignUpFrame.this,
                        "Sign up successful. You can now log in.",
                        "Success", JOptionPane.INFORMATION_MESSAGE);

                new LoginFrame(fileHandler);

                dispose();
            }
        });

        setVisible(true);
    }
}
