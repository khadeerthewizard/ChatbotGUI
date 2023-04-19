import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginFrame extends JFrame implements ActionListener {

    private JLabel label1, label2;
    private JTextField tf;
    private JPasswordField pf;
    private JButton loginBtn;
    String[][] admindata={
        {"12215670","wizard"},
        {"34","marvel"}
    };
    

    public LoginFrame() {
        setTitle("Login");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setLayout(new GridLayout(3, 2, 5, 5));

        label1 = new JLabel("Username:");
        add(label1);

        tf = new JTextField();
        add(tf);

        label2 = new JLabel("Password:");
        add(label2);

        pf = new JPasswordField();
        add(pf);

        loginBtn = new JButton("Login");
        add(loginBtn);

        loginBtn.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String username = tf.getText();
        String password = new String(pf.getPassword());

        for(int i=0;i<admindata.length;i++){
            if (username.equals(admindata[i][0]) && password.equals(admindata[i][1])) {
                JOptionPane.showMessageDialog(this, "Login successful");
                new AdminFrame();
                break;
            }
            if(i==admindata.length-1){
                JOptionPane.showMessageDialog(this, "Login Failed");
            }
        }
    }

    public static void main(String[] args) {
        new LoginFrame();
    }
}

