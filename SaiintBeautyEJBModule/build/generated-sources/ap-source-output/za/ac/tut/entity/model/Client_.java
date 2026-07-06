package za.ac.tut.entity.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import za.ac.tut.entity.model.Booking;
import za.ac.tut.entity.model.PunchCard;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2026-05-12T10:31:14")
@StaticMetamodel(Client.class)
public class Client_ { 

    public static volatile SingularAttribute<Client, String> password;
    public static volatile SingularAttribute<Client, Long> clientId;
    public static volatile SingularAttribute<Client, String> phoneNumber;
    public static volatile SingularAttribute<Client, String> name;
    public static volatile ListAttribute<Client, Booking> bookings;
    public static volatile ListAttribute<Client, PunchCard> punchCards;

}