import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ChatbotGUI extends JFrame implements ActionListener {

    private JTextField userInput;
    private JTextArea chatArea;

    public ChatbotGUI() {
        setTitle("Chatbot");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setResizable(false);
        setLocationRelativeTo(null);

        userInput = new JTextField(20);
        chatArea = new JTextArea();
        chatArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(chatArea);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BorderLayout());
        inputPanel.add(userInput, BorderLayout.CENTER);

        JButton sendButton = new JButton("Send");
        sendButton.addActionListener(this);
        inputPanel.add(sendButton, BorderLayout.EAST);

        add(scrollPane, BorderLayout.CENTER);
        add(inputPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String input = userInput.getText().toLowerCase();
        chatArea.append("You: " + input + "\n");

        if (input.contains("hello") || input.contains("hi")) {
            chatArea.append("Chatbot: Hello!\n");
        } else if (input.contains("how are you")) {
            chatArea.append("Chatbot: I'm doing well, thanks for asking.\n");
        } else if (input.contains("what is your name")) {
            chatArea.append("Chatbot: My name is Chatbot.\n");
        } else if (input.contains("goodbye") || input.contains("bye")) {
            chatArea.append("Chatbot: Goodbye!\n");
        } else if (input.contains("who are you") || input.contains("what can you do")) {
            chatArea.append("Chatbot: I am a chatbot built for responding to your messages and help you in any regard\n");
        } else {
            chatArea.append("Chatbot: I'm sorry, I didn't understand. Can you please try again?\n");
        }

        userInput.setText("");
    }

    public static void main(String[] args) {
        new ChatbotGUI();
    }
}
