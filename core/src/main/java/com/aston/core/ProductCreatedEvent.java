package com.aston.core;

public class ProductCreatedEvent {
    private String title;
    private String company;

    public ProductCreatedEvent() {
    }

    public ProductCreatedEvent(String title, String company) {
        this.title = title;
        this.company = company;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
