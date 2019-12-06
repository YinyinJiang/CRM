package crm.dao;

import crm.model.SubScore;

import java.util.List;

public interface SubScoreDao {
    void addSubScore(SubScore subScore);
    SubScore getSubScoreBySubScoreId(int subScoreId);
    List<SubScore> getSubScoreList();
}
