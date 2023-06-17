package com.dabbawala.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int menuId;
    private String menuName;
    private String menuDescription;
    private String mondayMorningMenu;
    private String mondayAfternoonMenu;
    private String mondayEveningMenu;
    private String mondayNightMenu;
    private String tuesdayMorningMenu;
    private String tuesdayAfternoonMenu;
    private String tuesdayEveningMenu;
    private String tuesdayNightMenu;
    private String wednesdayMorningMenu;
    private String wednesdayAfternoonMenu;
    private String wednesdayEveningMenu;
    private String wednesdayNightMenu;
    private String thursdayMorningMenu;
    private String thursdayAfternoonMenu;
    private String thursdayEveningMenu;
    private String thursdayNightMenu;
    private String fridayMorningMenu;
    private String fridayAfternoonMenu;
    private String fridayEveningMenu;
    private String fridayNightMenu;
    private String saturdayMorningMenu;
    private String saturdayAfternoonMenu;
    private String saturdayEveningMenu;
    private String saturdayNightMenu;
    private String sundayMorningMenu;
    private String sundayAfternoonMenu;
    private String sundayEveningMenu;
    private String sundayNightMenu;
    @OneToOne
    @JsonBackReference
    private Resturant resturant;
}
