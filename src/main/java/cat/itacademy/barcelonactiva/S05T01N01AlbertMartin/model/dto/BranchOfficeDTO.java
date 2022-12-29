package cat.itacademy.barcelonactiva.S05T01N01AlbertMartin.model.dto;

import java.util.Arrays;
import java.util.List;

public class BranchOfficeDTO {

    private Long branchOfficeId;
    private String name;
    private String country;
    private String type;
    List<String> EUCountriesList = Arrays.asList("Austria", "Belgium", "Croatia", "Cyprus", "Czechia",
            "Denmark", "Estonia", "Finland", "France", "Germany", "Greece", "Hungary",
            "Ireland", "Italy", "Latvia", "Lithuania", "Luxembourg", "Malta", "Netherlands",
            "Poland", "Portugal", "Romania", "Slovakia", "Slovenia", "Spain", "Sweden");

    public BranchOfficeDTO() {
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

    public String getType() {
        if (EUCountriesList.contains(country)) {
            this.type = "EU";
        } else {
            this.type = "Not EU";
        }
        return this.type;
    }

}
