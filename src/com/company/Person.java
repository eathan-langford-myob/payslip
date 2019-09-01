package com.company;

import java.time.LocalDate;
import java.time.Year;
import java.time.format.DateTimeFormatter;

public class Person {
    String name;
    String surename;
    int annualSalary;
    int superRate;
    LocalDate startDate;
    LocalDate endDate;

    public Person(String name, String surename, int annualSalary, int superRate, LocalDate startDate, LocalDate endDate) {
        this.name = name;
        this.surename = surename;
        this.annualSalary = annualSalary;
        this.superRate = superRate;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Person(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurename() {
        return surename;
    }

    public void setSurename(String surename) {
        this.surename = surename;
    }

    public int getAnnualSalary() {
        return annualSalary;
    }

    public void setAnnualSalary(String annualSalary) {
        this.annualSalary = Integer.parseInt(annualSalary);
    }

    public int getSuperRate() {
        return superRate;
    }

    public void setSuperRate(String superRate) {
        this.superRate = Integer.parseInt(superRate);
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        startDate = Main.capitalize(startDate);
        DateTimeFormatter format = DateTimeFormatter.ofPattern("d MMMM yyyy");
        startDate += " ";
        startDate += Year.now().toString();
        LocalDate date = LocalDate.parse(startDate, format);
        System.out.println(date);
        this.startDate = date;
    }

    public LocalDate getEndDate() {
        return endDate;
    }


    public void setEndDate(String endDate) {
        endDate = Main.capitalize(endDate);
        DateTimeFormatter format = DateTimeFormatter.ofPattern("d MMMM yyyy");
        endDate += " ";
        endDate += Year.now().toString();
        LocalDate date = LocalDate.parse(endDate, format);
        System.out.println(date);
        this.endDate = date;
    }

    public void constructPersonDetails(String[] details, Person user){
        user.setName(details[0]);
        user.setSurename(details[1]);
        user.setAnnualSalary(details[2]);
        user.setSuperRate(details[3]);
        user.setStartDate(details[4]);
        user.setEndDate(details[5]);
    }
}