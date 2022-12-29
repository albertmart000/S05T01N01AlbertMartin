package cat.itacademy.barcelonactiva.S05T01N01AlbertMartin.controllers;

import cat.itacademy.barcelonactiva.S05T01N01AlbertMartin.model.dto.BranchOfficeDTO;
import cat.itacademy.barcelonactiva.S05T01N01AlbertMartin.model.services.IBranchOfficeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BranchOfficeController {

    @Autowired
    private IBranchOfficeService branchOfficeService;

    private final String DATA_BRANCHOFFICEDTO_LIST = "DATA_BranchOfficeDtoList";
    private final String DATA_BRANCHOFFICEDTO_FORM = "DATA_BranchOfficeDtoForm";
    private final String VIEW_BRANCHOFFICE_LIST = "BranchOfficeList";
    private final String VIEW_SHOW_BRANCHOFFICE = "ShowBranchOffice";
    private final String VIEW_EDIT_BRANCHOFFICE = "EditBranchOffice";

    @GetMapping("/GetAllBranchOffice")
    public ModelAndView getAllBranchOffices() {
        ModelAndView modelAndView = new ModelAndView();
        List<BranchOfficeDTO> branchOfficeDTOList = branchOfficeService.getAllBranchOffices();
        modelAndView.addObject(DATA_BRANCHOFFICEDTO_LIST, branchOfficeDTOList);
        modelAndView.setViewName(VIEW_BRANCHOFFICE_LIST);
        return modelAndView;
    }

    @GetMapping("/NewBranchOffice")
    public ModelAndView newBranchOfficeForm() {
        BranchOfficeDTO branchOfficeDTO = new BranchOfficeDTO();
        return branchOfficeDTOForm(branchOfficeDTO, VIEW_EDIT_BRANCHOFFICE);
    }

    @GetMapping("/UpdateBranchOffice/{id}")
    public ModelAndView updateBranchOfficeForm(@PathVariable("id") Long id) {
        BranchOfficeDTO branchOfficeDTO = branchOfficeService.getBranchOffice(id);
        return branchOfficeDTOForm(branchOfficeDTO, VIEW_EDIT_BRANCHOFFICE);
    }

    @GetMapping("/GetBranchOffice/{id}")
    public ModelAndView getBranchOfficeForm(@PathVariable("id") Long id) {
        BranchOfficeDTO branchOfficeDTO = branchOfficeService.getBranchOffice(id);
        return branchOfficeDTOForm(branchOfficeDTO, VIEW_SHOW_BRANCHOFFICE);
    }

    @GetMapping("DeleteBranchOffice/{id}")
    public ModelAndView deleteBranchOffice (@PathVariable("id") Long id) {
        branchOfficeService.deleteBranchOffice(id);
        return new ModelAndView("redirect:/GetAllBranchOffice");
    }

    @PostMapping("/AddBranchOffice")
    public ModelAndView addBranchOffice(@ModelAttribute(DATA_BRANCHOFFICEDTO_FORM) BranchOfficeDTO branchOfficeDTO) {
        branchOfficeService.addBranchOffice(branchOfficeDTO);
        return new ModelAndView("redirect:/GetAllBranchOffice");
    }

    private ModelAndView branchOfficeDTOForm(BranchOfficeDTO branchOfficeDTO, String nameView) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject(DATA_BRANCHOFFICEDTO_FORM, branchOfficeDTO);
        modelAndView.setViewName(nameView);
        return modelAndView;
    }
}
