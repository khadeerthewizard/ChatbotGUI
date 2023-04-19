import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

public class ChatbotGUI extends JFrame implements ActionListener {


    //Declaring all Variables\
    private JTextField userInput;
    private JPanel inputPanel;
    private JScrollPane scrollPane;
    private JPanel navBar;
    private JTextArea chatArea;
    private JButton sendButton;
    private JButton homeButton;
    private JButton aboutButton;
    private JButton contactButton;
    private int initialize=0;
    private int CoursesFlag=0;
    private int regFlag=0;
    private int phoneFlag=0;
    public String user="student";
    public int userStage=1;
    String regNO;

    //Defining the database of Student and their methods
    public static String[][] studentData= {
        {"12215670","Khadeer","8.29","80000","86%"},
        {"12221976","Pranay","8","80001","50%"},
        {"12215228","Sameer","9","89892","100%"},
        {"12233442","Venky","10","10200","200%"},
        {"12214457","CallmeYas","11[ExtraOrdinary]","163762222","50%"}
     };

    public static ArrayList<String> applicantData = new ArrayList<String>();

     //defining course info

     public static String[][] CoursesData = 
     {
        {"Computer Science And Engineering[CSE]","Computer labs","Software and tools",
        "Classroom technology","Online resources","Networking events",
        "Career services","Cloud computing resources","Virtual environments",
        "Online learning platforms","Open-source software"},

        {"Electronics And Communications Engineering[ECE]","Electronic labs","Communication labs",
        "Computer labs","Research facilities","Electronics fabrication labs","Antenna design labs",
        "Signal processing labs","Optical communication labs","Microelectronics labs","Robotics labs",
        "Microelectronics labs","Microwave engineering labs","Semiconductor labs","Instrumentation and measurement labs"},

        {"Electrical And Electrical Engineering[EEE]","Power systems labs","Control systems labs",
        "Electrical machines labs","Power electronics labs","Electric drives and control labs",
        "High voltage engineering labs","Electromagnetic compatibility (EMC) labs","Robotics labs",
        "Semiconductor labs","Instrumentation and measurement labs"},
        
        {"Mechanical Engineering[MEC]","Manufacturing labs","Materials science labs",
        "Thermal systems labs","Dynamics and control labs","Computational mechanics labs","Renewable energy labs",
        "Instrumentation and measurement labs","Biomechanics labs","Design labs"},
        
        {"Civil Engineering[Civil]","Structures and materials labs","Geotechnical labs","Transportation labs",
        "Environmental labs","Surveying labs","Construction management labs","Smart materials and structures labs",
        "Building information modeling (BIM) software","Fluid mechanics and hydraulics labs",
        "Building and materials testing facilities","Sustainability and green building labs"},
        
        {"AutoMobile Engineering[AE]","Engine testing and development labs","Vehicle dynamics labs",
        "Powertrain design and analysis labs","Advanced materials and manufacturing labs",
        "Electric and hybrid vehicle labs","Autonomous vehicle labs","Vehicle safety and crash testing labs",
        "Aerodynamics and wind tunnel testing labs","Noise, vibration, and harshness (NVH) testing labs",
        "Engine emissions testing labs","Vehicle instrumentation and data analysis labs","Vehicle design studios",
        "Engine component manufacturing labs","Vehicle electronics and software labs"}
     };

     String[] FacilitiesData = { "Non-vegetarian food allowed", "Residential Facility", "Free Wifi in Hostels",
            "Expert Faculity", "Internship Opertunities", "Foreign exchange programmes",
            "Vast Library", "Healthy Environment", "Supervised by Team Wizard" };

    public String getCgpa (String[][] data,String regNo) {
        for(int i=0;i<data.length;i++){
            if(regNo.equals(data[i][0])){
                return "Student "+data[i][1]+" have cgpa of "+data[i][2];
            }
        }
        return "Not Found in the Data";
    }
    public String getFee (String[][] data,String regNo) {
        for(int i=0;i<data.length;i++){
            if(regNo.equals(data[i][0])){
                return "Student "+data[i][1]+" have fee of "+data[i][3];
            }
        }
        return "Not Found in the Data";
    }
    public String getAttendance (String[][] data,String regNo) {
        for(int i=0;i<data.length;i++){
            if(regNo.equals(data[i][0])){
                return "Student "+data[i][1]+" have attendance of "+data[i][4];
            }
        }
        return "Not Found in the Data";
    }

