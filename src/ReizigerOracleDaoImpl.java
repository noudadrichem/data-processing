import java.util.ArrayList;
import java.util.Date;

public class ReizigerOracleDaoImpl implements ReizigerDao {
	
	public ArrayList<Reiziger> reizigers;
	
	public ReizigerOracleDaoImpl() {
		reizigers = new ArrayList<Reiziger>();
	}
	
	public ArrayList<Reiziger> findAll() {
		return reizigers;
	}
	
	public ArrayList<Reiziger> findByGBdatum(Date zoekDatum) {
		ArrayList<Reiziger> tempReiz = new ArrayList<Reiziger>();

		for(Reiziger r : reizigers) {
			if(r.getGBDatum().equals(zoekDatum)) {
				tempReiz.add(r);
			}
		}
		
		return tempReiz;
	}

	
	public Reiziger save(Reiziger reiziger) {
		if(!reizigers.contains(reiziger)) {
			reizigers.add(reiziger);
		}

		return reiziger;
	}
	
	public Reiziger update(Reiziger reiziger) {
		if(reizigers.contains(reiziger)) {
			reizigers.remove(reiziger);
			reizigers.add(reiziger);
		}
		return reiziger;
	}
	
	public boolean delete(Reiziger reiziger) {
		if(reizigers.contains(reiziger)) {
			reizigers.remove(reiziger);
			return true;
		} else {
			return false;
		}
	}
}
