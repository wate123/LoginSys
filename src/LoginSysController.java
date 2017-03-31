import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
//        this.theView.addSubmitListener(new clickListener());
//        this.theView.addCheckListener(new clickListener());

    }

    class clickListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            theModel.checkName(e);
        }
    }


    public static void main(String[] args){
        LoginSysView theView = new LoginSysView();
        LoginSysModel theModel = new LoginSysModel();
        LoginSysController theController = new LoginSysController(theView,theModel);
        theView.LoginSysView();
        theModel.checkUnamePasswd();
        theView.setVisible(true);
    }

}
