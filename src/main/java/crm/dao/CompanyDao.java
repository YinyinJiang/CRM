package crm.dao;

import crm.model.Company;
import crm.model.Project;
import crm.model.SubScore;

import java.util.List;

public interface CompanyDao {
    void addCompany(Company company);
    Company getCompanyByCompanyId(int companyId);
    List<Company> getCompanyList();
    List<Project> getCompanyProjectList(int companyId);
    List<SubScore> getCompanySubScoreList(int companyId);

}
