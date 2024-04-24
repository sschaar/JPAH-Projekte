package at.htlklu.persistence;

import at.htlklu.entities.ArbeitspaketeEntity;
import at.htlklu.entities.MaApZuordEntity;
import at.htlklu.entities.MitarbeiterEntity;
import at.htlklu.entities.ProjekteEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.ArrayList;
import java.util.List;

public class ProjekteDao {
    // Geben Sie alle Mitarbeiter aus
    public static List<MitarbeiterEntity> findAllMitarbeiter() {
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

    // Wer ist der jüngste Mitarbeiter, geben Sie dessen Daten aus?
    public static MitarbeiterEntity findYoungestMitarbeiter() {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        return (MitarbeiterEntity) em.createQuery("Select e from MitarbeiterEntity e order by e.gebdat desc").setMaxResults(1).getSingleResult();
    }

    public static List<ArbeitspaketeEntity> findAllArbeitspakete() {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        return em.createQuery("Select e from ArbeitspaketeEntity e").getResultList();
    }

    // Welche Bezeichnung haben die Arbeitspakete des Projekts mit dem Code X > X soll als Übergabeparameter der Methode übergeben werden?
    public static List<ProjekteEntity> findProjectsByCode(String code) {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        TypedQuery<ProjekteEntity> query = em.createQuery("select e from ProjekteEntity e where e.code = ?1 ", ProjekteEntity.class);
        List<ProjekteEntity> plist = query.setParameter(1, code).getResultList();
        return plist;
    }

    /*
    // Geben Sie zu allen Mitarbeitern deren Arbeitspaketen aus, an denen Sie beteilig sind.
    public static List<ArbeitspaketeEntity> findArbeitspaketeByMitarbeiter() {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        return em.createQuery(
                "Select a from ArbeitspaketeEntity a, MaApZuordEntity ma, MitarbeiterEntity m " +
                        "WHERE m.id = ma.mitarbeiterByMaId" +
                        "and a.id = ma.arbeitspaketeByApId"
        ).getResultList();
    }
     */
}
