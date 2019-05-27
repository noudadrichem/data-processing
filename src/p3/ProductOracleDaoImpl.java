package p3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductOracleDaoImpl extends OracleBaseDao implements ProductDao {

    @Override
    public List<Product> getProducts() throws SQLException {
        List<Product> products = new ArrayList<>();
        Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM PRODUCT");
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            products.add(toProduct(resultSet));
        }
        return products;
    }

    @Override
    public List<Product> getProductsByKaartNummer(int kaartnummer) throws SQLException {
        List<Product> products = new ArrayList<>();
        Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement(
                "SELECT PRODUCT.* FROM OV_CHIPKAART_PRODUCT, PRODUCT WHERE PRODUCT.PRODUCTNUMMER = OV_CHIPKAART_PRODUCT.PRODUCTNUMMER AND PRODUCT.PRODUCTNUMMER = ?");
        statement.setInt(1, kaartnummer);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            products.add(toProduct(resultSet));
        }
        return products;
    }

    private Product toProduct(ResultSet resultSet) throws SQLException {
        OVChipKaartOracleDaoImpl chipKaartOracleDao = new OVChipKaartOracleDaoImpl();
        return new Product(
            resultSet.getInt(1), 
            resultSet.getString(2), 
            resultSet.getString(3), 
            resultSet.getDouble(4),
            chipKaartOracleDao.findByProduct(resultSet.getInt(1))
        );
        return null;
    }

    public Product save(Product product) {
        try {
            Connection conn = getConnection();
            String sql = "INSERT INTO PRODUCT(productnummer, productnaam, beschrijving, prijs) VALUES(?,?,?,?)";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, product.getProductNummer());
            preparedStatement.setString(2, product.getProductNaam());
            preparedStatement.setString(3, product.getbeschrijving());
            preparedStatement.setDouble(4, product.getPrijs());
            preparedStatement.executeUpdate();
            preparedStatement.close();
            return product;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
    }

    public Product update(Product product) {
        try {
            Connection conn = getConnection();
            String sql = "Update OV_CHIPKAART " + "SET productnaam = ?," + "beschrijving = ?," + "prijs = ?,"
                    + "WHERE productnummer = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, product.getProductNaam());
            preparedStatement.setString(2, product.getbeschrijving());
            preparedStatement.setDouble(3, product.getPrijs());
            preparedStatement.setInt(4, product.getProductNummer());
            preparedStatement.executeUpdate();
            preparedStatement.close();
            return product;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public boolean delete(Product product) {
        try {
            Connection conn = getConnection();
            String sql = "DELETE FROM product WHERE productnummer = " + product.getProductNummer();
            Statement statement = conn.createStatement();
            statement.executeUpdate(sql);
            boolean result = true;
            return result;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public List<Product> findAll() {
        try {
            Connection conn = getConnection();
            String sql = "SELECT * FROM product";
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            List<Product> list = new ArrayList<>();
            Product product;
            while (rs.next()) {
                product = new Product(rs.getInt("productnummer"), rs.getString("productnaam"),
                        rs.getString("beschrijving"), rs.getDouble("prijs"));
                list.add(product);
            }
            rs.close();
            statement.close();
            return list;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Product findById(int productNummer) {
        try {
            Connection conn = getConnection();
            Statement stmt = conn.createStatement();
            String query = "SELECT * FROM product WHERE productnummer = " + productNummer;
            ResultSet rs = stmt.executeQuery(query);
            Product product = null;
            while (rs.next()) {
                product = new Product(rs.getInt("productnummer"), rs.getString("productnaam"),
                        rs.getString("beschrijving"), rs.getDouble("prijs"));
            }
            return product;
        } catch (SQLException e1) {
            e1.printStackTrace();
            return null;
        }
    }
}