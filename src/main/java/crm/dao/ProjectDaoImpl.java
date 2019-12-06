package crm.dao;

import crm.model.Project;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProjectDaoImpl implements ProjectDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addProject(Project project) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(project);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            assert session != null;
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public Project getProject(int projectId) {
        Project project = null;
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            project = (Project) session.get(Project.class, projectId);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return project;
    }

    @Override
    public List<Project> getProjectList() {
        List<Project> projectList = new ArrayList<Project>();
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Project> criteriaQuery = criteriaBuilder.createQuery(Project.class);
            Root<Project> root = criteriaQuery.from(Project.class);
            criteriaQuery.select(root);
            projectList = session.createQuery(criteriaQuery).getResultList();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
