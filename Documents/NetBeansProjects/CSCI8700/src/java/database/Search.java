package database;


import java.sql.*;


public class Search {

   
    static boolean f;

    public static boolean checkPassword( String userName, String password){

        Connection con= DBConnection.getConnection();
        Statement stmt=null;
        ResultSet rs=null;
        f=false;
   
        String sql="SELECT * FROM user_check";

        
        try{
            stmt=con.createStatement();
            rs=stmt.executeQuery(sql);
            while(rs.next()){
                     if(rs.getString(2).trim().equals(userName) && rs.getString(3).trim().equals(password)){
                     System.out.println("UserName="+ rs.getString(2) + "   Password= "+rs.getString(3));
                     f=true;
                 }
            }

        } catch(Exception e){
            e.printStackTrace();
        }


        finally {

              if (rs != null) try { rs.close(); } catch(Exception e) { System.out.println(e); }
              if (stmt != null) try { stmt.close(); } catch(Exception e) { System.out.println(e); }
              if (con != null) try { con.close(); } catch(Exception e) { System.out.println(e); }

          }
        
        return f;
    }
}
