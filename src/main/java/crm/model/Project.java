package crm.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "companies")
public class Project implements Serializable {

    private static final long serialVersionUID = 23764276131283820L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private java.sql.Timestamp createTime;
    private java.sql.Timestamp endTime;
    private String phone;
    private float budget;
    private float revenue;
    private boolean status;

    @ManyToOne
    @JoinColumn(name = "lead_id")
    private Lead lead;

    @ManyToMany(cascade = {CascadeType.PERSIST})
    private List<SubScore> projectSubScoreList = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company project_company;

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    private List<Category> categoryList = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Lead getLead() {
        return lead;
    }

    public void setLead(Lead lead) {
        this.lead = lead;
    }

    public List<SubScore> getProjectSubScoreList() {
        return projectSubScoreList;
    }

    public void setProjectSubScoreList(List<SubScore> projectSubScoreList) {
        this.projectSubScoreList = projectSubScoreList;
    }

    public Company getProject_company() {
        return project_company;
    }

    public void setProject_company(Company project_company) {
        this.project_company = project_company;
    }

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }
}
