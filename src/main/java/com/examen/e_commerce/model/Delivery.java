package com.examen.e_commerce.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@Getter
@Setter
@ToString
public class Delivery {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer deliveryId;

    @Enumerated(EnumType.STRING)
    private DeliveryType type;

    @Enumerated(EnumType.STRING)
    private DeliveryStatus status;

    public enum DeliveryType {
        FISICAS,DIGITALES
    }

    public enum DeliveryStatus {
        PENDIENTE, ENVIADO, ENTREGADO, CANCELADO
    }
    @OneToMany(mappedBy = "delivery", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Order> orders;

}
