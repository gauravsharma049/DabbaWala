package com.dabbawala.controller.apis;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dabbawala.model.City;
import com.dabbawala.model.Country;
import com.dabbawala.model.Delivery;
import com.dabbawala.model.District;
import com.dabbawala.model.Resturant;
import com.dabbawala.model.ResturantOwner;
import com.dabbawala.model.State;
import com.dabbawala.model.Subscription;
import com.dabbawala.service.DabbaWalaService;

@RestController
@RequestMapping("/resturants")
@CrossOrigin
public class DabbaWalaRestController {
    @Autowired
    private DabbaWalaService dabbaWalaService;
    @GetMapping("")
    public List<Resturant> getAllResturants(){ 
        return dabbaWalaService.getAllResturants();
    }
    @GetMapping("/country/{keyword}")  
    public List<Resturant> getResturantsByCountry(@PathVariable("keyword") String keyword){
        System.out.println("keyword: "+keyword);
        Country country = dabbaWalaService.getCountryByName(keyword);
        if(country == null) {
            System.out.println("country is null");
            return null;
        }
        return dabbaWalaService.getResturantsByCountryName(country.getCountryName());
    }

    @GetMapping("/state/{keyword}")
    public List<Resturant> getResturantsByState(@PathVariable("keyword") String keyword){
        System.out.println("keyword: "+keyword);
        State state = dabbaWalaService.getStateByName(keyword);
        if(state == null) {
            System.out.println("state is null");
            return null;
        }
        return dabbaWalaService.getResturantsByStateName(state.getStateName());
    }

    @GetMapping("/district/{keyword}")
    public List<Resturant> getResturantsByDistrict(@PathVariable("keyword") String keyword){
        System.out.println("keyword: "+keyword);
        District district = dabbaWalaService.getDistrictByName(keyword);
        if(district == null) {
            System.out.println("district is null");
            return null;
        }
        return dabbaWalaService.getResturantsByDistrictName(district.getDistrictName());
    }

    @GetMapping("/city/{keyword}")
    public List<Resturant> getResturantsByCity(@PathVariable("keyword") String keyword){
        System.out.println("keyword: "+keyword);
        City city = dabbaWalaService.getCityByName(keyword);
        if(city == null) {
            System.out.println("city is null");
            return null;
        }
        return dabbaWalaService.getResturantsByCityName(city.getCityName());
    }

    @GetMapping("/{keyword}")
    public Resturant getResturantByResturantName(@PathVariable("keyword") String keyword){
        System.out.println("keyword: "+keyword);
        return dabbaWalaService.getResturantByResturantName(keyword);
    }

    @PostMapping("/add-resturant/{ownerId}")
    public Resturant addResturant(@RequestBody Resturant resturant, @PathVariable("ownerId") int id) {
        return dabbaWalaService.addResturant(id, resturant);
    }

    @PostMapping("/add-owner")
    public ResturantOwner addOwner(@RequestBody ResturantOwner owner) {
        System.out.println(owner);
        return dabbaWalaService.addResturantOwner(owner);
    }

    @GetMapping("/get-owners")
    public List<ResturantOwner> getOwners(){
        return dabbaWalaService.getResturantOwners();
    }
    @PostMapping("/add-subscription")
    public Subscription addSubscription(@RequestBody Subscription subscription){
        return dabbaWalaService.addSubscription(subscription);
    }
    @GetMapping("/get-subscription")
    public List<Subscription> getAllSubscriptions(){
        
        return dabbaWalaService.getAllSubscriptions();
    }
    @PostMapping("/add-delivery")
    public Delivery addDelivery(@RequestBody Delivery delivery){
        return dabbaWalaService.addDelivery(delivery);
    }
}
