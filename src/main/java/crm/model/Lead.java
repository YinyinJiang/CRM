package crm.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "Lead")
public class Lead implements Serializable {

    private static final long serialVersionUID = 8436097833452420298L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int leadId;
    private String email;
    private String name;

    @Column(name = "phone", unique = true)
    private String phone;

    @OneToMany(mappedBy = "projectLead", cascade = CascadeType.ALL)
    private List<Project> leadProjectList = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "companyId")
    private Company leadCompany;

    public int getLeadId() {
        return leadId;
    }

    public void setLeadId(int leadId) {
        this.leadId = leadId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Project> getLeadProjectList() {
        return leadProjectList;
    }

    public void setLeadProjectList(List<Project> leadProjectList) {
        this.leadProjectList = leadProjectList;
    }

    public Company getLeadCompany() {
        return leadCompany;
    }

    public void setLeadCompany(Company leadCompany) {
        this.leadCompany = leadCompany;
    }
}
