package com.automation.practice.acceptance.tests.utils;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class DataBuilder {

    public int getTitle() {
        return title;
    }

    public String getEmail() {
        return email;
    }

    public String getPassWord() {
        return passWord;
    }

    public List<String> getDob() {
        return dob;
    }

    public String getFirstN() {
        return firstN;
    }

    public String getLastN() {
        return lastN;
    }

    public String getCompany() {
        return company;
    }

    public String getEnterAddressLine1() {
        return enterAddressLine1;
    }

    public String getEnterAddressLine2() {
        return enterAddressLine2;
    }

    public String getEnterCity() {
        return enterCity;
    }

    public int getEnterState() {
        return enterState;
    }

    public String getEnterPostCode() {
        return enterPostCode;
    }

    public String getEnterMobilePhone() {
        return enterMobilePhone;
    }

    int title = new Faker().number().numberBetween(1, 2);
    String email = new FakeValuesService(new Locale("en-GB"), new RandomService()).bothify("????##@gmail.com");
    String passWord = new FakeValuesService(new Locale("en-GB"), new RandomService()).regexify("[a-z1-9]{10}");
    List<String> dob = Arrays.asList(new SimpleDateFormat("d M yyyy").format(new Faker().date().birthday()).split("\\s"));
    String firstN = new Faker().name().firstName();
    String lastN = new Faker().name().lastName();
    String company = new Faker().company().name();
    String enterAddressLine1 = new Faker().address().buildingNumber();
    String enterAddressLine2 = new Faker().address().streetName();
    String enterCity = new Faker().address().cityName();
    int enterState = new Faker().number().numberBetween(1, 50);
    String enterPostCode = new FakeValuesService(new Locale("en-GB"), new RandomService()).regexify("[1-9]{5}");
    String enterMobilePhone = new Faker().phoneNumber().cellPhone();

    public DataBuilder title(int title) {
        this.title = title;
        return this;
    }

    public DataBuilder email(String email) {
        this.email = email;
        return this;
    }

    public DataBuilder passWord(String passWord) {
        this.passWord = passWord;
        return this;
    }

    public DataBuilder dob(List<String> dob) {
        this.dob = dob;
        return this;
    }

    public DataBuilder firstN(String firstN) {
        this.firstN = firstN;
        return this;
    }

    public DataBuilder lastN(String lastN) {
        this.lastN = lastN;
        return this;
    }

    public DataBuilder company(String company) {
        this.company = company;
        return this;
    }

    public DataBuilder enterAddressLine1(String enterAddressLine1) {
        this.enterAddressLine1 = enterAddressLine1;
        return this;
    }

    public DataBuilder enterAddressLine2(String enterAddressLine2) {
        this.enterAddressLine2 = enterAddressLine1;
        return this;
    }

    public DataBuilder enterCity(String enterCity) {
        this.enterCity = enterCity;
        return this;
    }

    public DataBuilder enterState(int enterState) {
        this.enterState = enterState;
        return this;
    }

    public DataBuilder enterPostCode(String enterPostCode) {
        this.enterPostCode = enterPostCode;
        return this;
    }

    public DataBuilder enterMobilePhone(String enterMobilePhone) {
        this.enterMobilePhone = enterMobilePhone;
        return this;
    }

    public DataBuilder build() {
        return this;
    }
}
