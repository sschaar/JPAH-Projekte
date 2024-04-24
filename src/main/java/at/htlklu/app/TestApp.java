package at.htlklu.app;

import at.htlklu.entities.ArbeitspaketeEntity;
import at.htlklu.entities.MitarbeiterEntity;
import at.htlklu.entities.ProjekteEntity;
import at.htlklu.persistence.JPAUtil;
import at.htlklu.persistence.ProjekteDao;
import jakarta.persistence.EntityManager;

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

        ProjekteDao.updateProjekte(new ArbeitspaketeEntity("B999", "IntelliJ Programmierung AT"), 2);

        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        System.out.println(em.find(ProjekteEntity.class, 2));
    }
}
