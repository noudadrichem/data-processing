package p3;

import java.sql.*;
import java.util.ArrayList;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReizigerOracleDaoImpl extends OracleBaseDao implements ReizigersDao {
    @Override
    public List<Reiziger> findAll() throws SQLException {
        Connection connection = getConnection();
        List<Reiziger> reizigers = new ArrayList<>();
        String query = "SELECT * FROM REIZIGER";
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            reizigers.add(toReiziger(resultSet));
        }
        statement.close();
        connection.close();
        return reizigers;
    }

    @Override
    public List<Reiziger> findById(int reizigerId) throws SQLException {
        Connection connection = getConnection();
        List<Reiziger> reizigers = new ArrayList<>();
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM REIZIGER WHERE REIZIGERID = ?");
        statement.setInt(1, reizigerId);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            reizigers.add(toReiziger(resultSet));
        }
        return reizigers;
    }

    @Override
    public Reiziger save(Reiziger reiziger) throws SQLException {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO REIZIGER (REIZIGERID, ACHTERNAAM, VOORLETTERS, GEBORTEDATUM) VALUES (?, ?, 'J', ?)");
        preparedStatement.setInt(1, reiziger.getReizigerId());
        preparedStatement.setString(2, reiziger.getNaam());
        preparedStatement.setDate(3, reiziger.getGbdatum());
        preparedStatement.execute();
        preparedStatement.close();
        connection.close();
        return reiziger;

    }

    @Override
    public Reiziger update(Reiziger reiziger) throws SQLException {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("UPDATE REIZIGER SET ACHTERNAAM = ? AND GEBORTEDATUM = ? WHERE REIZIGERID = ?");
        preparedStatement.setString(1, reiziger.getNaam());
        preparedStatement.setDate(2, reiziger.getGbdatum());
        preparedStatement.setInt(3, reiziger.getReizigerId());
        preparedStatement.execute();
        preparedStatement.close();
        connection.close();
        return reiziger;
    }

    @Override
    public boolean delete(Reiziger reiziger) throws SQLException {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM REIZIGER WHERE REIZIGERID = ?");
        preparedStatement.setInt(1, reiziger.getReizigerId());
        preparedStatement.execute();
        preparedStatement.close();
        connection.close();
        return true;
    }

    @Override
    public void closeConnection() {
        // getConnection().close();
    }

    private Reiziger toReiziger(ResultSet resultSet) throws SQLException {
        Reiziger reiziger = new Reiziger(
                resultSet.getInt("REIZIGERID"),
                resultSet.getString("ACHTERNAAM"),
                resultSet.getDate("GEBORTEDATUM")
        );
        OVChipKaartOracleDaoImpl ovChipKaartOracleDao = new OVChipKaartOracleDaoImpl();
        reiziger.setOvchipkaarten(ovChipKaartOracleDao.findByReiziger(reiziger.getReizigerId()));
        return reiziger;
    }
}