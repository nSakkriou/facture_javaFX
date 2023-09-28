package fr.nathansakkriou.facturesfx.model.entity;

public abstract class IndividualBuilder {
    private EntityType type = null;
    private String name = null;
    private String address = null;
    private String postalCode = null;
    private String city = null;
    private String phoneNumber = null;

    public IndividualBuilder entityType(EntityType type){
        this.type = type;
        return this;
    }
    public IndividualBuilder name(String name){
        this.name = name;
        return this;
    }

    public IndividualBuilder address(String address){
        this.address = address;
        return this;
    }

    public IndividualBuilder postalCode(String postalCode){
        this.postalCode = postalCode;
        return this;
    }

    public IndividualBuilder city(String city){
        this.city = city;
        return this;
    }

    public IndividualBuilder phoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public EntityType getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getCity() {
        return city;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
