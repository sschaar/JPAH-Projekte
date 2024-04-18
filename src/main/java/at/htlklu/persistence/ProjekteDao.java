package at.htlklu.persistence;

import at.htlklu.entities.MitarbeiterEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.ArrayList;
import java.util.List;

public class ProjekteDao {
    // Geben Sie alle Mitarbeiter aus
    public static List<MitarbeiterEntity> findAllMitarbeiter(){
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        return em.createQuery("Select e from MitarbeiterEntity e").getResultList();
    }

    // Wo wohnt Mitarbeiterin X > soll als Übergabeparameter der Methode übergeben werden?
     public static List<String> findAddressByName(String name) {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        TypedQuery<MitarbeiterEntity> query = em.createQuery("select e from MitarbeiterEntity e where e.nachname = ?1 ", MitarbeiterEntity.class);
        List<MitarbeiterEntity> mlist = query.setParameter(1, name).getResultList();

        List<String> alist = new ArrayList<>();
        for (MitarbeiterEntity x : mlist) {
            alist.add(x.getOrt());
        }
        return alist;
    }

   // Welche Vornamen kommen bei den Mitarbeitern öfter als einmal vor?
    public static List<String> findDuplicateFirstNames() {
    EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
    return em.createQuery("SELECT e.vorname FROM MitarbeiterEntity e GROUP BY e.vorname HAVING COUNT(e.vorname) > 1").getResultList();
}


}
