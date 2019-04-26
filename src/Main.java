import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
	public static void main(String[] args) {
		
		ReizigerOracleDaoImpl db = new ReizigerOracleDaoImpl();
		
		try {
			
			Date datum1 = new SimpleDateFormat("dd/MM/yyyy").parse("13/05/1998");
			
			Reiziger r1 = new Reiziger("Freek Fonk", datum1);
			db.save(r1);
			Reiziger r2 = new Reiziger("Noud Adrichem");
			db.save(r2);
			
			for(Reiziger r : db.findAll()) {
				System.out.println(r);
			}
			
			db.delete(r2);
			
			System.out.println(db.findByGBdatum(datum1));
			
		} catch(Exception e) {}
		
	}
}
