package crm.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Subscore")
public class SubScore {

    private static final long serialVersionUID = 37453723943454989L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int subScoreId;
    private String type;
    private float score;

    @ManyToMany(mappedBy = "projectSubScoreList")
    private List<Project> subScoreProjectList = new ArrayList<>();

    @ManyToMany(mappedBy = "companySubScoreList")
    private List<Company> subScoreCompanyList = new ArrayList<>();

    public SubScore(float score) {
        this.score = score;
    }

    public int getSubScoreId() {
        return subScoreId;
    }

    public void setSubScoreId(int subScoreId) {
        this.subScoreId = subScoreId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public List<Project> getSubScoreProjectList() {
        return subScoreProjectList;
    }

    public void setSubScoreProjectList(List<Project> subScoreProjectList) {
        this.subScoreProjectList = subScoreProjectList;
    }

    public List<Company> getSubScoreCompanyList() {
        return subScoreCompanyList;
    }

    public void setSubScoreCompanyList(List<Company> subScoreCompanyList) {
        this.subScoreCompanyList = subScoreCompanyList;
    }
}
