package fr.nathansakkriou.facturesfx.model.entity;

public class Compagny extends Entity{

    private String siret;
    public Compagny(String name, String address, String postalCode, String city, String phoneNumber, String siret, EntityType type) {
        super(name, address, postalCode, city, phoneNumber);
        this.siret = siret;
        this.setEntityType(type);
    }

    public String getSiret() {
        return siret;
    }

    public void setSiret(String siret) {
        this.siret = siret;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
                siret;
    }
}
