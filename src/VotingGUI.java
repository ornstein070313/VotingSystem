import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;
import java.util.Map;

public class VotingGUI extends JFrame
{
    private JTextField voterIdField;
    private JPanel optionsPanel;

    public VotingGUI()
    {
        initComponents();
    }

    private void initComponents()
    {
        setTitle("Voting Interface");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel inputPanel = new JPanel(new GridLayout(3, 1, 5, 5));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel voterIdLabel = new JLabel("Enter Voter ID:");
        inputPanel.add(voterIdLabel);

        voterIdField = new JTextField();
        inputPanel.add(voterIdField);

        JButton voteButton = new JButton("Vote");
        voteButton.addActionListener(new VoteButtonListener());
        inputPanel.add(voteButton);

        mainPanel.add(inputPanel, BorderLayout.NORTH);

        optionsPanel = new JPanel(new GridLayout(0, 1));
        mainPanel.add(optionsPanel, BorderLayout.CENTER);

        add(mainPanel);
        setVisible(true);
    }

    private class VoteButtonListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            String voterIdText = voterIdField.getText().trim();

            if (voterIdText.isEmpty())
            {
                JOptionPane.showMessageDialog(VotingGUI.this, "Please enter a Voter ID.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            try
            {
                Long voterId = Long.parseLong(voterIdText);

                if (Constants.voterIds.containsKey(voterId))
                {
                    if (Managers.vm.hasVoted(voterId))
                    {
                        JOptionPane.showMessageDialog(VotingGUI.this, "You have already voted.", "Message", JOptionPane.INFORMATION_MESSAGE);
                    }
                    else
                    {
                        showOptionsAndVote(voterId);
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(VotingGUI.this, "Voter ID not found.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException ex)
            {
                JOptionPane.showMessageDialog(VotingGUI.this, "Invalid Voter ID format.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void showOptionsAndVote(Long voterId)
    {
        optionsPanel.removeAll();

        Map<VoteOption, BigInteger> voteOptions = Constants.voteCount;

        ButtonGroup buttonGroup = new ButtonGroup();
        for (Map.Entry<VoteOption, BigInteger> entry : voteOptions.entrySet())
        {
            VoteOption option = entry.getKey();
            JRadioButton radioButton = new JRadioButton(option.getName());
            radioButton.setActionCommand(option.getName());
            buttonGroup.add(radioButton);
            optionsPanel.add(radioButton);
        }

        JButton submitVoteButton = new JButton("Submit Vote");
        submitVoteButton.addActionListener(e ->
        {
            String selectedOptionName = buttonGroup.getSelection().getActionCommand();
            VoteOption selectedOption = findOptionByName(selectedOptionName);
            if (selectedOption != null)
            {
                Managers.vm.addVoter(voterId, selectedOption);
                JOptionPane.showMessageDialog(VotingGUI.this, "Vote submitted successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                optionsPanel.removeAll();
                optionsPanel.revalidate();
                optionsPanel.repaint();
            }
        });
        optionsPanel.add(submitVoteButton);

        optionsPanel.revalidate();
        optionsPanel.repaint();
    }

    private VoteOption findOptionByName(String name)
    {
        for (Map.Entry<VoteOption, BigInteger> entry : Constants.voteCount.entrySet())
        {
            if (entry.getKey().getName().equals(name))
            {
                return entry.getKey();
            }
        }
        return null;
    }

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(VotingGUI::new);
    }
}
