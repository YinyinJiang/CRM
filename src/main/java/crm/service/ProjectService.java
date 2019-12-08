package crm.service;

import crm.model.Project;

import java.util.List;

public interface ProjectService {
    void addProject(Project project);
    Project getProjectByProjectId(int projectId);
    List<Project> getProjectList();
    void removeProject(int projectId);
    void updatePorject(int projectId);
}
