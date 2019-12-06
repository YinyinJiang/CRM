package crm.service;

import crm.model.Project;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {
    @Override
    public void addProject(Project project) {

    }

    @Override
    public Project getProjectByProjectId(int projectId) {
        return null;
    }

    @Override
    public List<Project> getProjectList() {
        return null;
    }
}
