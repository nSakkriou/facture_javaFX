package fr.nathansakkriou.facturesfx.model.entity;

public class CompagnyBuilder{

    private String siret;
    private EntityType type = null;
    private String name = null;
    private String address = null;
    private String postalCode = null;
    private String city = null;
    private String phoneNumber = null;

    public CompagnyBuilder() {
    }
    public CompagnyBuilder entityType(EntityType type){
        this.type = type;
        return this;
    }
    public CompagnyBuilder name(String name){
        this.name = name;
        return this;
    }

    public CompagnyBuilder address(String address){
        this.address = address;
        return this;
    }

    public CompagnyBuilder postalCode(String postalCode){
        this.postalCode = postalCode;
        return this;
    }

    public CompagnyBuilder city(String city){
        this.city = city;
        return this;
    }

    public CompagnyBuilder phoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public CompagnyBuilder siret(String siret){
        this.siret = siret;
        return this;
    }

    public Compagny build(){
        return new Compagny(getName(), getAddress(), getPostalCode(), getCity(), getPhoneNumber(), this.siret, getType());
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
