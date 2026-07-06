/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.entity.bl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import za.ac.tut.entity.model.Client;

/**
 *
 * @author sihle
 */
@javax.ejb.Stateless
public class ClientFacade extends AbstractFacade<Client> {

    @PersistenceContext(unitName = "SaiintBeautyEJBModulePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClientFacade() {
        super(Client.class);
    }
    
    public Client login(String phoneNumber, String password) {

    TypedQuery<Client> query = em.createQuery(
        "SELECT c FROM Client c WHERE c.phoneNumber = :phone AND c.password = :pass",
        Client.class
    );

    query.setParameter("phone", phoneNumber);
    query.setParameter("pass", password);

    try {
        return query.getSingleResult();
    } catch (Exception e) {
        return null;
    }
}
    public void registerClient(Client client) {
    em.persist(client);
}
}
