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
    private JFrame back = new JFrame();
    private JFrame welcome = new JFrame();
    private JLabel welText = new JLabel();


    public void LoginSysView(){

        title = new JLabel("Username",Label.RIGHT)
        checkButton = new JButton("Check");
        submitButton = new JButton("Submit");
        back.setForeground(Color.blue);
        back.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        back.setSize(1000,1000);
        loginPan.setSize(600,600);
        back.add(loginPan);
        loginPan.add(title);
    }

    public JFrame welcome(){
        welText.setText("Welcome "+getInName());
        welcome.add(welText);
        return welcome;
    }

    public void addSubmitListener(ActionListener listenSubmit){
        submitButton.addActionListener(listenSubmit);
    }
    public void dispayPassMessage(String passMessage){
        JOptionPane.showMessageDialog(this,passMessage);
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
