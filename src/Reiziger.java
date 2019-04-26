import java.util.Date;

public class Reiziger {
	
	private String naam;
	private Date gbdatum;
	
	public Reiziger(String naam, Date gbdatum) {
		this.naam = naam;
		this.gbdatum = gbdatum;
	}
	
	public Reiziger(String naam) {
		this(naam, null);
	}
	
	public String getNaam() {
		return naam;
	}
	
	public void setNaam(String nieuweNaam) {
		naam = nieuweNaam;
	}
	
	public Date getGBDatum() {
		return gbdatum;
	}
	
	public void setGBDatum(Date nieuweDatum) {
		gbdatum = nieuweDatum;
	}
	
	public String toString() {
		return "Reiziger: " + naam + " " + gbdatum;
	}

}
