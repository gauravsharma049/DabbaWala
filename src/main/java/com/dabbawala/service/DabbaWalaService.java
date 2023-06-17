package com.dabbawala.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dabbawala.model.City;
import com.dabbawala.model.Country;
import com.dabbawala.model.Delivery;
import com.dabbawala.model.District;
import com.dabbawala.model.Resturant;
import com.dabbawala.model.ResturantOwner;
import com.dabbawala.model.State;
import com.dabbawala.model.Subscription;
import com.dabbawala.repository.CityRepository;
import com.dabbawala.repository.CountryRepository;
import com.dabbawala.repository.DeliveryRepository;
import com.dabbawala.repository.DistrictRepository;
import com.dabbawala.repository.ResturantOwnerRepository;
import com.dabbawala.repository.ResturantRepository;
import com.dabbawala.repository.StateRepository;
import com.dabbawala.repository.SubscriptionRepository;

@Service
public class DabbaWalaService {
    @Autowired private ResturantRepository resturantRepository;
    @Autowired private CityRepository cityRepository;
    @Autowired private StateRepository stateRepository;
    @Autowired private DistrictRepository districtRepository;
    @Autowired private CountryRepository countryRepository;
    @Autowired private ResturantOwnerRepository resturantOwnerRepository;
    @Autowired private SubscriptionRepository subscriptionRepository;
    @Autowired private DeliveryRepository deliveryRepository;

    public City getCityByName(String cityName){
        return cityRepository.findByCityName(cityName);
    }
    
    public Country addCountry(Country country){
        return countryRepository.save(country);
    }

    public State addState(State state){
        return stateRepository.save(state);
    }

    public District addDistrict(District district){
        return districtRepository.save(district);
    }

    public City addCity(City city){
        return cityRepository.save(city);
    }

    public List<Country> getAllCountries(){
        return countryRepository.findAll();
    }

    public List<State> getAllStates(){
        return stateRepository.findAll();
    }

    public List<District> getAllDistricts(){
        return districtRepository.findAll();
    }

    public List<City> getAllCities(){
        return cityRepository.findAll();
    }

    public State getStateByName(String stateName){
        return stateRepository.findByStateName(stateName);
    }

    public District getDistrictByName(String districtName){
        return districtRepository.findByDistrictName(districtName);
    }

    public Country getCountryByName(String countryName){
        return countryRepository.findByCountryName(countryName);
    }

    public List<Resturant> getAllResturants(){
        return resturantRepository.findAll();
    }

    public List<Resturant> getResturantsByCityId(int cityId){
        return resturantRepository.findByCityCityId(cityId);
    }

    public List<Resturant> getResturantsByCityName(String cityName){
        return resturantRepository.findByCityCityName(cityName);
    }

    public List<Resturant> getResturantsByStateName(String stateName){
        return resturantRepository.findByCityDistrictStateStateName(stateName);
    }

    public List<Resturant> getResturantsByDistrictName(String districtName){
        return resturantRepository.findByCityDistrictDistrictName(districtName);
    }

    public List<Resturant> getResturantsByCountryName(String countryName){
        return resturantRepository.findByCityDistrictStateCountryCountryName(countryName);
    }

    public Resturant getResturantByResturantId(int resturantId){
        return resturantRepository.findByResturantId(resturantId);
    }

    public Resturant getResturantByResturantName(String resturantName){
        return resturantRepository.findByResturantName(resturantName);
    }

    public ResturantOwner addResturantOwner(ResturantOwner resturantOwner){
        return resturantOwnerRepository.save(resturantOwner);
    }

    public Resturant addResturant(int resturantOwnerId, Resturant resturant){
        //find resturant owner using resturantOwnerId
        ResturantOwner resturantOwner = resturantOwnerRepository.findById(resturantOwnerId).get();
        System.out.println(resturantOwner);
        //save the resturant 
        Resturant savedResturant = resturantRepository.save(resturant);
        //save resturant id to owner table
        resturantOwner.setResturant(savedResturant);
        resturantOwnerRepository.save(resturantOwner);
        return savedResturant;
    }

    public List<ResturantOwner> getResturantOwners(){
        return resturantOwnerRepository.findAll();
    }

    public Subscription addSubscription(Subscription subscription){
        return subscriptionRepository.save(subscription);
    }

    public List<Subscription> getAllSubscriptions(){
        return subscriptionRepository.findAll();
    }

    public Delivery addDelivery(Delivery delivery){
        Subscription subscription = subscriptionRepository.findById(delivery.getSubscription().getSubscriptionId()).get();
        if(subscription.isActive()){
            if(subscription.getDeliveryCount()<subscription.getDeliveryLimit()){
                Delivery d = deliveryRepository.save(delivery);
                subscription.setDeliveryCount(subscription.getDeliveryCount()+1);
                subscriptionRepository.save(subscription);
                return d;
            }
            else{
                subscription.setActive(false);
                subscriptionRepository.save(subscription);
            }
        }
        return null;
    }

}
