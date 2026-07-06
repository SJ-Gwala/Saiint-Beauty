/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.entity.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class PunchCard implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long punchId;

    private Integer punches;

    @ManyToOne
    private Client client;

    @ManyToOne
    private Service service;

    public PunchCard() {
    }

    public PunchCard(Long punchId, Integer punches, Client client, Service service) {
        this.punchId = punchId;
        this.punches = punches;
        this.client = client;
        this.service = service;
    }

    public Long getPunchId() {
        return punchId;
    }

    public void setPunchId(Long punchId) {
        this.punchId = punchId;
    }

    public Integer getPunches() {
        return punches;
    }

    public void setPunches(Integer punches) {
        this.punches = punches;
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