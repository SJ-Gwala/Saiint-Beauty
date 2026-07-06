/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.entity.bl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import za.ac.tut.entity.model.Availability;
import za.ac.tut.entity.model.Booking;
import za.ac.tut.entity.model.Client;

/**
 *
 * @author sihle
 */
@javax.ejb.Stateless
public class BookingFacade extends AbstractFacade<Booking> {

    @PersistenceContext(unitName = "SaiintBeautyEJBModulePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BookingFacade() {
        super(Booking.class);
    }
    
    public void createBooking(Booking booking) {
    em.persist(booking);
}
    
    public void updateAvailability(Availability a) {
    em.merge(a);
}
    
   public boolean slotTaken(String date, String time) {

    Long count = em.createQuery(
        "SELECT COUNT(b) FROM Booking b "
        + "WHERE b.bookingDate = :date "
        + "AND b.bookingTime = :time "
        + "AND b.bookingStatus <> 'REJECTED'",
        Long.class
    )
    .setParameter("date", date)
    .setParameter("time", time)
    .getSingleResult();

    return count > 0;
}
    public List<Booking> findByClient(Client client) {

    return em.createQuery(
        "SELECT b FROM Booking b WHERE b.client = :client",
        Booking.class
    )
    .setParameter("client", client)
    .getResultList();
}
}
