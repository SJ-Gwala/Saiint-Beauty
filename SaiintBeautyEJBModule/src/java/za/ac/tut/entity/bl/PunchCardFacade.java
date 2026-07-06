/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.entity.bl;


import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import za.ac.tut.entity.model.PunchCard;
import za.ac.tut.entity.model.Client;

/**
 *
 * @author sihle
 */
@javax.ejb.Stateless
public class PunchCardFacade extends AbstractFacade<PunchCard> {

    @PersistenceContext(unitName = "SaiintBeautyEJBModulePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PunchCardFacade() {
        super(PunchCard.class);
    }
    
   public void addOrUpdatePunch(PunchCard newCard) {

    List<PunchCard> list = em.createQuery(
        "SELECT p FROM PunchCard p "
      + "WHERE p.client.clientId = :clientId "
      + "AND p.service.serviceId = :serviceId",
        PunchCard.class
    )
    .setParameter("clientId",
            newCard.getClient().getClientId())
    .setParameter("serviceId",
            newCard.getService().getServiceId())
    .getResultList();

    if(list.isEmpty()) {

        em.persist(newCard);

    } else {

        PunchCard existing = list.get(0);

        existing.setPunches(
                existing.getPunches() + 1
        );

        em.merge(existing);
    }
}

    public List<PunchCard> findByClient(Client client) {

    return em.createQuery(
        "SELECT p FROM PunchCard p WHERE p.client = :client",
        PunchCard.class
    )
    .setParameter("client", client)
    .getResultList();
}
  
}
