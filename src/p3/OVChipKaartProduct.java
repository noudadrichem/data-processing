package p3;

public class OVChipKaartProduct {

	private int ovproductID;
	private OVChipKaart OVChipKaart;
	private Product product;
	private String reisproductStatus;
	private String lastUpdate;

	public OVChipKaartProduct() {
	}

	public int getOvproductID() {
		return ovproductID;
	}

	public void setOvproductID(int ovproductID) {
		this.ovproductID = ovproductID;
	}

	public OVChipKaart getOVChipKaart() {
		return OVChipKaart;
	}

	public void setOVChipKaart(OVChipKaart OVChipKaart) {
		this.OVChipKaart = OVChipKaart;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String getReisproductStatus() {
		return reisproductStatus;
	}

	public void setReisproductStatus(String reisproductStatus) {
		this.reisproductStatus = reisproductStatus;
	}

	public String getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(String lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

}