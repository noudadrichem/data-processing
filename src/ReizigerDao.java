import java.util.*;


public interface ReizigerDao {
	public ArrayList<Reiziger> findAll(); 
	
	public ArrayList<Reiziger> findByGBdatum(Date zoekdatum);
	
	public Reiziger save(Reiziger reiziger);
	
	public Reiziger update(Reiziger reiziger);
	
	public boolean delete(Reiziger reiziger);
}
