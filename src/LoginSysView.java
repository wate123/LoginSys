import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
/**
 * Created by jun on 3/29/17.
 */
public class LoginSysView extends JFrame {
    private JLabel title;
    private JLabel userLab = new JLabel();
    private JLabel passwdLab = new JLabel();
    //Create a Text Field to input username and limit the username to 10 Digits.
    private JTextField inName = new JTextField(10);
    //Create a Text Field to input password and limit the password to 10 Digits.
    private JPasswordField inPasswd = new JPasswordField(10);
    //Create a check button
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
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        title = new JLabel("Welcome to My System!");
        userLab = new JLabel("Username");
        checkButton = new JButton("Check");
        submitButton = new JButton("Submit");
        setForeground(Color.blue);
        setSize(400,100);
        setVisible(true);
        loginPan.setSize(600,600);
        add(loginPan);
        loginPan.add(title);
        loginPan.add(userLab);
        loginPan.add(inName);
        loginPan.add(checkButton);
        loginPan.setVisible(true);
    }

    public JFrame welcome(){
        welText.setText("Welcome "+getInName());
        welcome.add(welText);
        return welcome;
    }

    public void addSubmitListener(ActionListener listenSubmit){
        submitButton.addActionListener(listenSubmit);
    }
    public void dispayPassMessage(){
         JOptionPane.showMessageDialog(null,"Welcome "+getInName());
    }

    public void dispayErrorMessage(String errorMessage){
        JOptionPane.showMessageDialog(this,errorMessage);
    }

    public JTextField getInName() {
        return inName;
    }

    public JPasswordField getInPasswd() {
        return inPasswd;
    }
}
