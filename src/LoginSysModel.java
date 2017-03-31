import javax.swing.*;
import java.sql.*;

/**
 * Created by Jun Lin on 3/30/2017.
 */
public class LoginSysModel {
    private String userName;

    public void checkName(String typeName, String dataName){

    }
    public boolean getCheckName(){
        return
    }

    //return true if and only if Username is in database
    public static boolean isValidUserName(String userName){

    }

    //Password policy Check
    //1. Must have at least 8 characters
    //2. First character must be letter
    //3. Must have at least one letter and one number
    //4. Only letter or digit.
    public static boolean isValidPasswd(String passwd){
        char charPasswd;
        if(passwd.length() <= 8){
            return false;
        }
        if(!Character.isLetter(passwd.charAt(0)))
            return false;

        for (int i = 1; i < passwd.length()-1; i++) {
            charPasswd = passwd.charAt(i);
            if(!Character.isLetterOrDigit(charPasswd))
                return false;
        }
        return true;
    }

    public static Connection ConnectDB(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/info","root","8899");
            JOptionPane.showMessageDialog(null,"Connected to Database");
            return conn;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
            return null;
        }
    }
}
