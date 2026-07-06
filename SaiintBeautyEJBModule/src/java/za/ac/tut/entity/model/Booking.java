/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.entity.model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
public class Booking implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BOOKINGID")
    private Long bookingId;

    private String bookingStatus;

    private String bookingDate;

    private String bookingTime;

    @ManyToOne
    private Client client;

    @ManyToOne
    private Service service;

    public Booking() {
    }

    public Booking(Long bookingId,
            String bookingStatus,
            String bookingDate,
            String bookingTime,
            Client client,
            Service service) {

        this.bookingId = bookingId;
        this.bookingStatus = bookingStatus;
        this.bookingDate = bookingDate;
        this.bookingTime = bookingTime;
        this.client = client;
        this.service = service;
    }

    public Long getBookingId() {
        return bookingId;
    }

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }

    public String getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(String bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(String bookingTime) {
        this.bookingTime = bookingTime;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }
}