    //defining to get courses method
    public void getCourses(String[][] course){
        int j = 0 ;
        for(int i = 0 ; i < course.length ; i++){
            j = i+1;
            chatArea.append(j+"."+course[i][0]+".\n");
        }
        j++;
        chatArea.append(j+".exit.\n");
    }


    //end of student database and methods


    public ChatbotGUI() {
        applicantData.add("Pranay");
        applicantData.add("7995670276");
        applicantData.add("Sriram");
        applicantData.add("8734567987");
        setTitle("Chatbot");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1100, 900);
        setResizable(false);
        setBackground(Color.DARK_GRAY);
        setLocationRelativeTo(null);

        //admin

        //navbar setting
        navBar = new JPanel();
        navBar.setPreferredSize(new Dimension(getWidth(), 40));
        navBar.setLayout(new BorderLayout());

        homeButton = new JButton("CHATBOT");
        aboutButton = new JButton("ADMIN LOGIN (TEAM WIZARD)");
        contactButton = new JButton("ABOUT US");

        // Customize the navigation bar buttons
        homeButton.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 16));
        homeButton.setBackground(Color.BLACK);
        homeButton.setForeground(Color.WHITE);
        homeButton.addActionListener(this);
        aboutButton.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 16));
        aboutButton.setForeground(Color.WHITE);
        aboutButton.setBackground(Color.BLACK);
        aboutButton.setActionCommand("ADMIN");
        aboutButton.addActionListener(this);
        aboutButton.setBorder(BorderFactory.createMatteBorder(0, 1, 0, 1, Color.CYAN));
        contactButton.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 16));
        contactButton.setBackground(Color.BLACK);
        contactButton.setForeground(Color.WHITE);

        // Add the navigation bar buttons to the navigation bar panel
        navBar.add(homeButton, BorderLayout.WEST);
        navBar.add(aboutButton, BorderLayout.CENTER);
        navBar.add(contactButton, BorderLayout.EAST);
        navBar.setBackground(Color.BLACK);
        navBar.setForeground(Color.WHITE);
        navBar.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.CYAN));

        getContentPane().add(navBar, BorderLayout.NORTH);

        //end of navbar
        
        //user input 
        userInput = new JTextField(1);
        userInput.setEditable(false);
        userInput.setPreferredSize(new Dimension(200,50));
        userInput.setFont(new Font("Georgia",Font.PLAIN,24));
        userInput.setBackground(Color.GRAY);
        userInput.setForeground(Color.WHITE);
        userInput.setBorder(null);
        userInput.setToolTipText("Enter your choice here");


        //chat area
        chatArea = new JTextArea();
        chatArea.setFont(new Font(Font.DIALOG_INPUT,Font.PLAIN,14));
        chatArea.setEditable(false);
        chatArea.setBackground(Color.DARK_GRAY);
        chatArea.setForeground(Color.WHITE);
        chatArea.setBorder(null);

        //adding chatarea to scrollpane
        scrollPane = new JScrollPane(chatArea);
        scrollPane.setBorder(BorderFactory.createMatteBorder(3, 3, 0, 3, Color.BLACK));

        //input panel
        inputPanel = new JPanel();
        inputPanel.setLayout(new BorderLayout());
        inputPanel.setBorder(BorderFactory.createMatteBorder(0, 3, 3, 3, Color.BLACK));


        sendButton = new JButton("  S T A R T  ");
        sendButton.setFont(new Font(Font.MONOSPACED,Font.BOLD,24));
        sendButton.setPreferredSize(new Dimension(100,100));
        userInput.setEditable(true);

        sendButton.addActionListener(this);
        userInput.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Programmatically click the sendButton button
                sendButton.doClick();
            }
        });
        
        sendButton.setBackground(Color.GRAY);
        sendButton.setForeground(Color.WHITE);
        sendButton.setBorder(BorderFactory.createMatteBorder(3, 2, 3, 2,Color.GRAY));
        inputPanel.add(sendButton, BorderLayout.CENTER);
        

        add(scrollPane, BorderLayout.CENTER);
        add(inputPanel, BorderLayout.SOUTH);
        chatArea.append("\n");
        chatArea.append("\n");
        chatArea.append("\n");
        chatArea.append("\n");
        chatArea.append("\n");
        chatArea.append("\n");
        chatArea.append("\n");
        chatArea.append("----------------------------------------------------------------------------------------------------------------------------\n");
        chatArea.append("                                               Welcome to Wizard University\n");
        chatArea.append("                                   This is Chatbot created for both students and applicants\n");
        chatArea.append("----------------------------------------------------------------------------------------------------------------------------\n");
        chatArea.append("----------------------------------------------------------------------------------------------------------------------------\n");
        chatArea.append("\n");
        chatArea.append("                                                What can this Chatbot Do?\n");
        chatArea.append("                                        1.Shows the marks, attendance of Students\n");
        chatArea.append("                                                   2.Updates Frequently\n");
        chatArea.append("                                 3.If anywhere program does not respond just enter 'exit'\n");
        chatArea.append("                              4.If any error report the bug or issue to khadeer2204@gmail.com\n");
        chatArea.append("                                   5.Shows What Courses are Available in the University\n");
        chatArea.append("                                           6.Can Directly Apply to Any Course\n");
        chatArea.append("\n");
        chatArea.append("                                                  Created By Team Wizard\n");
        chatArea.append("----------------------------------------------------------------------------------------------------------------------------\n");
        chatArea.append("----------------------------------------------------------------------------------------------------------------------------\n");



        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if(e.getActionCommand().equals("ADMIN")){
            new LoginFrame();
            return;
        }

        
        if(initialize==0 || e.getActionCommand().equals("CHATBOT") || userInput.getText().equals("menu")){
            initialize=0;
            CoursesFlag=0;
            regFlag=0;
            phoneFlag=0;
            user="student";
            userStage=1;
            chatArea.setText("");
            chatArea.setForeground(Color.WHITE);
            sendButton.setFont(new Font(Font.MONOSPACED,Font.BOLD,13));
            inputPanel.setBorder(BorderFactory.createMatteBorder(20, 20, 20, 20,Color.DARK_GRAY));
            inputPanel.remove(sendButton);
            sendButton.setPreferredSize(new Dimension(60,50));
            inputPanel.add(sendButton,BorderLayout.EAST);
            inputPanel.add(userInput, BorderLayout.CENTER);
            sendButton.setText("SEND");
            userInput.setText("");
            initialize++;
            chatArea.append("\n");
            chatArea.append("\n");
            chatArea.append("----------------------------------------------------------------------------------------------------------------------------\n");
            chatArea.append("Chatbot:   Hello this is Wizard University!\n");
            chatArea.append("                    You are?\n");
            chatArea.append("                    1.Already a Student Here\n");
            chatArea.append("                    2.Fresh Applicant\n");
            chatArea.append("----------------------------------------------------------------------------------------------------------------------------\n");
            userStage++;
            return;
        }
        

        String input = userInput.getText().toLowerCase();
        chatArea.append("You:           " + input + "\n");

        if(input.equals("exit") | input.equals("Exit") | input.equals("EXIT")){
            System.exit(0);
        }


        //USERSTAGE 1 whether a student or applicant
        if(userStage==1){
            chatArea.append("----------------------------------------------------------------------------------------------------------------------------\n");
            chatArea.append("Chatbot:   Welcome to  Wizard University!\n");
            chatArea.append("                    You are?\n");
            chatArea.append("                    1.Already a Student Here\n");
            chatArea.append("                    2.Fresh Applicant\n");
            chatArea.append("----------------------------------------------------------------------------------------------------------------------------\n");
            userStage++;
        }

        //USERSTAGE 2 prints to take reg no
        else if(userStage==2 && input.equals("1")){
            user="student";
            chatArea.append("----------------------------------------------------------------------------------------------------------------------------\n");
            chatArea.append("Chatbot:   Enter Registration Number: \n");
            chatArea.append("                    1.Go back\n");
            chatArea.append("----------------------------------------------------------------------------------------------------------------------------\n");
            userStage++;
            regFlag=1;
        }

        else if(userStage==3 && input.equals("1") && regFlag==1){
            userStage=2;
            chatArea.append("----------------------------------------------------------------------------------------------------------------------------\n");
            chatArea.append("Chatbot:   Welcome to Wizard University!\n");
            chatArea.append("                    You are?\n");
            chatArea.append("                    1.Already a Student Here\n");
            chatArea.append("                    2.Fresh Applicant\n");
            chatArea.append("----------------------------------------------------------------------------------------------------------------------------\n");
        }

        //USERSTAGE check reg No
        else if(userStage==3 && user.equals("student")){
            for(int i=0;i<studentData.length;i++){
                if(studentData[i][0].equals(input)){
                    chatArea.append("----------------------------------------------------------------------------------------------------------------------------\n");
                    chatArea.append("Chatbot:   The Name is Linked to the provided Registration Number is "+studentData[i][1]);
                    chatArea.append("\n");
                    chatArea.append("                    1.View Marks\n");
                    chatArea.append("                    2.View Fee\n");
                    chatArea.append("                    3.Attendance\n");
                    chatArea.append("                    4.Go Back\n");
                    chatArea.append("----------------------------------------------------------------------------------------------------------------------------\n");
                    userStage++;
                    regNO=input;
                    break;
                }
                if(i==studentData.length-1){
                    chatArea.append("Chatbot:   NOT VALID REG NO\n");
                    chatArea.append("----------------------------------------------------------------------------------------------------------------------------\n");
                    chatArea.append("Chatbot:   Enter Registration Number: \n");
                    chatArea.append("                    1.Go back\n");
                    chatArea.append("----------------------------------------------------------------------------------------------------------------------------\n");
                    userStage=3;
                }
            }
        }
        else if(userStage==4 && user.equals("student") && input.equals("4")){
            chatArea.append("----------------------------------------------------------------------------------------------------------------------------\n");
            chatArea.append("Chatbot:   Enter Registration Number: \n");
            chatArea.append("                    1.Go back\n");
            userStage=3;
            chatArea.append("----------------------------------------------------------------------------------------------------------------------------\n");
        }

        else if(userStage==4 && user.equals("student") && input.equals("1")){
            chatArea.append(getCgpa(studentData, regNO)+"\n");
            chatArea.append("----------------------------------------------------------------------------------------------------------------------------\n");
            chatArea.append("Chatbot:   1.View Marks\n");
            chatArea.append("                    2.View Fee\n");
            chatArea.append("                    3.Attendance\n");
            chatArea.append("                    4.exit\n");
            chatArea.append("----------------------------------------------------------------------------------------------------------------------------\n");
        }
        else if(userStage==4 && user.equals("student") && input.equals("2")){
            chatArea.append(getFee(studentData, regNO)+"\n");
            chatArea.append("----------------------------------------------------------------------------------------------------------------------------\n");
            chatArea.append("Chatbot:   1.View Marks\n");
            chatArea.append("                    2.View Fee\n");
            chatArea.append("                    3.Attendance\n");
            chatArea.append("                    4.exit\n");
            chatArea.append("----------------------------------------------------------------------------------------------------------------------------\n");
        }
        else if(userStage==4 && user.equals("student") && input.equals("3")){
            chatArea.append(getAttendance(studentData, regNO)+"\n");
            chatArea.append("----------------------------------------------------------------------------------------------------------------------------\n");
            chatArea.append("Chatbot:   1.View Marks\n");
            chatArea.append("                    2.View Fee\n");
            chatArea.append("                    3.Attendance\n");
            chatArea.append("                    4.exit\n");
            chatArea.append("----------------------------------------------------------------------------------------------------------------------------\n");
        }

        else if(userStage == 2 && input.equals("2"))
        {
            user = "Applicant";
            chatArea.append("----------------------------------------------------------------------------------------------------------------------------\n");
            chatArea.append("Chatbot:   1.Courses Offered.\n");
            chatArea.append("           2.Facilities Available.\n");
            chatArea.append("           3.Apply\n");
            chatArea.append("           4.exit.\n");
            chatArea.append("----------------------------------------------------------------------------------------------------------------------------\n");
            userStage++;
        }

        else if(userStage==3 && input.equals("3") && user.equals("Applicant")){
            chatArea.append("----------------------------------------------------------------------------------------------------------------------------\n");
            chatArea.append("Enter your phone: \n");
            chatArea.append("----------------------------------------------------------------------------------------------------------------------------\n");
            phoneFlag=1;
        }
        else if(userStage==3 && user.equals("Applicant") && phoneFlag==1){
            applicantData.add(input);
            chatArea.append("----------------------------------------------------------------------------------------------------------------------------\n");
            chatArea.append("Enter your name: \n");
            chatArea.append("----------------------------------------------------------------------------------------------------------------------------\n");
            phoneFlag=2;
        }
        else if(userStage==3 && user.equals("Applicant") && phoneFlag==2){
            applicantData.add(input);
            chatArea.append("Applied");
        }



        
        else if (userStage==3 && input.equals("1") && user.equals("Applicant"))
        {
            CoursesFlag = 1;
            chatArea.append("----------------------------------------------------------------------------------------------------------------------------\n");
            chatArea.append("Chatbot:   Courses Offered in our University are : \n");
            getCourses(CoursesData);
            chatArea.append("----------------------------------------------------------------------------------------------------------------------------\n");
            userStage++;
        }

        else if(userStage==3 && input.equals("2") && user.equals("Applicant"))
        {
            chatArea.append("----------------------------------------------------------------------------------------------------------------------------\n");
            chatArea.append("Chatbot:   Facilities Offered by our University are : \n");
            chatArea.append("                Non-vegetarian food allowed.\n");
            chatArea.append("                Residential Facility.\n");
            chatArea.append("                Free Wifi in Hostels.\n");
            chatArea.append("                Expert Faculty.\n");
            chatArea.append("                Vast Library.\n");
            chatArea.append("                Internship Opertunities\n");
            chatArea.append("                Foreign exchange programmes.\n");
            chatArea.append("                Healthy Environment.\n");
            chatArea.append("                Supervised by Team Wizard.\n");
            chatArea.append("                exit\n");
            chatArea.append("----------------------------------------------------------------------------------------------------------------------------\n");
            userStage++;
        }  
        else if(userStage==4 && input.equals("1") && user.equals("Applicant") && CoursesFlag == 1)
        {
            chatArea.append("----------------------------------------------------------------------------------------------------------------------------\n");
            chatArea.append("Our special resources in Computer Science and Engineering.\n");
            for(int i = 1 ; i < CoursesData[0].length ; i++){
                chatArea.append(i+"."+CoursesData[0][i]+".\n");
            }
            chatArea.append("----------------------------------------------------------------------------------------------------------------------------\n");
        }
        else if(userStage==4 && input.equals("2") && user.equals("Applicant") && CoursesFlag == 1)
        {
            chatArea.append("----------------------------------------------------------------------------------------------------------------------------\n");
            chatArea.append("Our special resources in Electronics and Communications Engineering.\n");
            for(int i = 1 ; i < CoursesData[1].length ; i++){
                chatArea.append(i+"."+CoursesData[1][i]+".\n");
            }
            chatArea.append("----------------------------------------------------------------------------------------------------------------------------\n");
        }
        else if(userStage==4 && input.equals("3") && user.equals("Applicant") && CoursesFlag == 1)
        {
            chatArea.append("----------------------------------------------------------------------------------------------------------------------------\n");
            chatArea.append("Chatbot:   Our special resources in Electrical and Electronics Engineering.\n");
            for(int i = 1 ; i < CoursesData[2].length ; i++){
                chatArea.append(i+"."+CoursesData[2][i]+".\n");
            }
            chatArea.append("----------------------------------------------------------------------------------------------------------------------------\n");
        }
        else if(userStage==4 && input.equals("4") && user.equals("Applicant") && CoursesFlag == 1)
        {
            chatArea.append("----------------------------------------------------------------------------------------------------------------------------\n");
            chatArea.append("Chatbot:   Our special resources in Mechanical Engineering.\n");
            for(int i = 1 ; i < CoursesData[3].length ; i++){
                chatArea.append(i+"."+CoursesData[3][i]+".\n");
            }
            chatArea.append("----------------------------------------------------------------------------------------------------------------------------\n");
        }
        else if(userStage==4 && input.equals("5") && user.equals("Applicant") && CoursesFlag == 1)
        {
            chatArea.append("----------------------------------------------------------------------------------------------------------------------------\n");
            chatArea.append("Chatbot:   Our special resources in Civil Engineering.\n");
            for(int i = 1 ; i < CoursesData[4].length ; i++){
                chatArea.append(i+"."+CoursesData[4][i]+".\n");
            }
            chatArea.append("----------------------------------------------------------------------------------------------------------------------------\n");
        }
        else if(userStage==4 && input.equals("6") && user.equals("Applicant") && CoursesFlag == 1)
        {
            chatArea.append("----------------------------------------------------------------------------------------------------------------------------\n");
            chatArea.append("Chatbot:   Our special resources in AutoMobile Engineering.\n");
            for(int i = 1 ; i < CoursesData[5].length ; i++){
                chatArea.append(i+"."+CoursesData[5][i]+".\n");
            }
            chatArea.append("----------------------------------------------------------------------------------------------------------------------------\n");
        }
        else if(userStage==4 && input.equals("7") && user.equals("Applicant") && CoursesFlag == 1)
        {
            System.exit(0);
        }
        userInput.setText("");

    }

    public static void main(String[] args) {
        new ChatbotGUI();
    }

}

