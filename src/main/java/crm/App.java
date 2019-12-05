package crm;

import java.util.ArrayList;
import java.util.List;

import crm.ApplicationConfig;
import crm.model.Category;
import crm.model.Company;
import crm.model.Lead;
import crm.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);

        SessionFactory sessionFactory = (SessionFactory) context.getBean("sessionFactory");

        Session session = sessionFactory.openSession();

        session.beginTransaction();

        User user1 = new User();
        user1.setName("Alice");
        session.save(user1);

        User user2 = new User();
        user2.setName("Bob");
        session.save(user2);

        // ManyToMany example
        Company company1 = new Company();
        company1.setName("Apple");
        company1.setContact("QQQQQ");
        company1.setPhone("12345678910");
        session.save(company1);

        Company company2 = new Company();
        company2.setName("Amazon");
        company2.setContact("WWWWW");
        company2.setPhone("10987654321");
        session.save(company2);


        List<Company> user1CompanyList = new ArrayList<>();
        user1CompanyList.add(company1);
        user1.setUserCompanyList(user1CompanyList);
        session.save(user1);

        List<Company> user2CompanyList = new ArrayList<>();
        user2CompanyList.add(company1);
        user2CompanyList.add(company2);
        user2.setUserCompanyList(user2CompanyList);
        session.save(user2);

        session.getTransaction().commit();
    }
}
