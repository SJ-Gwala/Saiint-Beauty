/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.entity.bl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import za.ac.tut.entity.model.Availability;

/**
 *
 * @author sihle
 */
@javax.ejb.Stateless
public class AvailabilityFacade extends AbstractFacade<Availability> {

    @PersistenceContext(unitName = "SaiintBeautyEJBModulePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AvailabilityFacade() {
        super(Availability.class);
    }
    
}
