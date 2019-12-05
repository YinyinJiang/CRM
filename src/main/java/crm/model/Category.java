package crm.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "Category")
public class Category implements Serializable {

    private static final long serialVersionUID = 7868678678867231L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int categoryId;
    private String name;

    @ManyToOne
    @JoinColumn(name = "projectId")
    private Project categoryProject;

    @ManyToMany(mappedBy = "companyCategoryList", cascade = {CascadeType.PERSIST})
    private List<Company> categoryCompanyList = new ArrayList<>();

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Project getCategoryProject() {
        return categoryProject;
    }

    public void setCategoryProject(Project categoryProject) {
        this.categoryProject = categoryProject;
    }

    public List<Company> getCategoryCompanyList() {
        return categoryCompanyList;
    }

    public void setCategoryCompanyList(List<Company> categoryCompanyList) {
        this.categoryCompanyList = categoryCompanyList;
    }


}