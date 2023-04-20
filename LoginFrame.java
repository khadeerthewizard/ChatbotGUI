import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;

class admin implements Serializable{
    String username;
    String password;
    admin(String username, String password){
        this.password=password;
        this.username=username;
    }
    public String getPassword() {
        return password;
    }
    public String getUsername() {
        return username;
    }
}

public class LoginFrame extends JFrame implements ActionListener {

    private JLabel label1, label2;
    private JTextField tf;
    private JPasswordField pf;
    private JButton loginBtn;

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
        ArrayList<admin> adminsFromFile = readAdminsFromFile("admin.ser");
        String inputUsername = tf.getText();
        String inputPassword = pf.getText();

        boolean loginSuccessful = false;
        for (admin adm : adminsFromFile) {
            if (adm.getUsername().equals(inputUsername) && adm.getPassword().equals(inputPassword)) {
                loginSuccessful = true;
                break;
            }
        }

        if (loginSuccessful) {
            JOptionPane.showMessageDialog(this, "Login successful");
            new AdminFrame();
        } else {
            JOptionPane.showMessageDialog(this, "Login failed");
        }
    }

    public static ArrayList<admin> readAdminsFromFile(String fileName) {
        ArrayList<admin> admins = new ArrayList<>();
        try {
            FileInputStream fileIn = new FileInputStream(fileName);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            Object obj = in.readObject();
            while (obj != null) {
                if (obj instanceof admin) {
                    admins.add((admin) obj);
                }
                obj = in.readObject();
            }
            in.close();
            fileIn.close();
        } catch (EOFException e) {
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return admins;
    }

    public static void main(String[] args) throws IOException {
        FileOutputStream fout = new FileOutputStream("admin.ser");
        ObjectOutputStream Obout = new ObjectOutputStream(fout);
        Obout.writeObject(new admin("12215670","wizard"));
        Obout.writeObject(new admin("34","marvel"));
        fout.close();
        Obout.close();
        new LoginFrame();
    }
}
