package com.cashup.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
public class Order implements Serializable {

    public enum Currency {
        USD,
        UAH,
        EUR
    }

    public enum Status {
        OPEN,
        CONFIRMED,
        CLOSED;
    }

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id")
    private int id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @Column(columnDefinition = "TIMESTAMP")
    private Timestamp date = Timestamp.valueOf(LocalDateTime.now());

    private long price;

    @Enumerated(EnumType.STRING)
    private Currency currency = Currency.UAH;

    @Enumerated(EnumType.STRING)
    private Status status = Status.OPEN;

    public int getId() {
        return id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
