import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
/**
 * Created by jun on 3/29/17.
 */
public class LoginSysView extends JFrame {
    private JLabel passwdLab, title,userLab;
    //Create a Text Field to input username and limit the username to 10 Digits.
    private JTextField inName ;
    //Create a Text Field to input password and limit the password to 30 Digits.
    private JPasswordField inPasswd;
    private JButton checkButton;
    //Create a submit button
    private JButton submitButton;
    //Create a Login panel
    private JPanel loginPan = new JPanel();
    private JFrame welcome = new JFrame();
    private JLabel welText = new JLabel();



    public LoginSysView(){
        title = new JLabel("Welcome to My World!");
        checkButton = new JButton("Check");
        submitButton = new JButton("Submit");
        userLab = new JLabel("Username:");
        passwdLab = new JLabel("Password:");

        inName = new JTextField();
        inPasswd= new JPasswordField();
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        inPasswd.setToolTipText("<html>"
                +"1. Must have at least 8 characters"
                +"<br>"
                +"2. First character must be letter"
                +"<br>"
                +"3. Must have at least one letter and one number"
                +"<br>"
                +"4. Only letter or digit." +
                "</html>");
        userLab.setBounds(10,150,100,20);
        passwdLab.setBounds(10,175,100,20);
        inName.setBounds(80,152,100,20);
        inPasswd.setBounds(80,178,100,20);
        checkButton.setBounds(10,220,70,30);
        submitButton.setBounds(105, 220,74,30);
        title.setBounds(30,10,200,80);
        this.add(title);
        this.add(userLab);
        this.add(passwdLab);
        this.add(checkButton);
        this.add(submitButton);
        this.add(inName);
        this.add(inPasswd);
        this.setSize(200,300);
        this.setVisible(true);

    }

    public JFrame welcome(){
        welText.setText("Welcome "+getInName());
        welcome.add(welText);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        return welcome;
    }

    public void addCheckListener(ActionListener listenCheck){
        checkButton.addActionListener(listenCheck);
    }

    public void addSubmitListener(ActionListener listenSubmit){
        submitButton.addActionListener(listenSubmit);
    }
    public void displayUsernameVaild(){
        JOptionPane.showMessageDialog(this,"Vaild Username");
    }
    public void displayLoginMessage(){
         JOptionPane.showMessageDialog(this,"Welcome "+getInName());
    }

    public void displayErrorMessage(String errorMessage, String til){
        JOptionPane.showMessageDialog(this,errorMessage,til,JOptionPane.ERROR_MESSAGE);
    }

    public String getInName() {
        return inName.getText();
    }

    public String getInPasswd() {
        return new String(inPasswd.getPassword());
    }
}
