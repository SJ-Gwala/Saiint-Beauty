package za.ac.tut.entity.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import za.ac.tut.entity.model.Booking;
import za.ac.tut.entity.model.PunchCard;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2026-05-12T10:31:14")
@StaticMetamodel(Service.class)
public class Service_ { 

    public static volatile SingularAttribute<Service, Double> price;
    public static volatile SingularAttribute<Service, Long> serviceId;
    public static volatile SingularAttribute<Service, String> serviceName;
    public static volatile ListAttribute<Service, Booking> bookings;
    public static volatile ListAttribute<Service, PunchCard> punchCards;

}