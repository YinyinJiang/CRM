package crm.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "companies")
public class Company implements Serializable {

    private static final long serialVersionUID = 137283246732432L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String contact;
    private String phone;

    @ManyToMany(mappedBy = "companyList")
    private List<User> chargers = new ArrayList<>();

    @ManyToMany(cascade = {CascadeType.PERSIST})
    private List<SubScore> companySubScoreList = new ArrayList<>();

    @OneToMany(mappedBy = "lead_company", cascade = CascadeType.ALL)
    private List<Lead> leadList = new ArrayList<>();

    @OneToMany(mappedBy = "project_company", cascade = CascadeType.ALL)
    private List<Lead> projectList = new ArrayList<>();

    public List<User> getChargers() {
        return chargers;
    }

    public void setChargers(List<User> chargers) {
        this.chargers = chargers;
    }

    public List<SubScore> getCompanySubScoreList() {
        return companySubScoreList;
    }

    public void setCompanySubScoreList(List<SubScore> companySubScoreList) {
        this.companySubScoreList = companySubScoreList;
    }

    public List<Lead> getLeadList() {
        return leadList;
    }

    public void setLeadList(List<Lead> leadList) {
        this.leadList = leadList;
    }

    public List<Lead> getProjectList() {
        return projectList;
    }

    public void setProjectList(List<Lead> projectList) {
        this.projectList = projectList;
    }

    public List<SubScore> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<SubScore> categoryList) {
        this.categoryList = categoryList;
    }

    @ManyToMany(cascade = {CascadeType.PERSIST})
    private List<SubScore> categoryList = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
