package de.il.torsten.pony;

@SuppressWarnings("unused")
public enum TaxIdTypeCode {
    VA("Value added tax"),
    FC("Fiscal number");

    public final String code, name;

    TaxIdTypeCode(String aName) {
        this.code = name();
        this.name = aName;
    }

}
