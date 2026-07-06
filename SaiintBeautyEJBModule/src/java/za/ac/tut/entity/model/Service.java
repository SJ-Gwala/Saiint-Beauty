
package za.ac.tut.entity.model;


import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Service implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SERVICEID")
    private Long serviceId;

    private String serviceName;
    private Double price;

    @OneToMany(mappedBy = "service", cascade = CascadeType.ALL)
    private List<Booking> bookings;

    @OneToMany(mappedBy = "service", cascade = CascadeType.ALL)
    private List<PunchCard> punchCards;

    public Service() {
    }

    public Service(Long serviceId, String serviceName, Double price) {
        this.serviceId = serviceId;
        this.serviceName = serviceName;
        this.price = price;
    }

    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}