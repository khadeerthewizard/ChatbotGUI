import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.io.*;
import java.util.ArrayList;

public class ViewApplicant extends JFrame {
    private JTextArea listArea;

    public ViewApplicant() {
        setTitle("List Frame");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout());

        listArea = new JTextArea();


        ArrayList<applicant> applicantsFromFile = readApplicantsFromFile("applied.ser");
        listArea.append("Applicants read from file:\n");
        for (applicant applic : applicantsFromFile) {
            listArea.append(applic.toString());
        }

        mainPanel.add(listArea, BorderLayout.CENTER);
        

        add(mainPanel);
        setVisible(true);
    }

    public static ArrayList<applicant> readApplicantsFromFile(String fileName) {
        ArrayList<applicant> applicants = null;
        try {
            // read objects from file
            FileInputStream fileIn = new FileInputStream(fileName);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            applicants = (ArrayList<applicant>) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return applicants;
    }
    public static void main(String[] args) {
        new ViewApplicant();
    }
}
