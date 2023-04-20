import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AdminFrame extends JFrame implements ActionListener {
    
    private JButton viewApplicantsButton;
    private JButton changeCoursesButton;
    
    public AdminFrame() {
        setTitle("Admin Interface");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setLocationRelativeTo(null);
        
        JPanel mainPanel = new JPanel(new BorderLayout());
        
        JPanel buttonPanel = new JPanel(new GridLayout(2, 1, 10, 10));
        viewApplicantsButton = new JButton("View Applicant Data");
        viewApplicantsButton.addActionListener(this);
        changeCoursesButton = new JButton("Change Available Courses");
        changeCoursesButton.addActionListener(this);
        buttonPanel.add(viewApplicantsButton);
        buttonPanel.add(changeCoursesButton);
        mainPanel.add(buttonPanel, BorderLayout.CENTER);
        
        setContentPane(mainPanel);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == viewApplicantsButton) {
            new ViewApplicant();
        } else if (e.getSource() == changeCoursesButton) {
            JOptionPane.showMessageDialog(this, "Under Development");
        }
    }
    
    public static void main(String[] args) {
        new AdminFrame();
    }
}
