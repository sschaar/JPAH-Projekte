package at.htlklu.entities;

import jakarta.persistence.*;

import java.sql.Date;
import java.time.LocalDate;

@Entity
@Table(name = "ma_ap_zuord", schema = "projekte")
public class MaApZuordEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic
    @Column(name = "std", nullable = false)
    private Double std;
    @Basic
    @Column(name = "datum", nullable = false)
    private Date datum;
    @Basic
    @Column(name = "anmerkung", nullable = false, length = 200)
    private String anmerkung;
    @ManyToOne
    @JoinColumn(name = "ma_id", referencedColumnName = "id", nullable = false)
    private MitarbeiterEntity mitarbeiterByMaId;
    @ManyToOne
    @JoinColumn(name = "ap_id", referencedColumnName = "id", nullable = false)
    private ArbeitspaketeEntity arbeitspaketeByApId;


     public MaApZuordEntity(){}

    public MaApZuordEntity(Double std, LocalDate datum, String anmerkung, MitarbeiterEntity mitarbeiterByMaId, ArbeitspaketeEntity arbeitspaketeByApId) {
        this.std = std;
        this.datum = Date.valueOf(datum);
        this.anmerkung = anmerkung;
        this.mitarbeiterByMaId = mitarbeiterByMaId;
        this.arbeitspaketeByApId = arbeitspaketeByApId;
    }

    @Override
    public String toString() {
        return "MaApZuordEntity{" +
                "id=" + id +
                ", std=" + std +
                ", datum=" + datum +
                ", anmerkung='" + anmerkung + '\'' +
                ", mitarbeiterByMaId=" + mitarbeiterByMaId +
                ", arbeitspaketeByApId=" + arbeitspaketeByApId +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getStd() {
        return std;
    }

    public void setStd(Double std) {
        this.std = std;
    }

    public LocalDate getDatum() {
        return datum.toLocalDate();
    }

    public void setDatum(LocalDate datum) {
        this.datum = Date.valueOf(datum);
    }

    public String getAnmerkung() {
        return anmerkung;
    }

    public void setAnmerkung(String anmerkung) {
        this.anmerkung = anmerkung;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MaApZuordEntity that = (MaApZuordEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (std != null ? !std.equals(that.std) : that.std != null) return false;
        if (datum != null ? !datum.equals(that.datum) : that.datum != null) return false;
        if (anmerkung != null ? !anmerkung.equals(that.anmerkung) : that.anmerkung != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (std != null ? std.hashCode() : 0);
        result = 31 * result + (datum != null ? datum.hashCode() : 0);
        result = 31 * result + (anmerkung != null ? anmerkung.hashCode() : 0);
        return result;
    }

    public MitarbeiterEntity getMitarbeiterByMaId() {
        return mitarbeiterByMaId;
    }

    public void setMitarbeiterByMaId(MitarbeiterEntity mitarbeiterByMaId) {
        this.mitarbeiterByMaId = mitarbeiterByMaId;
    }

    public ArbeitspaketeEntity getArbeitspaketeByApId() {
        return arbeitspaketeByApId;
    }

    public void setArbeitspaketeByApId(ArbeitspaketeEntity arbeitspaketeByApId) {
        this.arbeitspaketeByApId = arbeitspaketeByApId;
    }
}
