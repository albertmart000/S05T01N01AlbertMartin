package cat.itacademy.barcelonactiva.S05T01N01AlbertMartin.model.services;

import cat.itacademy.barcelonactiva.S05T01N01AlbertMartin.model.domain.BranchOffice;
import cat.itacademy.barcelonactiva.S05T01N01AlbertMartin.model.dto.BranchOfficeDTO;
import cat.itacademy.barcelonactiva.S05T01N01AlbertMartin.model.repository.IBranchOfficeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BranchOfficeServiceImpl implements IBranchOfficeService {

    @Autowired
    private IBranchOfficeRepository branchOfficeRepository;

    @Override
    public Long addBranchOffice(BranchOfficeDTO branchOfficeDTO) {
        BranchOffice branchOffice = this.mapDTOToEntity(branchOfficeDTO);
        branchOffice = branchOfficeRepository.save(branchOffice);
        return branchOfficeDTO.getBranchOfficeId();
    }

    @Override
    public Boolean deleteBranchOffice(Long id) {
        branchOfficeRepository.deleteById(id);
        return true;
    }

    @Override
    public BranchOfficeDTO getBranchOffice(Long id) {
        BranchOfficeDTO currentBranchOffice = new BranchOfficeDTO();
        Optional<BranchOffice> optional = branchOfficeRepository.findById(id);
        if (optional.isPresent()) {
            currentBranchOffice = this.mapEntityToDTO(optional.get());
        }
        return currentBranchOffice;
    }

    @Override
    public List<BranchOfficeDTO> getAllBranchOffices() {
        List<BranchOfficeDTO> branchOfficeDTOList = new ArrayList<>();
        List<BranchOffice> branchOfficeList = branchOfficeRepository.findAll();
        if (branchOfficeList.size() > 0) {
            for (BranchOffice branchOffice : branchOfficeList) {
                branchOfficeDTOList.add(this.mapEntityToDTO(branchOffice));
            }
        }
        return branchOfficeDTOList;
    }

    private BranchOfficeDTO mapEntityToDTO(BranchOffice branchOffice) {
        BranchOfficeDTO currentBranchOfficeDTO = null;
        if (branchOffice != null) {
            currentBranchOfficeDTO = new BranchOfficeDTO();
            currentBranchOfficeDTO.setBranchOfficeId(branchOffice.getBranchOfficeId());
            currentBranchOfficeDTO.setName(branchOffice.getName());
            currentBranchOfficeDTO.setCountry(branchOffice.getCountry());
        }
        return currentBranchOfficeDTO;
    }

    private BranchOffice mapDTOToEntity(BranchOfficeDTO branchOfficeDTO) {
        BranchOffice currentBranchOffice = null;
        if (branchOfficeDTO != null) {
            currentBranchOffice = new BranchOffice();
            currentBranchOffice.setBranchOfficeId(branchOfficeDTO.getBranchOfficeId());
            currentBranchOffice.setName(branchOfficeDTO.getName());
            currentBranchOffice.setCountry(branchOfficeDTO.getCountry());

        }
        return currentBranchOffice;
    }

}
