package cat.itacademy.barcelonactiva.S05T01N01AlbertMartin.model.services;

import cat.itacademy.barcelonactiva.S05T01N01AlbertMartin.model.dto.BranchOfficeDTO;
import java.util.List;

public interface IBranchOfficeService {

    Long addBranchOffice(BranchOfficeDTO branchOfficeDTO);

    Boolean deleteBranchOffice(Long id);

    BranchOfficeDTO getBranchOffice(Long id);

    List<BranchOfficeDTO> getAllBranchOffices();

}
