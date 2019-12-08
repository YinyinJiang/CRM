package crm.controller;

import crm.model.Company;
import crm.model.Project;
import crm.model.SubScore;
import crm.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
        return "redirect:/company";
    }

    @RequestMapping(value = "/company/getCompanyList", method = RequestMethod.GET)
    public @ResponseBody
    Map<String, List<String>> getCompanyListJson() {
        Map<String, List<String>> res = new HashMap<>();
//        res.put("id", new ArrayList<String>());
        res.put("company name", new ArrayList<String>());
        res.put("contact", new ArrayList<String>());
        res.put("totalScore", new ArrayList<String>());
        for (Company company: companyService.getCompanyList()) {
//            res.get("id").add(String.valueOf(company.getCompanyId()));
            res.get("company name").add(company.getName());
            res.get("contact").add(company.getContact());
            int totalScore = 0;
            for (SubScore score : company.getCompanySubScoreList()) {
                totalScore += score.getScore();
            }
            res.get("totalScore").add(String.valueOf(totalScore));
        }
        return res;
    }

    @RequestMapping(value = "/company/getCompanyProjectList/{companyId}", method = RequestMethod.GET)
    public @ResponseBody
    Map<String, List<String>> getCompanyProjectListJson(@PathVariable(value = "companyId") int companyId) {
        Map<String, List<String>> res = new HashMap<>();
        res.put("project_name", new ArrayList<String>());
        res.put("start_time", new ArrayList<String>());
        res.put("end_time", new ArrayList<String>());
        res.put("budget", new ArrayList<String>());
        res.put("revenue", new ArrayList<String>());
        res.put("totalScore", new ArrayList<String>());
        SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for (Project project: companyService.getCompanyProjectList(companyId)) {
            res.get("project_name").add(project.getName());
            res.get("start_time").add(format.format(project.getCreateTime()));
            res.get("end_time").add(format.format(project.getEndTime()));
            res.get("budget").add(String.valueOf(project.getBudget()));
            res.get("revenue").add(String.valueOf(project.getRevenue()));
            int totalScore = 0;
            for (SubScore score : project.getProjectSubScoreList()) {
                totalScore += score.getScore();
            }
            res.get("totalScore").add(String.valueOf(totalScore));
        }
        return res;
    }

    @RequestMapping(value = "/company/getCompanyHistoryProjectList/{companyId}", method = RequestMethod.GET)
    public @ResponseBody
    Map<String, List<String>> getCompanyHistoryProjectList(@PathVariable(value = "companyId") int companyId) {
        Map<String, List<String>> res = new HashMap<>();
        res.put("project_name", new ArrayList<String>());
        res.put("start_time", new ArrayList<String>());
        res.put("end_time", new ArrayList<String>());
        res.put("budget", new ArrayList<String>());
        res.put("revenue", new ArrayList<String>());
        res.put("totalScore", new ArrayList<String>());
        SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for (Project project: companyService.getCompanyHistoryProjectList(companyId)) {
            res.get("project_name").add(project.getName());
            res.get("start_time").add(format.format(project.getCreateTime()));
            res.get("end_time").add(format.format(project.getEndTime()));
            res.get("budget").add(String.valueOf(project.getBudget()));
            res.get("revenue").add(String.valueOf(project.getRevenue()));
            int totalScore = 0;
            for (SubScore score : project.getProjectSubScoreList()) {
                totalScore += score.getScore();
            }
            res.get("totalScore").add(String.valueOf(totalScore));
        }
        return res;
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
