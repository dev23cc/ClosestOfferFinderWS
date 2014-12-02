/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.myoffers.ws.wsoffer.dao;

import gr.myoffers.ws.wsoffer.model.Company;
import gr.myoffers.ws.wsoffer.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author fil
 */
public class CompanyDao implements ICompanyDao{
    
       SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
       
   @Override
    public Company getCompanyById(int companyId) {
        Company company = null;
        Session session = null;

        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            company = (Company)session.createQuery("from  Company c where c.companyId=:id").setParameter("id",companyId).uniqueResult();
            session.getTransaction().commit();

        } catch (Exception ex) {
            if (session != null) {
                session.getTransaction().rollback();
            }

        } finally {
            if (session != null) {
                session.close();
            }
        }

        return company;

    }
    
    //returns all Companies
    @Override
     public List<Company> getAllCompanies() {
        List<Company> companies = null;
        Session session = null;

        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            companies = session.createQuery("from Company c order by c.compName").list();
            session.getTransaction().commit();

        } catch (Exception ex) {
            if (session != null) {
                session.getTransaction().rollback();
            }

        } finally {
            if (session != null) {
                session.close();
            }
        }
        return companies;
        
 
        
        

    }
     

    @Override
     public List<Company> getCompaniesByRadius( double lat,  double lon, double r) {
        List<Company> companies = null;
        Session session = null;
        try {
            double dist =r/111; 
            session = sessionFactory.openSession();
            session.beginTransaction();
            String hgl="from Company c where (pow((c.latitude-:lat),2) +  pow((c.longitude-:lon),2))<pow((:r),2)";
            companies= session.createQuery(hgl)
                    .setParameter("lon", lon)
                    .setParameter("lat", lat)
                    .setDouble("r", r)
                    .list();
            //         
            session.getTransaction().commit();
       
        } catch (Exception ex) {
            if (session != null) {
                session.getTransaction().rollback();
            }

        } finally {
            if (session != null) {
                session.close();
            }
        }
        return companies;
  
}
}