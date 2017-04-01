import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.sql.*;
/**
 * Created by Jun Lin on 3/30/2017.
 */
public class LoginSysController {
    private LoginSysView theView;
    private LoginSysModel theModel;

    public LoginSysController (LoginSysView theView, LoginSysModel theModel) {
        this.theView = theView;
        this.theModel = theModel;
        this.theView.addSubmitListener(new clickListener());
        this.theView.addCheckListener(new subListener());

    }

    class subListener implements  ActionListener{
        public void actionPerformed(ActionEvent e) {
            if(theModel.check(theView.getInName())){
                JOptionPane.showMessageDialog(null,
                        "Hi " + theView.getInName() + "! You Username is On file.",
                        "Login",JOptionPane.INFORMATION_MESSAGE);
            }
            else{
                theView.displayErrorMessage("Username not found","Stop");
            }
        }
    }
     class clickListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if(theModel.authenticate(theView.getInName(), theView.getInPasswd())){
                JOptionPane.showMessageDialog(null,
                        "Hi " + theView.getInName() + "! You have successfully logged in.",
                        "Login",JOptionPane.INFORMATION_MESSAGE);
            }
            else{
                theView.displayErrorMessage("Username or Password incorrect","Access Denial");
            }

    }}


    public static void main(String[] args){
        LoginSysView theView = new LoginSysView();
        LoginSysModel theModel = new LoginSysModel();
        LoginSysController theController = new LoginSysController(theView,theModel);

        theView.setVisible(true);
    }

}
