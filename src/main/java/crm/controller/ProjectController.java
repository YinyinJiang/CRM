package crm.controller;

import crm.model.Project;
import crm.model.SubScore;
import crm.service.ProjectService;
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
public class ProjectController {
    @Autowired
    ProjectService projectService;

    @RequestMapping(value = "/project/getProject/{projectId}", method = RequestMethod.GET)
    public ModelAndView getCompany(@PathVariable(value = "projectId") int projectId) {
        Project project = projectService.getProjectByProjectId(projectId);
        return new ModelAndView("projectPage", "project", project);
    }

    @RequestMapping(value = "/project/addProject", method = RequestMethod.POST)
    public String addCompany(@Valid @ModelAttribute(value = "projectForm") Project project, BindingResult result) {
        if (result.hasErrors()) {
            return "addProject";
        }
        projectService.addProject(project);
        return "redirect:/project";
    }

    @RequestMapping(value = "/project/getProjectList", method = RequestMethod.GET)
    public @ResponseBody
    Map<String, List<String>> getProjectListJson() {
        Map<String, List<String>> res = new HashMap<>();
        res.put("project_name", new ArrayList<String>());
        res.put("start_time", new ArrayList<String>());
        res.put("end_time", new ArrayList<String>());
        res.put("lead_name", new ArrayList<String>());
        res.put("lead_phone", new ArrayList<String>());
        res.put("budget", new ArrayList<String>());
        res.put("revenue", new ArrayList<String>());
        res.put("totalScore", new ArrayList<String>());
        SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for (Project project: projectService.getProjectList()) {
            res.get("project_name").add(project.getName());
            res.get("start_time").add(format.format(project.getCreateTime()));
            res.get("end_time").add(format.format(project.getEndTime()));
            res.get("lead_name").add(project.getProjectLead().getName());
            res.get("lead_phone").add(project.getProjectLead().getPhone());
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

}
