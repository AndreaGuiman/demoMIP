package com.exampledb.demodb.model;

import javax.persistence.*;

@Entity
public class Clients {
    @Id
    @Column(name = "idClient")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idClient;

    @Column(name = "firstNameClient")
    private String firstNameClient;

    @Column(name = "lastNameClient")
    private String lastNameClient;

    @Column(name = "emailAddressClient")
    private String emailAddressClient;

    public Clients() {
    }

    public Clients(String firstNameClient, String lastNameClient, String emailAddressClient) {
        this.firstNameClient = firstNameClient;
        this.lastNameClient = lastNameClient;
        this.emailAddressClient = emailAddressClient;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public String getFirstNameClient() {
        return firstNameClient;
    }

    public void setFirstNameClient(String firstNameClient) {
        this.firstNameClient = firstNameClient;
    }

    public String getLastNameClient() {
        return lastNameClient;
    }

    public void setLastNameClient(String lastNameClient) {
        this.lastNameClient = lastNameClient;
    }

    public String getEmailAddressClient() {
        return emailAddressClient;
    }

    public void setEmailAddressClient(String emailAddressClient) {
        this.emailAddressClient = emailAddressClient;
    }

    @Override
    public String toString() {
        return "Clients{" +
                "idClient=" + idClient +
                ", firstNameClient='" + firstNameClient + '\'' +
                ", lastNameClient='" + lastNameClient + '\'' +
                ", emailAddressClient='" + emailAddressClient + '\'' +
                '}';
    }
}
