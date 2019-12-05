package crm.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "Company")
public class Company implements Serializable {

    private static final long serialVersionUID = 137283246732432L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int companyId;

    private String name;
    private String contact;
    private String phone;

    @ManyToMany(mappedBy = "userCompanyList")
    private List<User> companyUserList = new ArrayList<>();

    @ManyToMany(cascade = {CascadeType.PERSIST})
    private List<SubScore> companySubScoreList = new ArrayList<>();

    @OneToMany(mappedBy = "leadCompany", cascade = CascadeType.ALL)
    private List<Lead> companyLeadList = new ArrayList<>();

    @OneToMany(mappedBy = "projectCompany", cascade = CascadeType.ALL)
    private List<Project> companyProjectList = new ArrayList<>();

    @ManyToMany(cascade = {CascadeType.PERSIST})
    private List<Category> companyCategoryList = new ArrayList<>();

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

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

    public List<User> getCompanyUserList() {
        return companyUserList;
    }

    public void setCompanyUserList(List<User> companyUserList) {
        this.companyUserList = companyUserList;
    }

    public List<Lead> getCompanyLeadList() {
        return companyLeadList;
    }

    public void setCompanyLeadList(List<Lead> companyLeadList) {
        this.companyLeadList = companyLeadList;
    }

    public List<Project> getCompanyProjectList() {
        return companyProjectList;
    }

    public void setCompanyProjectList(List<Project> companyProjectList) {
        this.companyProjectList = companyProjectList;
    }

    public List<Category> getCompanyCategoryList() {
        return companyCategoryList;
    }

    public void setCompanyCategoryList(List<Category> companyCategoryList) {
        this.companyCategoryList = companyCategoryList;
    }

    public List<SubScore> getCompanySubScoreList() {
        return companySubScoreList;
    }

    public void setCompanySubScoreList(List<SubScore> companySubScoreList) {
        this.companySubScoreList = companySubScoreList;
    }
}