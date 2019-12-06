package crm.dao;

import crm.model.SubScore;
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
public class SubScoreDaoImpl implements SubScoreDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addSubScore(SubScore subScore) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(subScore);
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
    public SubScore getSubScoreBySubScoreId(int subScoreId) {
        SubScore subScore = null;
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            subScore = (SubScore) session.get(SubScore.class, subScoreId);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return subScore;
    }

    @Override
    public List<SubScore> getSubScoreList() {
        List<SubScore> subScoreList = new ArrayList<>();
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<SubScore> criteriaQuery = criteriaBuilder.createQuery(SubScore.class);
            Root<SubScore> root = criteriaQuery.from(SubScore.class);
            criteriaQuery.select(root);
            subScoreList = session.createQuery(criteriaQuery).getResultList();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return subScoreList;
    }
}
