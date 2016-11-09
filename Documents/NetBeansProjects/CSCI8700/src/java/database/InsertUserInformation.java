/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import database.*;
import entity.USerInformation;
import java.sql.Connection;
import java.sql.*;

/**
 *
 * @author sasan
 */
public class InsertUserInformation {

    public static boolean insert(USerInformation user) {
        Connection con = DBConnection.getConnection();
        boolean state=false;
        if (con != null) {
            System.out.println("You are connected to DB successfully!");
        } else {
            System.out.println("Sorry connection is null!");
        }

        PreparedStatement pstmt = null;

        try {

            String sql = "INSERT INTO user_information (fname, lname, address, zipcode, tel, state,email ) VALUES (?,?,?,?,?,?,?)";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, user.getfName());
            pstmt.setString(2, user.getlName());
            pstmt.setString(3, user.getAddress());
            pstmt.setString(4, user.getZipcode());
            pstmt.setString(5, user.getTel());
            pstmt.setString(6, user.getState());
            pstmt.setString(7, user.getEmail());
            pstmt.executeUpdate();
            state=true;
        } catch (SQLException e) {

            e.printStackTrace();

        } finally {

            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (Exception e) {
                    System.out.println(e);
                }
            }

        }
        return state;
    }

}
