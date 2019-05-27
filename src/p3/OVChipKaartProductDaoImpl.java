package p3;

import java.sql.*;
import java.util.*;

public class OVChipKaartProductDaoImpl extends OracleBaseDao implements OVChipKaartProductDao  {

  public OVChipKaartProductDaoImpl() {
  }

  public OVChipKaartProduct findById(int id) {
    OVChipKaartProduct ov_pr = new OVChipKaartProduct();

    try (Connection con = super.getConnection()) {
      PreparedStatement stmt = con.prepareStatement("SELECT * FROM ov_chipkaart_product WHERE ovproductid = ?");
      stmt.setInt(1, id);
      ResultSet rs = stmt.executeQuery();

      if (rs.next()) {
        OVChipKaart o = new OVChipKaart();
        Product p = new Product();

        ov_pr.setOvproductID(rs.getInt("ovproductid"));
        ov_pr.setReisproductStatus(rs.getString("reisproductstatus"));
        ov_pr.setLastUpdate(rs.getString("reisproductstatus"));
        o.setKaartnummer(rs.getInt("kaartnummer"));
        p.setProductNummer(rs.getInt("productnummer"));
        ov_pr.setOVChipKaart(o);
        ov_pr.setProduct(p);
      }

    } catch (SQLException sqle) {
      sqle.printStackTrace();
    }
    return ov_pr;
  }

  public OVChipKaartProduct findByIdInOVChipKaart(int id) {
    OVChipKaartProduct ov_p = new OVChipKaartProduct();
    try (Connection con = super.getConnection()) {
      PreparedStatement stmt = con
          .prepareStatement("SELECT ov_c_p.ovproductid, ov_c_p.reisproductstatus, ov_c.kaartnummer, ov_c.saldo "
              + "FROM ov_chipkaart_product ov_c_p, ov_chipkaart ov_c "
              + "WHERE ov_c.kaartnummer = ov_c_p.kaartnummer AND ov_c.kaartnummer = ?");
      stmt.setInt(1, id);
      ResultSet rs = stmt.executeQuery();

      if (rs.next()) {
        int ovproductID = rs.getInt("ovproductid");
        String reisproductStatus = rs.getString("reisproductstatus");
        int kaartNummer = rs.getInt("kaartnummer");
        double saldo = rs.getDouble("saldo");

        OVChipKaart o = new OVChipKaart();
        ov_p.setOvproductID(ovproductID);
        ov_p.setReisproductStatus(reisproductStatus);
        o.setKaartnummer(kaartNummer);
        o.setSaldo(saldo);
        ov_p.setOVChipKaart(o);
      }
      // con.close();
    } catch (SQLException sqle) {
      sqle.printStackTrace();
    }
    return ov_p;
  }

  public ArrayList<OVChipKaartProduct> findByIdInBothTables(int id) {
    ArrayList<OVChipKaartProduct> ov_pList = new ArrayList<OVChipKaartProduct>();
    try (Connection con = super.getConnection()) {
      PreparedStatement stmt = con.prepareStatement(
          "SELECT ov_c_p.ovproductid, ov_c_p.reisproductstatus, ov_c.kaartnummer, ov_c.saldo, p.productnaam "
              + "FROM ov_chipkaart_product ov_c_p, ov_chipkaart ov_c, product p "
              + "WHERE ov_c.kaartnummer = ov_c_p.kaartnummer AND ov_c_p.kaartnummer = ?");

      stmt.setInt(1, id);
      ResultSet rs = stmt.executeQuery();

      while (rs.next()) {
        OVChipKaartProduct ov_product = new OVChipKaartProduct();
        int ovproductID = rs.getInt("ovproductid");
        String reisproductStatus = rs.getString("reisproductstatus");
        int kaartNummer = rs.getInt("kaartnummer");
        double saldo = rs.getDouble("saldo");
        String productNaam = rs.getString("productnaam");

        OVChipKaart kaart = new OVChipKaart();
        Product p = new Product();
        ov_product.setOvproductID(ovproductID);
        ov_product.setReisproductStatus(reisproductStatus);
        kaart.setKaartnummer(kaartNummer);
        kaart.setSaldo(saldo);
        p.setProductNaam(productNaam);
        ov_product.setOVChipKaart(kaart);
        ov_product.setProduct(p);
        ov_pList.add(ov_product);
      }
      rs.close();
      stmt.close();

    } catch (SQLException sqle) {
      sqle.printStackTrace();
    }

    return ov_pList;
  }
}