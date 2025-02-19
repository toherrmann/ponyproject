package de.il.torsten.zf.binding;

import de.il.torsten.pony.CodeValues;
import de.il.torsten.pony.DefaultNamespacePrefixMapper;
import de.il.torsten.pony.NodeHelper;
import jakarta.xml.bind.*;
import org.junit.jupiter.api.Test;
import un.unece.uncefact.data.standard.crossindustryinvoice._100.CrossIndustryInvoiceType;
import un.unece.uncefact.data.standard.qualifieddatatype._100.DocumentCodeType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.*;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.DateTimeType;

import javax.xml.XMLConstants;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.*;

class ZFBindingTest {

    private static DateTimeType createDateTime(String date) {
        DateTimeType dateTime = new DateTimeType();
        DateTimeType.DateTimeString dts = new DateTimeType.DateTimeString();
        dts.setFormat("102");
        dts.setValue(date);
        dateTime.setDateTimeString(dts);
        return dateTime;
    }

    @Test
    void createFacturX() throws Exception {
        CrossIndustryInvoiceType invoice = new CrossIndustryInvoiceType();
        invoice.setExchangedDocumentContext(createDocumentContext());
        invoice.setExchangedDocument(createDocument());
        invoice.setSupplyChainTradeTransaction(createTransaction());
        String xml = createXml(invoice);
        assertNotNull(xml);
        assertFalse(xml.isEmpty());
    }

    private ExchangedDocumentContextType createDocumentContext() {
        ExchangedDocumentContextType docContext = new ExchangedDocumentContextType();
        DocumentContextParameterType urnIdentificator = new DocumentContextParameterType();
        urnIdentificator.setID(NodeHelper.createIDType(CodeValues.URN_IDENTIFICATOR_16931_2017));
        docContext.setGuidelineSpecifiedDocumentContextParameter(urnIdentificator);
        return docContext;
    }

    private ExchangedDocumentType createDocument() {
        ExchangedDocumentType doc = new ExchangedDocumentType();
        doc.setID(NodeHelper.createIDType("471102"));
        DocumentCodeType typeCode = new DocumentCodeType();
        typeCode.setValue("380");
        doc.setTypeCode(typeCode);
        doc.setIssueDateTime(createDateTime("20241115"));
        doc.getIncludedNote().add(createNoteWithSubject("Rechnung gemäß Bestellung vom 01.11.2018.", null));
        doc.getIncludedNote().add(createNoteWithSubject("Lieferant GmbH\nLieferantenstraße 20\n80333 München\nDeutschland\nGeschäftsführer: Hans Muster\nHandelsregisternummer: H A 123", "REG"));
        return doc;
    }

    private NoteType createNoteWithSubject(String content, String subjectCode) {
        NoteType note = new NoteType();
        note.setContent(NodeHelper.createTextType(content));
        note.setSubjectCode(subjectCode == null ? null : NodeHelper.getCodeType(subjectCode));
        return note;
    }

    private SupplyChainTradeTransactionType createTransaction() {
        SupplyChainTradeTransactionType transaction = new SupplyChainTradeTransactionType();
        transaction.getIncludedSupplyChainTradeLineItem().add(createLineItem("1", "4012345001235", "TB100A4", "Trennblätter A4",
                new BigDecimal("20.0000"), "H87", new BigDecimal("9.9000"), new BigDecimal("198.00"), new BigDecimal("19.00")));
        transaction.getIncludedSupplyChainTradeLineItem().add(createLineItem("2", "4000050986428", "ARNR2", "Joghurt Banane",
                new BigDecimal("50.0000"), "H87", new BigDecimal("5.5000"), new BigDecimal("275.00"), new BigDecimal("7.00")));
        transaction.setApplicableHeaderTradeAgreement(createHeaderTradeAgreement());
        transaction.setApplicableHeaderTradeDelivery(createHeaderTradeDelivery());
        transaction.setApplicableHeaderTradeSettlement(createHeaderTradeSettlement());
        return transaction;
    }

    private HeaderTradeAgreementType createHeaderTradeAgreement() {
        HeaderTradeAgreementType agreement = new HeaderTradeAgreementType();
        TradePartyType seller = new TradePartyType();
        seller.getID().add(NodeHelper.createIDType("549910"));
        seller.getGlobalID().add(NodeHelper.createIDType("4000001123452", "0088"));
        seller.setName(NodeHelper.createTextType("Lieferant GmbH"));
        seller.setPostalTradeAddress(createAddress("80333", "Lieferantenstraße 20", "München", "DE"));
        seller.getSpecifiedTaxRegistration().add(createTaxRegistration("FC", "201/113/40209"));
        seller.getSpecifiedTaxRegistration().add(createTaxRegistration("VA", "DE123456789"));
        agreement.setSellerTradeParty(seller);

        TradePartyType buyer = new TradePartyType();
        buyer.getID().add(NodeHelper.createIDType("GE2020211"));
        buyer.setName(NodeHelper.createTextType("Kunden AG Mitte"));
        buyer.setPostalTradeAddress(createAddress("69876", "Kundenstraße 15", "Frankfurt", "DE"));
        agreement.setBuyerTradeParty(buyer);

        return agreement;
    }

