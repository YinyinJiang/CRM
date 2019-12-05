package crm.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "Project")
public class Project implements Serializable {

    private static final long serialVersionUID = 23764276131283820L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int projectId;
    private String name;
    private java.sql.Timestamp createTime;
    private java.sql.Timestamp endTime;
    private String phone;
    private float budget;
    private float revenue;
    private boolean status;

    @ManyToOne
    @JoinColumn(name = "leadId")
    private Lead projectLead;

    @ManyToMany(cascade = {CascadeType.PERSIST})
    private List<SubScore> projectSubScoreList = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "companyId")
    private Company projectCompany;

    @OneToMany(mappedBy = "categoryProject", cascade = CascadeType.ALL)
    private List<Category> projectCategoryList = new ArrayList<>();

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public float getBudget() {
        return budget;
    }

    public void setBudget(float budget) {
        this.budget = budget;
    }

    public float getRevenue() {
        return revenue;
    }

    public void setRevenue(float revenue) {
        this.revenue = revenue;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Lead getProjectLead() {
        return projectLead;
    }

    public void setProjectLead(Lead projectLead) {
        this.projectLead = projectLead;
    }

    public Company getProjectCompany() {
        return projectCompany;
    }

    public void setProjectCompany(Company projectCompany) {
        this.projectCompany = projectCompany;
    }

    public List<Category> getProjectCategoryList() {
        return projectCategoryList;
    }

    public void setProjectCategoryList(List<Category> projectCategoryList) {
        this.projectCategoryList = projectCategoryList;
    }

    public List<SubScore> getProjectSubScoreList() {
        return projectSubScoreList;
    }

    public void setProjectSubScoreList(List<SubScore> projectSubScoreList) {
        this.projectSubScoreList = projectSubScoreList;
    }
}
