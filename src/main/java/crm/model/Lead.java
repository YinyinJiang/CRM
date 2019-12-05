package crm.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "leaders")
public class Lead implements Serializable {

    private static final long serialVersionUID = 8436097833452420298L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String email;
    private String name;

    @Column(name = "phone", unique = true)
    private String phone;

    @OneToMany(mappedBy = "lead", cascade = CascadeType.ALL)
    private List<Project> projectList = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company lead_company;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public List<Project> getProjectList() {
        return projectList;
    }

    public void setProjectList(List<Project> projectList) {
        this.projectList = projectList;
    }

    public Company getLead_company() {
        return lead_company;
    }

    public void setLead_company(Company lead_company) {
        this.lead_company = lead_company;
    }
}
