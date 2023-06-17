package com.dabbawala.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResturantOwner {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int resturantOwnerId;

    private String resturantOwnerName;
    @OneToOne
    private Resturant resturant;

    @OneToOne(cascade = CascadeType.ALL)
    private User user;

}
