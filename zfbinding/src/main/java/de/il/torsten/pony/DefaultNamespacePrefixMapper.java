package de.il.torsten.pony;


import org.glassfish.jaxb.runtime.marshaller.NamespacePrefixMapper;

import java.util.HashMap;
import java.util.Map;

public class DefaultNamespacePrefixMapper extends NamespacePrefixMapper {

    private final Map<String, String> namespaceMap = new HashMap<>();

    public DefaultNamespacePrefixMapper() {
        namespaceMap.put("urn:un:unece:uncefact:data:standard:CrossIndustryInvoice:100", "rsm");
        namespaceMap.put("urn:un:unece:uncefact:data:standard:QualifiedDataType:100", "qdt");
        namespaceMap.put("urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100", "ram");
        namespaceMap.put("urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100", "udt");
        namespaceMap.put("http://www.w3.org/2001/XMLSchema", "xs");
    }

    @Override
    public String getPreferredPrefix(String namespaceUri, String suggestion, boolean requirePrefix) {
        return namespaceMap.getOrDefault(namespaceUri, suggestion);
    }
}
