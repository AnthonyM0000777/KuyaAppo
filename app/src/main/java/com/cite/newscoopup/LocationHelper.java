package com.cite.newscoopup;

public class LocationHelper {

    public Double longitude;
    public Double latitude;
    private String name;
    private String address;
    private String city;
    private String country;
    private String number;

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public LocationHelper(Double longitude, Double latitude, String name, String address, String city, String country, String number) {
        this.longitude = longitude;
        this.latitude = latitude;
        this.name = name;
        this.address = address;
        this.city = city;
        this.country = country;
        this.number = number;
    }

    public LocationHelper() {

    }
}
