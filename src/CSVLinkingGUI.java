import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class CSVLinkingGUI extends JFrame
{
    private JTextField participantsCSVField;
    private JTextField votersCSVField;

    public CSVLinkingGUI(String environmentName, int durationSeconds, int voterDurationSeconds, String key)
    {
        initComponents(environmentName, durationSeconds, voterDurationSeconds, key);
    }

    private void initComponents(String environmentName, int durationSeconds, int voterDurationSeconds, String key)
    {
        setTitle("Link CSV Files");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        mainPanel.add(new JLabel("Participants CSV File:"));
        participantsCSVField = new JTextField();
        mainPanel.add(participantsCSVField);

        JButton participantsBrowseButton = new JButton("Browse");
        participantsBrowseButton.addActionListener(new ParticipantsBrowseListener());
        mainPanel.add(participantsBrowseButton);

        mainPanel.add(new JLabel("Voters CSV File:"));
        votersCSVField = new JTextField();
        mainPanel.add(votersCSVField);

        JButton votersBrowseButton = new JButton("Browse");
        votersBrowseButton.addActionListener(new VotersBrowseListener());
        mainPanel.add(votersBrowseButton);

        JButton startButton = new JButton("Start");
        startButton.addActionListener(new StartButtonListener(environmentName, durationSeconds, voterDurationSeconds, key));
        mainPanel.add(startButton);

        add(mainPanel);
        setVisible(true);
    }

    private class ParticipantsBrowseListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileFilter(new FileNameExtensionFilter("CSV Files", "csv"));
            int returnValue = fileChooser.showOpenDialog(null);

            if (returnValue == JFileChooser.APPROVE_OPTION)
            {
                File selectedFile = fileChooser.getSelectedFile();
                participantsCSVField.setText(selectedFile.getAbsolutePath());
            }
        }
    }

    private class VotersBrowseListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileFilter(new FileNameExtensionFilter("CSV Files", "csv"));
            int returnValue = fileChooser.showOpenDialog(null);

            if (returnValue == JFileChooser.APPROVE_OPTION)
            {
                File selectedFile = fileChooser.getSelectedFile();
                votersCSVField.setText(selectedFile.getAbsolutePath());
            }
        }
    }

    private class StartButtonListener implements ActionListener
    {
        private String environmentName;
        private int durationSeconds;
        private int voterDurationSeconds;
        private String key;

        public StartButtonListener(String environmentName, int durationSeconds, int voterDurationSeconds, String key)
        {
            this.environmentName = environmentName;
            this.durationSeconds = durationSeconds;
            this.voterDurationSeconds = voterDurationSeconds;
            this.key = key;
        }

        @Override
        public void actionPerformed(ActionEvent e)
        {
            String participantsCSVFilePath = participantsCSVField.getText().trim();
            String votersCSVFilePath = votersCSVField.getText().trim();

            if (participantsCSVFilePath.isEmpty() || votersCSVFilePath.isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Please select both CSV files.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Environment environment = new Environment(environmentName);
            environment.addTotalDurationSeconds(durationSeconds);
            environment.addVoterDurationSeconds(voterDurationSeconds);
            environment.setKey(key);

            Participant[] participants = Managers.om.readOptions(participantsCSVFilePath);

            new VoterManager().readVoters(votersCSVFilePath);

            dispose();

            SwingUtilities.invokeLater(VotingGUI::new);
        }
    }

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(() -> new CSVLinkingGUI("Sample Environment", 600, 60, "sample_key"));
    }
}
