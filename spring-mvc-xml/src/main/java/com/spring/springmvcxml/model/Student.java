package com.spring.springmvcxml.model;

import java.util.LinkedHashMap;

public class Student {
    private String firstName;
    private String lastName;
    private String country;
    private String favoriteLanguage;
    private String[] operatingSystems;
    private LinkedHashMap<String, String> countryOptions;
    private LinkedHashMap<String, String> languageOptions;
    private LinkedHashMap<String, String> osOptions;
    public Student() {
        countryOptions = new LinkedHashMap<>();
        languageOptions = new LinkedHashMap<>();
        osOptions = new LinkedHashMap<>();
        countryOptions.put("BR", "Brazil");
        countryOptions.put("FR", "France");
        countryOptions.put("DE", "Germany");
        countryOptions.put("IN", "India");
        languageOptions.put("Java", "Java");
        languageOptions.put("C#", "C#");
        languageOptions.put("PHP", "PHP");
        languageOptions.put("Ruby", "Ruby"); 
        osOptions.put("Linux", "Linux");
        osOptions.put("Mac OS", "Mac OS");
        osOptions.put("MS Windows", "MS Windows");
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }    
    public String getFavoriteLanguage() {
        return favoriteLanguage;
    }
    public void setFavoriteLanguage(String favoriteLanguage) {
        this.favoriteLanguage = favoriteLanguage;
    }
    public String[] getOperatingSystems() {
        return operatingSystems;
    }
    public void setOperatingSystems(String[] operatingSystems) {
        this.operatingSystems = operatingSystems;
    }
    public LinkedHashMap<String, String> getCountryOptions() {
        return countryOptions;
    }
    public LinkedHashMap<String, String> getLanguageOptions() {
        return languageOptions;
    }
    public LinkedHashMap<String, String> getOsOptions() {
        return osOptions;
    }
    @Override
    public String toString() {
        return "Student [country=" + country + ", firstName=" + firstName + ", lastName=" + lastName + "]";
    }
}
