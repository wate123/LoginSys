import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
/**
 * Created by Jun Lin on 3/30/2017.
 */
public class LoginSysController{
    private Connection conn = null;
    private PreparedStatement pt = null;
    private ResultSet rs = null;
    private LoginSysView theView;
    private LoginSysModel theModel;


    public void LoginSysView(LoginSysView theView, LoginSysModel theModel) {
        this.theView = theView;
        this.theModel = theModel;
        //this.theView.addSubmitListener(SubmitActionPerformed());
    }
    private  void checkNameActionPerformed(ActionEvent e){
        conn = LoginSysModel.ConnectDB();
        String sql = "username=?";
        try{
            pt = conn.prepareStatement(sql);
            pt.setString(1, theView.getInName().getText());
            rs = pt.executeQuery();
            if(rs.next()){
                JOptionPane.showMessageDialog(null,"Vaild user");}
            else {
                JOptionPane.showMessageDialog(null,"Invaid Username");
            }
            }catch (Exception d){
            JOptionPane.showMessageDialog(null,d);
        }
    }
    private void SubmitActionPerformed(ActionEvent evt){
        conn = LoginSysModel.ConnectDB();
        String sql = "Select * from users_table Where username=? password=?";
        try{
            pt = conn.prepareStatement(sql);
            pt.setString(1, theView.getInName().getText());
            pt.setString(2,theView.getInPasswd().getText());
            rs = pt.executeQuery();

            if(rs.next()){
                JOptionPane.showMessageDialog(null,"Welcome user");
                LoginSysView w = new LoginSysView();
                w.welcome().setVisible(true);
            }
            else{
                JOptionPane.showMessageDialog(null,"Invaild username or password","Access Denied", JOptionPane.ERROR_MESSAGE);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Something is wrong with Mysql");
        }
    }
    public static void main(String[] args){
        LoginSysView theView = new LoginSysView();
        LoginSysModel theModel = new LoginSysModel();
        theView.LoginSysView();
        theView.setVisible(true);
    }
}
