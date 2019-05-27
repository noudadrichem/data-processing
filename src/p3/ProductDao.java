package p3;

import java.sql.SQLException;
import java.util.List;

public interface ProductDao {
    public List<Product> getProducts() throws SQLException;
    public List<Product> getProductsByKaartNummer(int kaartnummer) throws SQLException;
	public Product findById(int productNummer);
	public Product save(Product product);
	public List<Product> findAll();
	public boolean delete(Product product);
}