package at.htlklu.app;

import at.htlklu.entities.ArbeitspaketeEntity;
import at.htlklu.entities.MitarbeiterEntity;
import at.htlklu.entities.ProjekteEntity;
import at.htlklu.persistence.JPAUtil;
import at.htlklu.persistence.ProjekteDao;
import jakarta.persistence.EntityManager;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

public class TestApp {
    public static void main(String[] args) {
        /*
        List<MitarbeiterEntity> allMitarbeiter = ProjekteDao.findAllMitarbeiter();
        for(MitarbeiterEntity mt : allMitarbeiter){
            System.out.println(mt);
        }
         */

        // System.out.println("Polzen wohnt in: "ProjekteDao.findAddressByName("Polzen"));

        /*
        List<String> duplicateFirstName = ProjekteDao.findDuplicateFirstNames();
        for (String mt: duplicateFirstName
             ) {
            System.out.println(mt);
        }
         */

        // System.out.println(ProjekteDao.findYoungestMitarbeiter());

        /*
        List<ArbeitspaketeEntity> allArbeitspakete = ProjekteDao.findAllArbeitspakete();
            for(ArbeitspaketeEntity at : allArbeitspakete){
                System.out.println(at);
            }

         */

        // System.out.println(ProjekteDao.findArbeitspaketByCode("WSTP"));

        /*
        ProjekteDao.updateProjekte(new ArbeitspaketeEntity("B999", "IntelliJ Programmierung AT"), 2);

        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        System.out.println(em.find(ProjekteEntity.class, 2));
        List<ProjekteEntity> projekteByCode = ProjekteDao.findProjectsByCode("WSTP");

        for (ProjekteEntity pt : projekteByCode) {
            System.out.println(pt);
        }

        //  System.out.println(ProjekteDao.findArbeitspaketByCode("WSTP"));

         */

        /*
        ProjekteEntity pTest = new ProjekteEntity("Test", "0000");
        ProjekteDao.insertProjekt(pTest);

         */

        /*
        ArbeitspaketeEntity aTest = new ArbeitspaketeEntity("0000", "Test");
        ProjekteDao.updateProjekte(aTest, 7);

         */

        /*
        ArbeitspaketeEntity aTest = new ArbeitspaketeEntity("0000", "Test");
        ProjekteDao.insertArbeitspaket(aTest);
        MitarbeiterEntity mTest = new MitarbeiterEntity("Test", "Test", "m", LocalDate.of(1999, 9, 22), "Test", "0000", "Test", "Test");
        ProjekteDao.insertMitarbeiter(mTest);
        ProjekteDao.updateArbeitspaketeByMitarbeiter(mTest, 588, 20.0, LocalDate.now(), "Test");

         */

        MitarbeiterEntity mTest2 = new MitarbeiterEntity("test", "test", "m", LocalDate.of(2001, 3, 5), "test", "0000", "test", "test");
        ProjekteDao.updateArbeitspaketeByMitarbeiter(mTest2, 588, 10.0, LocalDate.now(), "test");
    }
}
