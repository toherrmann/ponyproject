package de.il.torsten.pony;

@SuppressWarnings("unused")
public enum DateTimeFormat {
    DF_102("CCYYMMDD", "uuuuMMdd"),
    DF_205("CCYYMMDDHHMMZHHMM", "uuuuMMddHHmmXX");

    public final String code, codeName, formatPattern;

    DateTimeFormat(String aName, String pattern) {
        this.code = name().split("_")[1];
        this.codeName = aName;
        this.formatPattern = pattern;
    }

}
