package hijberneet;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.hibernate.Transaction;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Main {
	public static void main(String[] args) {
		
		System.out.println("hoi");

		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		System.out.print(ssr);
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
		SessionFactory factory = meta.getSessionFactoryBuilder().build();
		
		
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();

		Reiziger r = new Reiziger();
		r.setReizigerId(10);
		r.setAchternaam("Dijkstra");
		try {
			r.setGeboortedatum(new SimpleDateFormat("dd-mm-yy").parse("06-12-80"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		r.setVoorletters("JW");

		session.save(r);

		t.commit();
		System.out.println("successfully saved");
		factory.close();
		session.close();
	}
}
