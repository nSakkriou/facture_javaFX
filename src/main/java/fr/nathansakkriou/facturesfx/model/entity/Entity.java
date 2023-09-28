package fr.nathansakkriou.facturesfx.model.entity;

public abstract class Entity {
    private String name;
    private String address;
    private String postalCode;
    private String city;
    private String phoneNumber;
    private EntityType entityType;

    public Entity(String name, String address, String postalCode, String city, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.postalCode = postalCode;
        this.city = city;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString(){
        return
                "" + this.name + "\n" +
                this.address + " \n" +
                this.city + " " + this.postalCode + "\n" +
                this.phoneNumber + "\n";
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

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public EntityType getEntityType() {
        return entityType;
    }

    public void setEntityType(EntityType entityType) {
        this.entityType = entityType;
    }
}
