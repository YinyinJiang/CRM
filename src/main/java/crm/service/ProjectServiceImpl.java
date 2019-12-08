package crm.service;

import crm.dao.ProjectDao;
import crm.model.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    private ProjectDao projectDao;

    @Override
    public void addProject(Project project) {
        projectDao.addProject(project);
    }

    @Override
    public Project getProjectByProjectId(int projectId) {
        return projectDao.getProject(projectId);
    }

    @Override
    public List<Project> getProjectList() {
        return projectDao.getProjectList();
    }

    @Override
    public void removeProject(int projectId) {
        projectDao.removeProject(projectId);
    }

    @Override
    public void updatePorject(int projectId) {
        projectDao.updatePorject(projectId);
    }
}
