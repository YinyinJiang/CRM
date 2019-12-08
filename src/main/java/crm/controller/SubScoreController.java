package crm.controller;

import crm.model.Project;
import crm.model.SubScore;
import crm.service.ProjectService;
import crm.service.SubScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class SubScoreController {
    @Autowired
    SubScoreService subScoreService;
    private ProjectService projectService;

    @RequestMapping(value = "/subScore/getsubScore/{subScoreId}", method = RequestMethod.GET)
    public ModelAndView getSubScore(@PathVariable(value = "subScoreId") int subScoreId) {
        SubScore subScore = subScoreService.getSubScoreBySubScoreId(subScoreId);
        return new ModelAndView("subScore page", "SubScore", subScore);
    }

    @RequestMapping(value = "/subScore/addSubScore/{project_id}/{sub_score}", method = RequestMethod.POST)
    public ModelAndView addSubScore(@PathVariable int project_id, @PathVariable float sub_score) {
        Project project = projectService.getProjectByProjectId(project_id);
        SubScore subScore = new SubScore(sub_score);
        List<SubScore> tmpProjectSubScoreList = project.getProjectSubScoreList();
        tmpProjectSubScoreList.add(subScore);
        project.setProjectSubScoreList(tmpProjectSubScoreList);
        return new ModelAndView("projectSubscorePage", "project_addSubScore", subScore);
    }
}