    private TradeAddressType createAddress(String postcode, String lineOne, String city, String country) {
        TradeAddressType address = new TradeAddressType();
        address.setPostcodeCode(NodeHelper.getCodeType(postcode));
        address.setLineOne(NodeHelper.createTextType(lineOne));
        address.setCityName(NodeHelper.createTextType(city));
        address.setCountryID(NodeHelper.getCountryIDType(country));
        return address;
    }

    private TaxRegistrationType createTaxRegistration(String schemeID, String id) {
        TaxRegistrationType taxRegistration = new TaxRegistrationType();
        taxRegistration.setID(NodeHelper.createIDType(id, schemeID));
        return taxRegistration;
    }

    private HeaderTradeDeliveryType createHeaderTradeDelivery() {
        HeaderTradeDeliveryType delivery = new HeaderTradeDeliveryType();
        SupplyChainEventType event = new SupplyChainEventType();
        event.setOccurrenceDateTime(createDateTime("20241114"));
        delivery.setActualDeliverySupplyChainEvent(event);
        return delivery;
    }

    private HeaderTradeSettlementType createHeaderTradeSettlement() {
        HeaderTradeSettlementType settlement = new HeaderTradeSettlementType();
        settlement.setInvoiceCurrencyCode(NodeHelper.getCurrencyCodeType("EUR"));
        settlement.getApplicableTradeTax().add(createTradeTax(new BigDecimal("19.25"), "VAT", new BigDecimal("275.00"), "S", new BigDecimal("7.00")));
        settlement.getApplicableTradeTax().add(createTradeTax(new BigDecimal("37.62"), "VAT", new BigDecimal("198.00"), "S", new BigDecimal("19.00")));
        settlement.setSpecifiedTradePaymentTerms(createPaymentTerms("20241215"));
        settlement.setSpecifiedTradeSettlementHeaderMonetarySummation(createMonetarySummation(new BigDecimal("473.00"), new BigDecimal("0.00"), new BigDecimal("0.00"), new BigDecimal("473.00"), new BigDecimal("56.87"), new BigDecimal("529.87"), new BigDecimal("0.00"), new BigDecimal("529.87")));
        return settlement;
    }

    private TradeTaxType createTradeTax(BigDecimal calculatedAmount, String typeCode, BigDecimal basisAmount, String categoryCode, BigDecimal rate) {
        TradeTaxType tax = new TradeTaxType();
        tax.setCalculatedAmount(NodeHelper.createAmountType(calculatedAmount));
        tax.setTypeCode(NodeHelper.getTaxCodeType(typeCode));
        tax.setBasisAmount(NodeHelper.createAmountType(basisAmount));
        tax.setCategoryCode(NodeHelper.getTaxCategoryCodeType(categoryCode));
        tax.setRateApplicablePercent(NodeHelper.getPercentType(rate));
        return tax;
    }

    private TradePaymentTermsType createPaymentTerms(String dueDate) {
        TradePaymentTermsType terms = new TradePaymentTermsType();
        terms.setDueDateDateTime(createDateTime(dueDate));
        return terms;
    }

    private TradeSettlementHeaderMonetarySummationType createMonetarySummation(BigDecimal lineTotal, BigDecimal chargeTotal, BigDecimal allowanceTotal, BigDecimal taxBasisTotal, BigDecimal taxTotal, BigDecimal grandTotal, BigDecimal totalPrepaid, BigDecimal duePayable) {
        TradeSettlementHeaderMonetarySummationType summation = new TradeSettlementHeaderMonetarySummationType();
        summation.setLineTotalAmount(NodeHelper.createAmountType(lineTotal));
        summation.setChargeTotalAmount(NodeHelper.createAmountType(chargeTotal));
        summation.setAllowanceTotalAmount(NodeHelper.createAmountType(allowanceTotal));
        summation.setTaxBasisTotalAmount(NodeHelper.createAmountType(taxBasisTotal));
        summation.getTaxTotalAmount().add(NodeHelper.createAmountType(taxTotal, "EUR"));
        summation.setGrandTotalAmount(NodeHelper.createAmountType(grandTotal));
        summation.setTotalPrepaidAmount(NodeHelper.createAmountType(totalPrepaid));
        summation.setDuePayableAmount(NodeHelper.createAmountType(duePayable));
        return summation;
    }

