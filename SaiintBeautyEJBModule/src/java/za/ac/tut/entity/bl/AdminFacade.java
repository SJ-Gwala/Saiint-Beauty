/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.entity.bl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import za.ac.tut.entity.model.Admin;

/**
 *
 * @author sihle
 */
@javax.ejb.Stateless
public class AdminFacade extends AbstractFacade<Admin> {

    @PersistenceContext(unitName = "SaiintBeautyEJBModulePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AdminFacade() {
        super(Admin.class);
    }
    
    
public Admin login(String username, String password) {

   

        TypedQuery<Admin> query = em.createQuery(
            "SELECT a FROM Admin a WHERE a.username = :user AND a.password = :pass",
            Admin.class
        );

        query.setParameter("user", username);
        query.setParameter("pass", password);
try{
        return query.getSingleResult();

    } catch(Exception e) {

        return null;
    }
}
}
    
    
    
