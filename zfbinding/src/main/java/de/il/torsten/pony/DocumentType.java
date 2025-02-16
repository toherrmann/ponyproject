package de.il.torsten.pony;

import un.unece.uncefact.data.standard.unqualifieddatatype._100.IDType;

public enum DocumentType {
    DT_71("Request for payment"),
    DT_80("Debit note related to goods or services"),
    DT_81("Credit note related to goods or services"),
    DT_82("Metered services invoice"),
    DT_83("Credit note related to financial adjustments"),
    DT_84("Debit note related to financial adjustments"),
    DT_102("Tax notification"),
    DT_130("Invoicing data sheet"),
    DT_202("Direct payment valuation"),
    DT_203("Provisional payment valuation"),
    DT_204("Payment valuation"),
    DT_211("Interim application for payment"),
    DT_218("Final payment request based on completion of work"),
    DT_219("Payment request for completed units"),
    DT_261("Self billed credit note"),
    DT_262("Consolidated credit note - goods and services"),
    DT_295("Price variation invoice"),
    DT_296("Credit note for price variation"),
    DT_308("Delcredere credit note"),
    DT_325("Proforma invoice"),
    DT_326("Partial invoice"),
    DT_331("Commercial invoice which includes a packing list"),
    DT_380("Commercial invoice"),
    DT_381("Credit note"),
    DT_382("Commission note"),
    DT_383("Debit note"),
    DT_384("Corrected invoice"),
    DT_385("Consolidated invoice"),
    DT_386("Prepayment invoice"),
    DT_387("Hire invoice"),
    DT_388("Tax invoice"),
    DT_389("Self-billed invoice"),
    DT_390("Delcredere invoice"),
    DT_393("Factored invoice"),
    DT_394("Lease invoice"),
    DT_395("Consignment invoice"),
    DT_396("Factored credit note"),
    DT_420("Optical Character Reading (OCR) payment credit note"),
    DT_456("Debit advice"),
    DT_457("Reversal of debit"),
    DT_458("Reversal of credit"),
    DT_527("Self billed debit note"),
    DT_532("Forwarder's credit note"),
    DT_553("Forwarder's invoice discrepancy report"),
    DT_575("Insurer's invoice"),
    DT_623("Forwarder's invoice"),
    DT_633("Port charges documents"),
    DT_751("Invoice information for accounting purposes"),
    DT_780("Freight invoice"),
    DT_817("Claim notification"),
    DT_870("Consular invoice"),
    DT_875("Partial construction invoice"),
    DT_876("Partial final construction invoice"),
    DT_877("Final construction invoice"),
    DT_935("Customs invoice");

    public final String code, description;

    DocumentType(String aName) {
        this.code = name().split("_")[1];
        this.description = aName;
    }
}
