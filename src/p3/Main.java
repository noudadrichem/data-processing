package p3;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        
			System.out.println("Start");
			ProductOracleDaoImpl ProductOracleDaoImpl = new ProductOracleDaoImpl();

			System.out.print(ProductOracleDaoImpl.getProducts());
			OVChipKaartProductDaoImpl ovDao = new OVChipKaartProductDaoImpl();
        
      System.out.print(ProductOracleDaoImpl);

			// Selecteer een product uit de producttabel met id 1
			System.out.println("Product met id 1");
			System.out.println("Productnaam: " + ProductOracleDaoImpl.findById(1).getProductNaam());
			System.out.println("Productbeschrijving: " + ProductOracleDaoImpl.findById(1).getbeschrijving());
			System.out.println("Productprijs: " + ProductOracleDaoImpl.findById(1).getPrijs());

		// Selecteer een relatie uit de koppeltabel met relatie id 1
		// System.out.println("\nRelatie uit de koppeltabel met id 1");
		// System.out.println("Kaartnummer: " + ovDao.findById(1).getOVChipkaart().getKaartnummer());
		// System.out.println("Productnummer: " + ovDao.findById(1).getProduct().getProductNummer());
		// System.out.println("Reisproduct status: " + ovDao.findById(1).getReisproductStatus());
		// System.out.println("Laatste update: " + ovDao.findById(1).getLastUpdate());

		// // Selecteer de relatie van kaartnummer 57401
		// System.out.println("\nSelecteer de relatie van kaartnummer 46392");
		// System.out.println("Kaartnummer: " + ovDao.findByIdInOVChipkaart(46392).getOVChipkaart().getKaartnummer());
		// System.out.println("KoppelID: " + ovDao.findByIdInOVChipkaart(46392).getOvproductID());
		// System.out.println("Reisproduct status: " + ovDao.findByIdInOVChipkaart(46392).getReisproductStatus());
		// System.out.println("saldo: " + ovDao.findByIdInOVChipkaart(46392).getOVChipkaart().getSaldo());

		// // Vind alle informatie over kaartnummer 57401
		// System.out.println("\nVind alle informatie over kaartnummer 46392");
		// for (OVChipkaart_Product ov_p : ovDao.findByIdInBothTables(46392)) {
		// 	System.out.println("Kaartnummer: " + ov_p.getOVChipkaart().getKaartnummer());
		// 	System.out.println("ov_productID: " + ov_p.getOvproductID());
		// 	System.out.println("Reisproduct status: " + ov_p.getReisproductStatus());
		// 	System.out.println("productNaam: " + ov_p.getProduct().getProductNaam() + "\n");
		// 	System.out.println("saldo: " + ov_p.getOVChipkaart().getSaldo());
		// }

    }
}