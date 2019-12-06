package crm.dao;

import crm.model.Company;
import crm.model.Project;
import crm.model.SubScore;
import crm.service.CompanyService;
import org.hibernate.Hibernate;
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
public class CompanyDaoImpl implements CompanyDao {
    @Autowired
    private SessionFactory sessionFactory;

    public void addCompany(Company company) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(company);
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
    public Company getCompanyByCompanyId(int companyId) {
        Company company = null;
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            company = (Company) session.get(Company.class, companyId);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return company;
    }

    @Override
    public List<Company> getCompanyList() {
        List<Company> companyList = new ArrayList<Company>();
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Company> criteriaQuery = criteriaBuilder.createQuery(Company.class);
            Root<Company> root = criteriaQuery.from(Company.class);
            criteriaQuery.select(root);
            companyList = session.createQuery(criteriaQuery).getResultList();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return companyList;
    }

    @Override
    public List<Project> getCompanyProjectList(int companyId) {
        List<Project> companyProjectList = null;
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Company company = (Company) session.get(Company.class, companyId);
            if (!Hibernate.isInitialized(company.getCompanyProjectList()))
                Hibernate.initialize(company.getCompanyProjectList());
            companyProjectList = company.getCompanyProjectList();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return companyProjectList;
    }

    @Override
    public List<SubScore> getCompanySubScoreList(int companyId) {
        List<SubScore> companySubScoreList = null;
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Company company = (Company) session.get(Company.class, companyId);
            if (!Hibernate.isInitialized(company.getCompanySubScoreList())) {
                Hibernate.initialize(company.getCompanySubScoreList());
            }
            companySubScoreList = company.getCompanySubScoreList();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return companySubScoreList;

    }


}
