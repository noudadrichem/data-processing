package opdracht1_1;

import java.sql.*;

public class Con {
  public static void main(String[] args) {
    try {

      System.out.println("Maakt connectie");
      Connection con = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:49161/xe", "NOUD", "test1234");
      System.out.println("Heeft connectie");

      String selectQuery = "SELECT * FROM cursussen WHERE TYPE = ?";
      PreparedStatement selectPrepared = con.prepareStatement(selectQuery);
      selectPrepared.setString(1, "ALG");
      ResultSet selectRes = selectPrepared.executeQuery();
      
      while(selectRes.next()) {
        System.out.println(selectRes.getString("code") + " : " + selectRes.getString("type") + " : " + selectRes.getString("omschrijving"));
      }

      String insertQuery = "INSERT INTO cursussen (code, omschrijving, type, lengte) VALUES (?, ?, ?, ?)";
      PreparedStatement insertPrepared = con.prepareStatement(insertQuery);
      insertPrepared.setString(1, "BBB");
      insertPrepared.setString(2, "Lorem ipsum dolor sit amet");
      insertPrepared.setString(3, "ALG");
      insertPrepared.setString(4, "3");


      String updateQuery = "UPDATE cursussen SET omschrijving = ? WHERE code = ?";
      PreparedStatement updatePrepared = con.prepareStatement(updateQuery);
      updatePrepared.setString(1, "Nieuwe omschrijving");
      updatePrepared.setString(2, "PRO");

    
      String deleteQuery = "DELETE FROM cursussen WHERE code = ?";
      PreparedStatement deletePrepared = con.prepareStatement(deleteQuery);
      deletePrepared.setString(1, "PLS");


      con.close();
    } catch (SQLException ex) {
      // System.out.print("SQLException: " + ex.getErrorCode() + " " + ex.getMessage());
      System.out.print(ex);
    }
  }
}
