package crm.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

public class SubScore {

    private static final long serialVersionUID = 37453723943454989L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String type;
    private float score;

    @ManyToMany(mappedBy = "projectSubScoreList")
    private List<Project> subScoreProjectList = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @ManyToMany(mappedBy = "companySubScoreList")
    private List<Company> subScoreCompanyList = new ArrayList<>();
}
