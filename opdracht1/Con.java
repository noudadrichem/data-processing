package opdracht1;

import java.sql.*;

public class Con {

  public static void main(String[] args) {
    try {
      System.out.println("Maakt connectie");
      Connection con = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:49161/xe", "NOUD", "test1234");
      System.out.println("Heeft connectie");

      Statement stmt = con.createStatement();
      
      ResultSet rs = stmt.executeQuery("SELECT naam FROM medewerkers");

      while(rs.next()) {
        System.out.println(rs.getString("naam"));
      }

      con.close();

    } catch (SQLException ex) {
      System.out.print("SQLException: " + ex.getErrorCode() + " " + ex.getMessage());
    }
  }
}
