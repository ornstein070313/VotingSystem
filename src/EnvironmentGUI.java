import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EnvironmentGUI extends JFrame
{
    private JTextField environmentNameField;
    private JTextField durationField;
    private JTextField voterDurationField;
    private JTextField keyField;

    public EnvironmentGUI()
    {
        initComponents();
    }

    private void initComponents()
    {
        setTitle("Environment Details");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new GridLayout(5, 2, 10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        mainPanel.add(new JLabel("Environment Name:"));
        environmentNameField = new JTextField();
        mainPanel.add(environmentNameField);

        mainPanel.add(new JLabel("Duration (seconds):"));
        durationField = new JTextField();
        mainPanel.add(durationField);

        mainPanel.add(new JLabel("Voter Duration (seconds):"));
        voterDurationField = new JTextField();
        mainPanel.add(voterDurationField);

        mainPanel.add(new JLabel("Key:"));
        keyField = new JTextField();
        mainPanel.add(keyField);

        JButton nextButton = new JButton("Next");
        nextButton.addActionListener(new NextButtonListener());
        mainPanel.add(nextButton);

        add(mainPanel);
        setVisible(true);
    }

    private class NextButtonListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            String environmentName = environmentNameField.getText();
            String durationStr = durationField.getText();
            String voterDurationStr = voterDurationField.getText();
            String key = keyField.getText();

            if (environmentName.isEmpty() || durationStr.isEmpty() || voterDurationStr.isEmpty() || key.isEmpty())
            {
                JOptionPane.showMessageDialog(EnvironmentGUI.this, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            new CSVLinkingGUI(environmentName, Integer.parseInt(durationStr), Integer.parseInt(voterDurationStr), key);
            dispose();
        }
    }

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(EnvironmentGUI::new);
    }
}
