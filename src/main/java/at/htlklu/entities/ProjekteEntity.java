package at.htlklu.entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "projekte", schema = "projekte")
public class ProjekteEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "nr", nullable = false)
    private Integer nr;
    @Basic
    @Column(name = "titel", nullable = false, length = 200)
    private String titel;
    @Basic
    @Column(name = "code", nullable = false, length = 10)
    private String code;
    @OneToMany(mappedBy = "projekteByPrNr",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY)
    private Set<ArbeitspaketeEntity> arbeitspaketesByNr;

    public ProjekteEntity(){}
    public ProjekteEntity(String titel, String code, Set<ArbeitspaketeEntity> arbeitspaketesByNr) {
        this.titel = titel;
        this.code = code;
        this.arbeitspaketesByNr = arbeitspaketesByNr;
    }

    @Override
    public String toString() {
        return "ProjekteEntity{" +
                "nr=" + nr +
                ", titel='" + titel + '\'' +
                ", code='" + code + '\'' +
          //      ", arbeitspaketesByNr=" + arbeitspaketesByNr +
                '}';
    }

    public Integer getNr() {
        return nr;
    }

    public void setNr(Integer nr) {
        this.nr = nr;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProjekteEntity that = (ProjekteEntity) o;

        if (nr != null ? !nr.equals(that.nr) : that.nr != null) return false;
        if (titel != null ? !titel.equals(that.titel) : that.titel != null) return false;
        if (code != null ? !code.equals(that.code) : that.code != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = nr != null ? nr.hashCode() : 0;
        result = 31 * result + (titel != null ? titel.hashCode() : 0);
        result = 31 * result + (code != null ? code.hashCode() : 0);
        return result;
    }

    public Set<ArbeitspaketeEntity> getArbeitspaketesByNr() {
        return arbeitspaketesByNr;
    }

    public void setArbeitspaketesByNr(Set<ArbeitspaketeEntity> arbeitspaketesByNr) {
        this.arbeitspaketesByNr = arbeitspaketesByNr;
    }

    public void addArbeitspaket(ArbeitspaketeEntity ap){
        this.arbeitspaketesByNr.add(ap);
        ap.setProjekteByPrNr(this);
    }
}
