package fr.nathansakkriou.facturesfx.model.entity;

public class Individual extends Entity{
    public Individual(String name, String address, String postalCode, String city, String phoneNumber, EntityType type) {
        super(name, address, postalCode, city, phoneNumber);
        this.setEntityType(type);
    }
}
