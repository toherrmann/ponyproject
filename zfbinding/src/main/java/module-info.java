module de.il.torsten.zfbinding {
    requires jakarta.annotation;
    requires org.glassfish.jaxb.runtime;
    requires jakarta.xml.bind;

    exports de.il.torsten.pony;
    exports un.unece.uncefact.data.standard.crossindustryinvoice._100;
    exports un.unece.uncefact.data.standard.qualifieddatatype._100;
    exports un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100;
    exports un.unece.uncefact.data.standard.unqualifieddatatype._100;

    opens un.unece.uncefact.data.standard.crossindustryinvoice._100 to jakarta.xml.bind, org.glassfish.jaxb.runtime;
    opens un.unece.uncefact.data.standard.qualifieddatatype._100 to jakarta.xml.bind, org.glassfish.jaxb.runtime;
    opens un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100 to jakarta.xml.bind, org.glassfish.jaxb.runtime;
    opens un.unece.uncefact.data.standard.unqualifieddatatype._100 to jakarta.xml.bind, org.glassfish.jaxb.runtime;
}