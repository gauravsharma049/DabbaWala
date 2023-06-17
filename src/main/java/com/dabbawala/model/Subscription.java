package com.dabbawala.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int subscriptionId;
    @OneToOne
    private Resturant resturant;
    @OneToOne
    private User user;
    private int deliveryCount;
    private int deliveryLimit;
    private boolean isActive;
    private double subscriptionCharge;
    @OneToMany
    private List<Delivery> deliveries;
}
