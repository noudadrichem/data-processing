package hijberneet;

import hijberneet.dao.OVChipkaartService;
import hijberneet.dao.ReizigerService;

import java.sql.Date;
import java.time.ZoneId;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        OVChipkaart ovChipkaart = OVChipkaartService.getInstance().findById(35283);
        System.out.print("OVChipkaart (KAARTNUMMER=35283)");

        System.out.print(ovChipkaart);
        System.out.print(ovChipkaart.getReiziger());


        System.out.print("Reiziger (ID=5)");
        ReizigerService.getInstance().getReizigerDao().openCurrentSession();
        Reiziger reiziger = ReizigerService.getInstance().getReizigerDao().findById(5);
        System.out.print(reiziger);

        System.out.print("Reiziger's OVChipkaarten (same instance as previous)");
        reiziger.getOVChipkaarten().forEach(r -> System.out.print(r));


        System.out.print("Update Reiziger (same instance as previous; achternaam=TEST)");
        reiziger.setAchternaam("TEST");
        ReizigerService.getInstance().getReizigerDao().update(reiziger);
        ReizigerService.getInstance().getReizigerDao().closeCurrentSession();

        // Load object from database
        reiziger = ReizigerService.getInstance().findById(5);
        System.out.print(reiziger);

        // Revert back
        reiziger.setAchternaam("Manrho");
        ReizigerService.getInstance().update(reiziger);

        if (true) {
            System.out.print("create Reiziger with OVChipkaart");
            reiziger = new Reiziger(6, "Bart", "den", "Hamer",
                Date.valueOf(new GregorianCalendar(2000, Calendar.FEBRUARY, 10)
                    .toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDate()));

            ovChipkaart = new OVChipkaart(12345,
                Date.valueOf(new GregorianCalendar(2019, Calendar.DECEMBER, 10)
                    .toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDate()),
                2, 50f, reiziger);
            reiziger.setOVChipkaarten(new ArrayList<>(Collections.singletonList(ovChipkaart)));

            ReizigerService.getInstance().persist(reiziger);

            reiziger = ReizigerService.getInstance().findById(6);
            System.out.print(reiziger);
        }


        System.out.print("Delete Reiziger");

        ReizigerService.getInstance().delete(reiziger);

        reiziger = ReizigerService.getInstance().findById(6);

        if (reiziger == null) {
            System.out.print("Reiziger verwijderd");
        } else {
            System.out.print("Reiziger is niet verwijderd");
        }

        HibernateUtil.shutdown();
    }

}
