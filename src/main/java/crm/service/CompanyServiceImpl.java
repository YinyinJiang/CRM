package crm.service;


import crm.dao.CompanyDao;
import crm.model.Company;
import crm.model.Project;
import crm.model.SubScore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    private CompanyDao companyDao;

    @Override
    public void addCompany(Company company) {
        companyDao.addCompany(company);
    }

    @Override
    public Company getCompanyByCompanyId(int companyId) {
        return companyDao.getCompanyByCompanyId(companyId);
    }

    @Override
    public List<Company> getCompanyList() {
        return companyDao.getCompanyList();
    }

    @Override
    public List<Project> getCompanyProjectList(int companyId) {
        return companyDao.getCompanyProjectList(companyId);
    }

    @Override
    public List<SubScore> getCompanySubScoreList(int companyId) {
        return companyDao.getCompanySubScoreList(companyId);
    }
}
