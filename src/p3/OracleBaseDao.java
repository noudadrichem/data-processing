package p3;

import java.sql.*;

public class OracleBaseDao {

    protected Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:oracle:thin:@//localhost:49161/xe", "NOUD", "test1234");
    }

    public void closeConnection() throws SQLException {}
}