    private SupplyChainTradeLineItemType createLineItem(String lineID, String globalID, String sellerID, String name, BigDecimal quantity,
                                                        String unitCode, BigDecimal price, BigDecimal lineTotal, BigDecimal taxRate) {
        SupplyChainTradeLineItemType lineItem = new SupplyChainTradeLineItemType();
        lineItem.setAssociatedDocumentLineDocument(createDocumentLineDocument(lineID));
        lineItem.setSpecifiedTradeProduct(createTradeProduct(globalID, sellerID, name));
        lineItem.setSpecifiedLineTradeAgreement(createLineTradeAgreement(price, taxRate));
        lineItem.setSpecifiedLineTradeDelivery(createLineTradeDelivery(quantity, unitCode));
        lineItem.setSpecifiedLineTradeSettlement(createLineTradeSettlement(lineTotal, taxRate));
        return lineItem;
    }

    private DocumentLineDocumentType createDocumentLineDocument(String lineID) {
        DocumentLineDocumentType document = new DocumentLineDocumentType();
        document.setLineID(NodeHelper.createIDType(lineID));
        return document;
    }

    private TradeProductType createTradeProduct(String globalID, String sellerID, String name) {
        TradeProductType product = new TradeProductType();
        product.setGlobalID(NodeHelper.createIDType(globalID, "0160"));
        product.setSellerAssignedID(NodeHelper.createIDType(sellerID));
        product.setName(NodeHelper.createTextType(name));
        return product;
    }

    private LineTradeAgreementType createLineTradeAgreement(BigDecimal price, BigDecimal taxRate) {
        LineTradeAgreementType agreement = new LineTradeAgreementType();
        BigDecimal grossPrice = price.multiply(taxRate.divide(new BigDecimal("100"), RoundingMode.HALF_UP).add(BigDecimal.ONE)).setScale(4, RoundingMode.HALF_UP);
        agreement.setGrossPriceProductTradePrice(NodeHelper.createTradePriceType(grossPrice));
        agreement.setNetPriceProductTradePrice(NodeHelper.createTradePriceType(price));
        return agreement;
    }

    private LineTradeDeliveryType createLineTradeDelivery(BigDecimal quantity, String unitCode) {
        LineTradeDeliveryType delivery = new LineTradeDeliveryType();
        delivery.setBilledQuantity(NodeHelper.createQuantityType(quantity, unitCode));
        return delivery;
    }

    private LineTradeSettlementType createLineTradeSettlement(BigDecimal lineTotal, BigDecimal taxRate) {
        LineTradeSettlementType settlement = new LineTradeSettlementType();
        TradeTaxType tax = new TradeTaxType();
        tax.setTypeCode(NodeHelper.getTaxCodeType("VAT"));
        tax.setCategoryCode(NodeHelper.getTaxCategoryCodeType("S"));
        tax.setRateApplicablePercent(NodeHelper.getPercentType(taxRate));
        settlement.setApplicableTradeTax(tax);
        TradeSettlementLineMonetarySummationType summation = new TradeSettlementLineMonetarySummationType();
        summation.setLineTotalAmount(NodeHelper.createAmountType(lineTotal));
        settlement.setSpecifiedTradeSettlementLineMonetarySummation(summation);
        return settlement;
    }

    private String createXml(final CrossIndustryInvoiceType invoice) throws Exception {
        JAXBContext jbc = JAXBContext.newInstance(CrossIndustryInvoiceType.class);
        Marshaller marshaller = jbc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.setProperty("org.glassfish.jaxb.namespacePrefixMapper", new DefaultNamespacePrefixMapper());

        // Schema für die Validierung laden
        SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Schema schema = sf.newSchema(new File("src/main/schema/Factur-X_1.07.2_EN16931.xsd"));
        marshaller.setSchema(schema);

        // Validierungs-Event-Handler hinzufügen
        marshaller.setEventHandler(event -> {
            if (event.getSeverity() != ValidationEvent.WARNING) {
                ValidationEventLocator locator = event.getLocator();
                System.out.println("Invalid XML: " + event.getMessage());
                System.out.println("At line number: " + locator.getLineNumber());
                System.out.println("At column number: " + locator.getColumnNumber());
            }
            return true;
        });

        JAXBElement<CrossIndustryInvoiceType> xmlRoot = new
                un.unece.uncefact.data.standard.crossindustryinvoice._100.ObjectFactory().createCrossIndustryInvoice(invoice);
        System.out.println("Here follows XML structure:");
        //marshaller.marshal(xmlRoot, System.out);

        // Marshalling to String
        StringWriter sw = new StringWriter();
        marshaller.marshal(xmlRoot, sw);
        return sw.toString();

    }
}