package crm.dao;

import crm.model.Project;

import java.util.List;

public interface ProjectDao {
    void addProject(Project project);
    Project getProject(int projectId);
    List<Project> getProjectList();
    void removeProject(int projectId);
    void updatePorject(int projectId);
}
