import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.*;

public class AboutFrame extends JFrame {
    
    public AboutFrame() {
        // Set the title of the JFrame
        setTitle("About Team Wizard");
        setLayout(new BorderLayout());
        setBackground(Color.CYAN);
        
        // Create a JTextArea to display the information
        JTextArea info = new JTextArea();
        info.append("\n\n                                   We are Team Wizard always fascinating about the possibilities of tech\n");
        info.append("                                      We love technology and science and thats what makes us complete\n\n\n");

        JTextArea group = new JTextArea();
        group.append("\n                                  Group Members\n");
        group.append("                         Khaja Khadeerullah Shaik - 12215670\n");
        group.append("                            Nittu Pranay Kumar  12221976\n");
        group.append("                               Fouziya Shaik -12220374\n");
        group.setBackground(Color.cyan);
        group.setFont(new Font(Font.DIALOG_INPUT,Font.BOLD,16));



        info.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 16));
        setSize(800, 400);
        add(info,BorderLayout.NORTH);
        add(group,BorderLayout.CENTER);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        info.setBackground(Color.DARK_GRAY);
        info.setForeground(Color.CYAN);

    }
    
    public static void main(String[] args) {
        new AboutFrame();
    }
}
