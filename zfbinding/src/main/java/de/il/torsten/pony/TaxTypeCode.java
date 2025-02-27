package de.il.torsten.pony;

/**
 * VAT type code
 * Full List of UNTDID 5153 CODES (VAT TYPE CODES) - 2021B/EDIFACT D.21A
 */
@SuppressWarnings("unused")
public enum TaxTypeCode {
    AAA("Petroleum tax","A tax levied on the volume of petroleum being transacted."),
    AAB("Provisional countervailing duty cash","Countervailing duty paid in cash prior to a formal finding of subsidization by Customs."),
    AAC("Provisional countervailing duty bond","Countervailing duty paid by posting a bond during an investigation period prior to a formal decision on subsidization by Customs."),
    AAD("Tobacco tax","A tax levied on tobacco products."),
    AAE("Energy fee","General fee or tax for the use of energy."),
    AAF("Coffee tax","A tax levied specifically on coffee products."),
    AAG("Harmonised sales tax, Canadian","A harmonized sales tax consisting of a goods and service tax, a Canadian provincial sales tax and, as applicable, a Quebec sales tax which is recoverable."),
    AAH("Quebec sales tax","A sales tax charged within the Canadian province of Quebec which is recoverable."),
    AAI("Canadian provincial sales tax","A sales tax charged within Canadian provinces which is non-recoverable."),
    AAJ("Tax on replacement part","A tax levied on a replacement part, where the original part is returned."),
    AAK("Mineral oil tax","Tax that is levied specifically on products containing mineral oil."),
    AAL("Special tax","To indicate a special type of tax."),
    AAM("Insurance tax","A tax levied specifically on insurances."),
    AAO("Provincial Cannabis Tax","A tax levied on Cannabis products"),
    AAP("Outstanding duty interest","Fee levied due to outstanding duties to be paid"),
    ADD("Anti-dumping duty","Duty applied to goods ruled to have been dumped in an import market at a price lower than that in the exporter's domestic market."),
    BOL("Stamp duty (Imposta di Bollo)","Tax required in Italy, which may be fixed or graduated in various circumstances (e.g. VAT exempt documents or bank receipts)."),
    CAP("Agricultural levy","Levy imposed on agricultural products where there is a difference between the selling price between trading countries."),
    CAR("Car tax","A tax that is levied on the value of the automobile."),
    COC("Paper consortium tax (Italy)","Italian Paper consortium tax."),
    CST("Commodity specific tax","Tax related to a specified commodity, e.g. illuminants, salts."),
    CUD("Customs duty","Duties laid down in the Customs tariff, to which goods are liable on entering or leaving the Customs territory (CCC)."),
    CVD("Countervailing duty","A duty on imported goods applied for compensate for subsidies granted to those goods in the exporting country."),
    ENV("Environmental tax","Tax assessed for funding or assuring environmental protection or clean-up."),
    EXC("Excise duty","Customs or fiscal authorities code to identify a specific or ad valorem levy on a specific commodity, applied either domestically or at time of importation."),
    EXP("Agricultural export rebate","Monetary rebate given to the seller in certain circumstances when agricultural products are exported."),
    FET("Federal excise tax","Tax levied by the federal government on the manufacture of specific items."),
    FRE("Free","No tax levied."),
    GCN("General construction tax","General tax for construction."),
    GST("Goods and services tax","Tax levied on the final consumption of goods and services throughout the production and distribution chain."),
    ILL("Illuminants tax","Tax of illuminants."),
    IMP("Import tax","Tax assessed on imports."),
    IND("Individual tax","A tax levied based on an individual's ability to pay."),
    LAC("Business license fee","Government assessed charge for permit to do business."),
    LCN("Local construction tax","Local tax for construction."),
    LDP("Light dues payable","Fee levied on a vessel to pay for port navigation lights."),
    LOC("Local sales tax","Assessment charges on sale of goods or services by city, borough country or other taxing authorities below state or provincial level."),
    LST("Lust tax","Tax imposed for clean-up of leaky underground storage tanks."),
    MCA("Monetary compensatory amount","Levy on Common Agricultural Policy (European Union) goods used to compensate for fluctuating currencies between member states."),
    MCD("Miscellaneous cash deposit","Duty paid and held on deposit, by Customs, during an investigation period prior to a final decision being made on any aspect related to imported goods (except valuation) by Customs."),
    OTH("Other taxes","Unspecified, miscellaneous tax charges."),
    PDB("Provisional duty bond","Anti-dumping duty paid by posting a bond during an investigation period prior to a formal decision on dumping by Customs."),
    PDC("Provisional duty cash","Anti-dumping duty paid in cash prior to a formal finding of dumping by Customs."),
    PRF("Preference duty","Duties laid down in the Customs tariff, to which goods are liable on entering or leaving the Customs territory falling under a preferential regime such as Generalised System of Preferences (GSP)."),
    SCN("Special construction tax","Special tax for construction."),
    SSS("Shifted social securities","Social securities share of the invoice amount to be paid directly to the social securities collector."),
    STT("State/provincial sales tax","All applicable sale taxes by authorities at the state or provincial level, below national level."),
    SUP("Suspended duty","Duty suspended or deferred from payment."),
    SUR("Surtax","A tax or duty applied on and in addition to existing duties and taxes."),
    SWT("Shifted wage tax","Wage tax share of the invoice amount to be paid directly to the tax collector(s office)."),
    TAC("Alcohol mark tax","A tax levied based on the type of alcohol being obtained."),
    TOT("Total","The summary amount of all taxes."),
    TOX("Turnover tax","Tax levied on the total sales/turnover of a corporation."),
    TTA("Tonnage taxes","Tax levied based on the vessel's net tonnage."),
    VAD("Valuation deposit","Duty paid and held on deposit, by Customs, during an investigation period prior to a formal decision on valuation of the goods being made."),
    VAT("Value added tax","A tax on domestic or imported goods applied to the value added at each stage in the production/distribution cycle.");

    public final String code, name, description;

    TaxTypeCode(String aName, String aDescription) {
        this.code = name();
        this.name = aName;
        this.description = aDescription;
    }

    public static String getDefault() {
        return VAT.code;
    }
}
