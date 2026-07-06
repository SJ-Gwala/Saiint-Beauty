/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.entity.bl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import za.ac.tut.entity.model.Service;

/**
 *
 * @author sihle
 */
@javax.ejb.Stateless
public class ServiceFacade extends AbstractFacade<Service> {

    @PersistenceContext(unitName = "SaiintBeautyEJBModulePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ServiceFacade() {
        super(Service.class);
    }
    
    public Service findByName(String name) {

    TypedQuery<Service> query = em.createQuery(
        "SELECT s FROM Service s WHERE s.serviceName = :name",
        Service.class
    );

    query.setParameter("name", name);

    return query.getSingleResult();
}
    
}
