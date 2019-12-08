package crm.service;

import crm.dao.SubScoreDao;
import crm.model.SubScore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubScoreServiceImpl implements SubScoreService {
    @Autowired
    SubScoreDao subScoreDao;

    @Override
    public void addSubScore(SubScore subScore) {
        subScoreDao.addSubScore(subScore);
    }

    @Override
    public SubScore getSubScoreBySubScoreId(int subScoreId) {
        return subScoreDao.getSubScoreBySubScoreId(subScoreId);
    }

    @Override
    public List<SubScore> getSubScoreList() {
        return null;
    }
}
