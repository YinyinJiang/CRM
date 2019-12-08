package crm.service;

import crm.model.SubScore;

import java.util.List;

public interface SubScoreService {
    void addSubScore(SubScore subScore);
    SubScore getSubScoreBySubScoreId(int subScoreId);
    List<SubScore> getSubScoreList();
}
