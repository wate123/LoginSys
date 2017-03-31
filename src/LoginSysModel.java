import javax.swing.*;
import java.awt.event.ActionEvent;
import java.sql.*;

/**
 * Created by Jun Lin on 3/30/2017.
 */
public class LoginSysModel {
    private String userName;
    private Connection conn = null;
    private PreparedStatement pt = null;
    private ResultSet rs = null;
    private LoginSysView theView;

    //Check Username Only
    public void checkName(ActionEvent evt) {
        conn = ConnectDB();
        try {
            String sql = "Select * from users_table Where username=?";
            pt = conn.prepareStatement(sql);
            pt.setString(1,theView.getInName().getText());
            rs = pt.executeQuery();
            if(rs.next()){
                theView.displayUsernameVaild();
            }
            else {
                theView.displayErrorMessage("Username is not in DataBase","Username mismatch");
            }
        }catch(Exception e){
            theView.displayErrorMessage("Something is wrong with Mysql","SQL Error");
        }
    }
    public void checkUnamePasswd(){
        conn = ConnectDB();
        String sql = "Select * from users_table Where username=? password=?";
        try{
            pt = conn.prepareStatement(sql);
            pt.setString(1,theView.getInName().getText());
            pt.setString(2,theView.getInPasswd().getText());
            rs = pt.executeQuery();

            if(rs.next()){
                theView.displayLoginMessage();
                LoginSysView w = new LoginSysView();
                w.welcome().setVisible(true);
            }
            else{
                theView.displayErrorMessage("Invaild username or password","Access Denied");
            }
        }catch(Exception e){
            theView.displayErrorMessage("Something is wrong with Mysql","SQL Error");
        }
    }

    //return true if and only if Username is in database
//    public static boolean isValidUserName(String userName){
//        return null;
//    }

//    //Password policy Check
//    //1. Must have at least 8 characters
//    //2. First character must be letter
//    //3. Must have at least one letter and one number
//    //4. Only letter or digit.
//    public static boolean isValidPasswd(String passwd){
//        char charPasswd;
//        if(passwd.length() <= 8){
//            return false;
//        }
//        if(!Character.isLetter(passwd.charAt(0)))
//            return false;
//
//        for (int i = 1; i < passwd.length()-1; i++) {
//            charPasswd = passwd.charAt(i);
//            if(!Character.isLetterOrDigit(charPasswd))
//                return false;
//        }
//        return true;
//    }

    public static Connection ConnectDB(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/info","root","8899");
            JOptionPane.showMessageDialog(null,"Connected to Database");
            return conn;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
            return null;
        }
    }
}
