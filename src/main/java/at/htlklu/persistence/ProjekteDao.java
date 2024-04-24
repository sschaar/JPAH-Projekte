package at.htlklu.persistence;

import at.htlklu.entities.ArbeitspaketeEntity;
import at.htlklu.entities.MaApZuordEntity;
import at.htlklu.entities.MitarbeiterEntity;
import at.htlklu.entities.ProjekteEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.time.LocalDate;
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


    public static List<ProjekteEntity> getProjekt(int id) {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        TypedQuery<ProjekteEntity> query = em.createQuery("Select e from ProjekteEntity e where e.id = ?1", ProjekteEntity.class);
        List<ProjekteEntity> pNew = query.setParameter(1, id).getResultList();
        return pNew;
    }

    public static void updateProjekte(ArbeitspaketeEntity aNew, int pToUpdate) {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction et = em.getTransaction();
        ProjekteEntity pByIdInContext;
        try {
            et.begin();
            pByIdInContext = em.find(ProjekteEntity.class, pToUpdate);
            pByIdInContext.addArbeitspaket(aNew);
            em.persist(aNew);
            em.flush();
            et.commit();
        } finally {
            if (et.isActive()) {
                et.rollback();
            }
            em.close();
            JPAUtil.shutdown();
        }
    }

    public static void insertProjekt(ProjekteEntity pNew){
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            em.persist(pNew);
            em.flush();
            et.commit();
        } finally {
            if(et.isActive()) et.rollback();
        }
        em.close();
        JPAUtil.shutdown();
    }

    public static void insertArbeitspaket(ArbeitspaketeEntity aNew){
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction et = em.getTransaction();
        ProjekteEntity pTemp;
        try {
            et.begin();
            pTemp = em.find(ProjekteEntity.class, 7);
            pTemp.addArbeitspaket(aNew);
            em.persist(aNew);
            em.flush();
            et.commit();
        } finally {
            if(et.isActive()) et.rollback();
        }
        em.close();
        JPAUtil.shutdown();
    }

    /*
    public static void insertMitarbeiterToArbeitspaket(MitarbeiterEntity mNew, int aToUpdate){
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction et = em.getTransaction();
        ArbeitspaketeEntity aByIdInContext;
        MaApZuordEntity mazo = new MaApZuordEntity();
        try{
            et.begin();
            em.persist(mNew);
            mNew.addMaApZo(mazo);
            aByIdInContext = em.find(ArbeitspaketeEntity.class, aToUpdate);
            aByIdInContext.addMaApZo(mazo);
            em.flush();
            et.commit();
        } finally {
            if(et.isActive()) et.rollback();
        }
        em.close();
        JPAUtil.shutdown();
    }

     */

    public static void insertMitarbeiter(MitarbeiterEntity mNew){
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            em.persist(mNew);
            em.flush();
            et.commit();
        } finally {
            if(et.isActive()) et.rollback();
        }
        em.close();
        JPAUtil.shutdown();
    }

    public static void updateArbeitspaketeByMitarbeiter(MitarbeiterEntity mNew, int aToUpdate, Double std, LocalDate date, String anmerkung) {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction et = em.getTransaction();
        ArbeitspaketeEntity aTransient;
        MaApZuordEntity mazoTemp = new MaApZuordEntity();
        try {
            et.begin();
            aTransient = em.find(ArbeitspaketeEntity.class, aToUpdate);
            aTransient.addMaApZo(mazoTemp);
            mNew.addMaApZo(mazoTemp);
            mazoTemp.setStd(std);
            mazoTemp.setDatum(date);
            mazoTemp.setAnmerkung(anmerkung);
            em.persist(mNew);
            em.persist(mazoTemp);
            em.flush();
            et.commit();
        } finally {
            if (et.isActive()) {
                et.rollback();
            }
            em.close();
            JPAUtil.shutdown();
        }
    }
}
