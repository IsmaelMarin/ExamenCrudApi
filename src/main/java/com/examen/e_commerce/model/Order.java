package com.examen.e_commerce.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@Table(name = "`order`")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderId;

    @Temporal(TemporalType.TIMESTAMP)
    private Date orderDate;


    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;


    @ManyToOne
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;

    @OneToMany(mappedBy = "order")
    private List<OrderHasProducts> orderHasProducts;

    // Método que se ejecuta antes de persistir para establecer la fecha automáticamente
    @PrePersist
    protected void onCreate() {
        this.orderDate = new Date();
    }

}
