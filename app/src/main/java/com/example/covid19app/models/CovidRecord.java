package com.example.covid19app.models;

import com.google.gson.annotations.SerializedName;

public class CovidRecord {
    @SerializedName("dateRep")
    private String dateRep;
    @SerializedName("day")
    
    private String day;
    @SerializedName("month")
    
    private String month;
    @SerializedName("year")
    
    private String year;
    @SerializedName("cases")
    
    private String cases;
    @SerializedName("deaths")
    
    private String deaths;
    @SerializedName("countriesAndTerritories")
    
    private String countriesAndTerritories;
    @SerializedName("geoId")
    
    private String geoId;
    @SerializedName("countryterritoryCode")
    
    private String countryterritoryCode;
    @SerializedName("popData2018")
    
    private String popData2018;

    public String getDateRep() {
        return dateRep;
    }

    public void setDateRep(String dateRep) {
        this.dateRep = dateRep;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getCases() {
        return cases;
    }

    public void setCases(String cases) {
        this.cases = cases;
    }

    public String getDeaths() {
        return deaths;
    }

    public void setDeaths(String deaths) {
        this.deaths = deaths;
    }

    public String getCountriesAndTerritories() {
        return countriesAndTerritories;
    }

    public void setCountriesAndTerritories(String countriesAndTerritories) {
        this.countriesAndTerritories = countriesAndTerritories;
    }

    public String getGeoId() {
        return geoId;
    }

    public void setGeoId(String geoId) {
        this.geoId = geoId;
    }

    public String getCountryterritoryCode() {
        return countryterritoryCode;
    }

    public void setCountryterritoryCode(String countryterritoryCode) {
        this.countryterritoryCode = countryterritoryCode;
    }

    public String getPopData2018() {
        return popData2018;
    }

    public void setPopData2018(String popData2018) {
        this.popData2018 = popData2018;
    }


}
