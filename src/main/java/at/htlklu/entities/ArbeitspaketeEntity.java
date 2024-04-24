package at.htlklu.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "arbeitspakete", schema = "projekte")
public class ArbeitspaketeEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic
    @Column(name = "code", nullable = false, length = 5)
    private String code;
    @Basic
    @Column(name = "Bezeichnung", nullable = false, length = 50)
    private String bezeichnung;
    @ManyToOne
    @JoinColumn(name = "pr_nr", referencedColumnName = "nr", nullable = false)
    private ProjekteEntity projekteByPrNr;
    @OneToMany(mappedBy = "arbeitspaketeByApId",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY)
    private Set<MaApZuordEntity> maApZuordsById;

    public ArbeitspaketeEntity(String code, String bezeichnung){
        this.code = code;
        this.bezeichnung = bezeichnung;
    }
    public ArbeitspaketeEntity(){maApZuordsById = new HashSet<>();}
    public ArbeitspaketeEntity(String code, String bezeichnung, ProjekteEntity projekteByPrNr) {
        this.code = code;
        this.bezeichnung = bezeichnung;
        this.projekteByPrNr = projekteByPrNr;
        maApZuordsById = new HashSet<>();

        //add this to its master(s)
        projekteByPrNr.addArbeitspaket(this);
    }

    @Override
    public String toString() {
        return "ArbeitspaketeEntity{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", bezeichnung='" + bezeichnung + '\'' +
                ", projekteByPrNr=" + projekteByPrNr +
       //         ", maApZuordsById=" + maApZuordsById +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getBezeichnung() {
        return bezeichnung;
    }

    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ArbeitspaketeEntity that = (ArbeitspaketeEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (code != null ? !code.equals(that.code) : that.code != null) return false;
        if (bezeichnung != null ? !bezeichnung.equals(that.bezeichnung) : that.bezeichnung != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (code != null ? code.hashCode() : 0);
        result = 31 * result + (bezeichnung != null ? bezeichnung.hashCode() : 0);
        return result;
    }

    public ProjekteEntity getProjekteByPrNr() {
        return projekteByPrNr;
    }

    public void setProjekteByPrNr(ProjekteEntity projekteByPrNr) {
        this.projekteByPrNr = projekteByPrNr;
    }

    public Set<MaApZuordEntity> getMaApZuordsById() {
        return maApZuordsById;
    }

    public void setMaApZuordsById(Set<MaApZuordEntity> maApZuordsById) {
        this.maApZuordsById = maApZuordsById;
    }
}
