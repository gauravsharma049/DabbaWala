package com.dabbawala.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Resturant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int resturantId;
    private String resturantName;
    private String resturantAddress;
    private String resturantContact;
    private String resturantEmail;
    @OneToOne
    private Menu menu;
    @ManyToOne
    @JsonBackReference
    private City city;
}
