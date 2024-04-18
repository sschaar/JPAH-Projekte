package at.htlklu.app;

import at.htlklu.entities.MitarbeiterEntity;
import at.htlklu.persistence.ProjekteDao;

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
    }
}
