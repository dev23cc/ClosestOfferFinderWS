/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.myoffers.ws.wsoffrer.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author fil
 */
@Entity
@Table(name="OFFER")
@XmlRootElement(name = "offer")
@XmlType(propOrder={"id","descr","axia"})

public class Offer {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="ID")
    private int id;
    @Column(name="DESCR")
    private String descr;
    @Column(name="AXIA")
    private double axia;
@XmlElement
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
@XmlElement
    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }
@XmlElement
    public double getAxia() {
        return axia;
    }

    public void setAxia(double axia) {
        this.axia = axia;
    }
    
}
