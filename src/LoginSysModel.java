import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.*;
import java.sql.*;
import java.util.Scanner;
/**
 * Created by Jun Lin on 3/30/2017.
 */
public class LoginSysModel {
    private LoginSysView theView;
    //Check Username Only
    public  boolean check(String username) {
        // hardcoded username and password
        if (username.equals("admin") ) {
            return true;
        }
        return false;
    }
    public static boolean authenticate(String username, String password) {
        // hardcoded username and password
        if (username.equals("admin") && password.equals("admin")) {
            return true;
        }
        return false;
    }
}






