package za.ac.tut.entity.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import za.ac.tut.entity.model.Client;
import za.ac.tut.entity.model.Service;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2026-05-12T10:31:14")
@StaticMetamodel(Booking.class)
public class Booking_ { 

    public static volatile SingularAttribute<Booking, String> bookingTime;
    public static volatile SingularAttribute<Booking, Service> service;
    public static volatile SingularAttribute<Booking, String> bookingStatus;
    public static volatile SingularAttribute<Booking, Client> client;
    public static volatile SingularAttribute<Booking, String> bookingDate;
    public static volatile SingularAttribute<Booking, Long> bookingId;

}