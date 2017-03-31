import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
/**
 * Created by jun on 3/29/17.
 */
public class LoginSysView extends JFrame {
    private JLabel passwdLab = new JLabel();
    //Create a Text Field to input username and limit the username to 10 Digits.
    private JTextField inName = new JTextField(10);
    //Create a Text Field to input password and limit the password to 30 Digits.
    private JPasswordField inPasswd = new JPasswordField(30);
    private JButton checkButton;
    //Create a submit button
    private JButton submitButton;
    //Create a Login panel
    private JPanel loginPan = new JPanel();
    private JFrame welcome = new JFrame();
    private JLabel welText = new JLabel();


    public void LoginSysView(){
        Components();
    }

    private void Components(){

        JLabel title = new JLabel("Welcome to My System!", SwingConstants.CENTER);
        JLabel userLab = new JLabel("Username", JLabel.RIGHT);
        checkButton = new JButton("Check");
        submitButton = new JButton("Submit");
        //Multiline Tips for password criteria
        inPasswd.setToolTipText("<html>"
                +"1. Must have at least 8 characters"
                +"<br>"
                +"2. First character must be letter"
                +"<br>"
                +"3. Must have at least one letter and one number"
                +"<br>"
                +"4. Only letter or digit." +
                "</html>");
        setTitle("Log into Jun's DataBase");
        this.setSize(400,300);
        setVisible(true);

        userLab.setVerticalTextPosition(JLabel.CENTER);
        //Focus on the Username input field
        inName.requestFocus();
        add(loginPan);
        loginPan.add(title);
        loginPan.add(userLab);
        loginPan.add(inName);
        loginPan.add(checkButton);
        loginPan.setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public JFrame welcome(){
        welText.setText("Welcome "+getInName());
        welcome.add(welText);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        return welcome;
    }

//    public void addCheckListener(ActionListener listenCheck){
//        checkButton.addActionListener(listenCheck);
//    }
//
//    public void addSubmitListener(ActionListener listenSubmit){
//        submitButton.addActionListener(listenSubmit);
//    }
    public void displayUsernameVaild(){
        JOptionPane.showMessageDialog(this,"Vaild Username");
    }
    public void displayLoginMessage(){
         JOptionPane.showMessageDialog(this,"Welcome "+getInName());
    }

    public void displayErrorMessage(String errorMessage, String til){
        JOptionPane.showMessageDialog(this,errorMessage,til,JOptionPane.ERROR_MESSAGE);
    }

    public JTextField getInName() {
        return inName;
    }

    public JPasswordField getInPasswd() {
        return inPasswd;
    }
}
