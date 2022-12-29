package cat.itacademy.barcelonactiva.S05T01N01AlbertMartin.model.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "branch_Office")
public class BranchOffice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="pk_BranchOfficeId")
    private Long branchOfficeId;

    @Column(name = "name", length = 100, unique = true, nullable = false)
    private String name;

    @Column(name = "country", length = 100)
    private String country;

    public BranchOffice() {
    }

    public Long getBranchOfficeId() {
        return branchOfficeId;
    }

    public void setBranchOfficeId(Long branchOfficeId) {
        this.branchOfficeId = branchOfficeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
