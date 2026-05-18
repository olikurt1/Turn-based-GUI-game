
import javax.swing.*;
import java.awt.*;

public class startMenuGUI extends JPanel{
    private String userName;
    private int difficulty;
    private static startMenuGUI instance = null;

    public static startMenuGUI getInstance(){
        if(instance == null){
            instance = new startMenuGUI();
        } 
        return instance;
    }

    public startMenuGUI(){


        //creating window overlay
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));
        mainPanel.setBackground(Color.BLACK);

        //creating title box
        JLabel titleLabel = new JLabel("WELCOME TO THE FUTURE");
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 26));
        titleLabel.setForeground(Color.CYAN);
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        //creating name input box and field
        JLabel nameLabel = new JLabel("Enter Username:");
        nameLabel.setForeground(Color.CYAN);
        nameLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        nameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JTextField nameField = new JTextField(15);
        nameField.setMaximumSize(new Dimension(250, 30));
        nameField.setFont(new Font("SansSerif", Font.BOLD, 14));

        //difficulty creating text for difficulty
        JLabel difficultyLabel = new JLabel("Select Difficulty:");
        difficultyLabel.setForeground(Color.CYAN);
        difficultyLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        difficultyLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        //creating box to have difficulty text in
        JPanel difficultyPanel = new JPanel(new FlowLayout());
        difficultyPanel.setBackground(Color.BLACK);

        ButtonGroup difficultyGroup = new ButtonGroup();
        JRadioButton easyButton = new JRadioButton("Easy");
        JRadioButton mediumButton = new JRadioButton("Medium");
        JRadioButton hardButton = new JRadioButton("Hard");

        for(JRadioButton button : new JRadioButton[]{easyButton, mediumButton, hardButton}){
            button.setForeground(Color.CYAN);
            button.setBackground(Color.BLACK);
            button.setFont(new Font("SansSerif", Font.BOLD, 16));
            difficultyGroup.add(button);
            difficultyPanel.add(button);
        }
        easyButton.setSelected (true);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 0));
        buttonPanel.setBackground(Color.BLACK);

        JButton startButton = new JButton("START GAME");
        startButton.setFont(new Font("SansSerif", Font.BOLD, 14));
        startButton.setBackground(new Color(0, 150, 0));
        startButton.setForeground(Color.WHITE);
        startButton.setFocusPainted(false);
        startButton.setOpaque(true);
        startButton.setBorderPainted(false);

        JButton quitButton = new JButton("QUIT");
        quitButton.setFont(new Font("SansSerif", Font.BOLD, 14));
        quitButton.setBackground(new Color(150, 0, 0));
        quitButton.setForeground(Color.WHITE);
        quitButton.setFocusPainted(false);
        quitButton.setOpaque(true);
        quitButton.setBorderPainted(false);

        //create button event handling for when start game button is pressed
        startButton.addActionListener(e -> {
            String name = nameField.getText().trim();
            //output dialog if try to play without entering username
            if(name.isEmpty()){
                JOptionPane.showMessageDialog(this, "Please enter a username to start.");
                return;
            }

            //takes difficulty selection
            this.userName = name;
            if (easyButton.isSelected()) this.difficulty = 1;
            else if (mediumButton.isSelected()) this.difficulty = 2;
            else if (hardButton.isSelected()) this.difficulty = 3;
 
            Game.getInstance().gameStart(userName, difficulty);

        });
        //create button event handling for qutting the game button
        quitButton.addActionListener(e -> {
            System.exit(0);
        });

        buttonPanel.add(startButton);
        buttonPanel.add(quitButton);

        mainPanel.add(titleLabel);
        mainPanel.add(Box.createVerticalStrut(20));
        mainPanel.add(nameLabel);
        mainPanel.add(Box.createVerticalStrut(5));
        mainPanel.add(nameField);
        mainPanel.add(Box.createVerticalStrut(15));
        mainPanel.add(difficultyLabel);
        mainPanel.add(Box.createVerticalStrut(5));
        mainPanel.add(difficultyPanel);
        mainPanel.add(Box.createVerticalStrut(20));
        mainPanel.add(buttonPanel);

        setLayout(new BorderLayout());
        add(mainPanel, BorderLayout.CENTER);
    }
}