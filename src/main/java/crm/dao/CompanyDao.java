package crm.dao;

import crm.model.Company;

public interface CompanyDao {
    public void addCompany(Company company);
    public Company getCompanyByCompanyId(int companyId);
}
