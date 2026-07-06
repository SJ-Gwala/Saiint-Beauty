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
public class Client implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CLIENTID")
    private Long clientId;

    private String name;
    private String phoneNumber;
    private String password;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<Booking> bookings;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<PunchCard> punchCards;

    public Client() {
    }

    public Client(Long clientId, String name, String phoneNumber, String password) {
        this.clientId = clientId;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    public List<PunchCard> getPunchCards() {
        return punchCards;
    }

    public void setPunchCards(List<PunchCard> punchCards) {
        this.punchCards = punchCards;
    }
}