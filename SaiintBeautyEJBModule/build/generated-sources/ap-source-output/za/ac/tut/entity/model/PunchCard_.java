package za.ac.tut.entity.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import za.ac.tut.entity.model.Client;
import za.ac.tut.entity.model.Service;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2026-05-12T10:31:14")
@StaticMetamodel(PunchCard.class)
public class PunchCard_ { 

    public static volatile SingularAttribute<PunchCard, Integer> punches;
    public static volatile SingularAttribute<PunchCard, Long> punchId;
    public static volatile SingularAttribute<PunchCard, Service> service;
    public static volatile SingularAttribute<PunchCard, Client> client;

}