package p3;

import java.util.List;

public class Product {
	private int productNummer;
	private String productNaam;
	private String beschrijving;
	private double prijs;

	public Product(int productNummer, String productNaam, String beschrijving, double prijs) {
		this.productNummer = productNummer;
		this.productNaam = productNaam;
		this.beschrijving = beschrijving;
		this.prijs = prijs;
	}

	public Product() {}

	public int getProductNummer() {
		return this.productNummer;
	}

	public void setProductNummer(int p) {
		this.productNummer = p;
	}

	public String getProductNaam() {
		return this.productNaam;
	}

	public void setProductNaam(String p) {
		this.productNaam = p;
	}

	public String getbeschrijving() {
		return this.beschrijving;
	}

	public void setbeschrijving(String b) {
		this.beschrijving = b;
	}

	public double getPrijs() {
		return this.prijs;
	}

	public void setPrijs(double p) {
		this.prijs = p;
	}

}