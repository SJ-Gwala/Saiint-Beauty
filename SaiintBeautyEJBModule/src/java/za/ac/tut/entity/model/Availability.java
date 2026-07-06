package za.ac.tut.entity.model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
public class Availability implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AVAILABILITYID")
    private Long availabilityId;

    private String unavailableDate;

    private Boolean unavailable;

    public Availability() {
    }

    public Long getAvailabilityId() {
        return availabilityId;
    }

    public void setAvailabilityId(Long availabilityId) {
        this.availabilityId = availabilityId;
    }

    public String getUnavailableDate() {
        return unavailableDate;
    }

    public void setUnavailableDate(String unavailableDate) {
        this.unavailableDate = unavailableDate;
    }

    public Boolean getUnavailable() {
        return unavailable;
    }

    public void setUnavailable(Boolean unavailable) {
        this.unavailable = unavailable;
    }
}