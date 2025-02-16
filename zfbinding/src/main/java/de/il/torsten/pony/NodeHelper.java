package de.il.torsten.pony;

import un.unece.uncefact.data.standard.qualifieddatatype._100.CountryIDType;
import un.unece.uncefact.data.standard.qualifieddatatype._100.CurrencyCodeType;
import un.unece.uncefact.data.standard.qualifieddatatype._100.TaxCategoryCodeType;
import un.unece.uncefact.data.standard.qualifieddatatype._100.TaxTypeCodeType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.TradePriceType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.*;

import java.math.BigDecimal;

public class NodeHelper {

    // Utility class won't be initialized
    private NodeHelper() {
    }

    public static IDType getIDType(String value, String schemeID) {
        IDType idType = new un.unece.uncefact.data.standard.unqualifieddatatype._100.ObjectFactory().createIDType();
        idType.setValue(value);
        idType.setSchemeID(schemeID);
        return idType;
    }

    public static IDType getIDType(String value) {
        return getIDType(value, null);
    }

    public static TextType getTextType(String value) {
        TextType textType = new un.unece.uncefact.data.standard.unqualifieddatatype._100.ObjectFactory().createTextType();
        textType.setValue(value);
        return textType;
    }


    public static TradePriceType createTradePriceType(BigDecimal priceAmount) {
        // Befülle das Objekt TradePriceType mit dem übergebenen Preis
        TradePriceType priceType = new TradePriceType();
        priceType.setChargeAmount(createAmountType(priceAmount));
        return priceType;
    }

    // Methode zum Erstellen des AmountType-Objekts und setzen des Betrags
    public static AmountType createAmountType(BigDecimal priceAmount, String currencyCode) {
        AmountType amountType = new AmountType();
        amountType.setValue(priceAmount);
        amountType.setCurrencyID(currencyCode);
        return amountType;
    }

    public static AmountType createAmountType(BigDecimal priceAmount) {
        return createAmountType(priceAmount, null);
    }

    public static QuantityType createQuantityType(BigDecimal quantityAmount, String unitCode) {
        QuantityType quantityType = new QuantityType();
        quantityType.setValue(quantityAmount);
        quantityType.setUnitCode(unitCode);
        return quantityType;
    }

    public static QuantityType createQuantityType(BigDecimal quantityAmount) {
        // by default use the unit code for "H87" (pice)
        return createQuantityType(quantityAmount, UnitType.UT_H87.code);
    }

    public static CodeType getCodeType(String subjectCode) {
        CodeType codeType = new CodeType();
        codeType.setValue(subjectCode);
        return codeType;
    }

    public static CurrencyCodeType getCurrencyCodeType(String currencyCode) {
        CurrencyCodeType currencyCodeType = new CurrencyCodeType();
        currencyCodeType.setValue(currencyCode);
        return currencyCodeType;
    }

    public static TaxTypeCodeType getTaxCodeType(String taxCode) {
        TaxTypeCodeType taxTypeCodeType = new TaxTypeCodeType();
        taxTypeCodeType.setValue(taxCode);
        return taxTypeCodeType;
    }

    public static TaxCategoryCodeType getTaxCategoryCodeType(String categoryCode) {
        // Erstelle ein TaxCategoryCodeType-Objekt und setze den übergebenen Code
        TaxCategoryCodeType taxCategoryCodeType = new TaxCategoryCodeType();
        taxCategoryCodeType.setValue(categoryCode);
        return taxCategoryCodeType;
    }

    public static PercentType getPercentType(BigDecimal rate) {
        // Erstelle ein PercentType-Objekt und setze den übergebenen Prozentsatz
        PercentType percentType = new PercentType();
        percentType.setValue(rate);
        return percentType;
    }

    public static CountryIDType getCountryIDType(String country) {
        // Erstelle ein CountryIDType-Objekt und setze den übergebenen Ländercode
        CountryIDType countryIDType = new CountryIDType();
        countryIDType.setValue(country);
        return countryIDType;
    }
}
