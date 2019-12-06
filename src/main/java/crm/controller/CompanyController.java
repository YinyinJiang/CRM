package crm.controller;

import crm.model.Company;
import crm.model.Project;
import crm.model.SubScore;
import crm.service.CompanyService;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @RequestMapping(value = "/company/getCompany/{companyId}", method = RequestMethod.GET)
    public ModelAndView getCompany(@PathVariable(value = "companyId") int companyId) {
        Company company = companyService.getCompanyByCompanyId(companyId);
        return new ModelAndView("companyPage", "company", company);
    }

    @RequestMapping(value = "/company/addCompany", method = RequestMethod.POST)
    public String addCompany(@Valid @ModelAttribute(value = "companyForm") Company company, BindingResult result) {
        if (result.hasErrors()) {
            return "addCompany";
        }
        companyService.addCompany(company);
        return "redirect:/getAllCompanies";
    }

    @RequestMapping("/company/getCompanyList")
    public @ResponseBody
    List<Company> getCompanyListJson() {
        return companyService.getCompanyList();
    }

    @RequestMapping(value = "/company/getCompanyProjectList/{companyId}", method = RequestMethod.GET)
    public ModelAndView getCompanyProjectList(@PathVariable(value = "companyId") int companyId) {
        List<Project> companyProjectList = companyService.getCompanyProjectList(companyId);
        return new ModelAndView("companyProject", "companyProjectList", companyProjectList);
    }

    @RequestMapping(value = "/company/getCompanySubScoreList/{companyId}", method = RequestMethod.GET)
    public @ResponseBody Map<String, Float> getCompanySubScoreList(@PathVariable(value = "companyId") int companyId) {
        List<SubScore> companySubScoreList = companyService.getCompanySubScoreList(companyId);
        Map<String, Float> map = new HashMap<>();
        for (SubScore subScore : companySubScoreList) {
            map.put(subScore.getType(), subScore.getScore());
        }
        return map;
    }


}
