package de.il.torsten.pony;

@SuppressWarnings("unused")
public enum TaxCategoryCode {
    S("Standard rate","Standard rate"),
    Z("Zero rated goods","Zero rated goods"),
    E("Exempt from tax","Exempt from tax"),
    AE("VAT Reverse charge","VAT reverse charge"),
    K("VAT exempt for EEA intra-community supply of goods and services","VAT exempt for intra community supply of goods"),
    G("Free export item, tax not charged","Free export item, tax not charged"),
    O("Service outside scope of tax","Services outside scope of tax"),
    L("Canary Islands general indirect tax","Canary Islands General Indirect Tax"),
    M("Tax for production, services and importation in Ceuta and Melilla","Liable for IPSI");

    public final String code, name, description;

    TaxCategoryCode(String aName, String aDescription) {
        this.code = name();
        this.name = aName;
        this.description = aDescription;
    }

    public static String getDefault() {
        return S.code;
    }

}
