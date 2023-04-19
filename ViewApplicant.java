import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class ViewApplicant extends JFrame {
    private JTextArea listArea;

    public ViewApplicant(List<String> list) {
        setTitle("List Frame");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout());

        listArea = new JTextArea();
        mainPanel.add(listArea, BorderLayout.CENTER);

        for (String item : list) {
            listArea.append(item + "\n");
        }

        add(mainPanel);
        setVisible(true);
    }
}
