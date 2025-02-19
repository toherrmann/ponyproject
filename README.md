Pony Project
===================
Pony project is a Java project, which supports generation E-invoice/ Facture-X XML satisfying [ZUGFeRD](https://www.ferd-net.de/) specification. 
It provides JAXB binding classes generated with ZUGFeRD XSDs version 2.3.2. - currently only for so called "EN-16931"
standard, which should be enough for most cases in Germany.

___Hint___: The name ´Pony’ was chosen in reference to the [Mustang](https://github.com/ZUGFeRD/mustangproject) project, which does more complex things on other ways.

# Building
Building requires a Java JDK. The required Java version is found in the `zfbinding/build.gradle.kts` as the `Java.toolchain.languageVersion` property.


# Project Structure

- `zfbinding`: Contains the library module for creating XML documents.

# Installation

1. Clone the repository:
    ```sh
    git clone <repository-url>
    cd ponyproject
    ```

2. Build the project:
    ```sh
    ./gradlew build
    ```

# Usage

## XML Creation and Validation

The `zfbinding` module contains a JUnit test `ZFBindingTest` that demonstrates, how to use binding and helper classes.
```java
// ...
import un.unece.uncefact.data.standard.crossindustryinvoice._100.CrossIndustryInvoiceType;
// ...

void createFacturX() {
   CrossIndustryInvoiceType invoice = new CrossIndustryInvoiceType();
   // do your work and fill the stuff
   invoice.setExchangedDocumentContext(createDocumentContext());
   invoice.setExchangedDocument(createDocument());
   invoice.setSupplyChainTradeTransaction(createTransaction());
   String xml = createXml(invoice);
}

private String createXml(final CrossIndustryInvoiceType invoice) throws Exception {
    JAXBContext jbc = JAXBContext.newInstance(CrossIndustryInvoiceType.class);
    Marshaller marshaller = jbc.createMarshaller();
    marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
    marshaller.setProperty("org.glassfish.jaxb.namespacePrefixMapper", new DefaultNamespacePrefixMapper());

   JAXBElement<CrossIndustryInvoiceType> xmlRoot = new
           un.unece.uncefact.data.standard.crossindustryinvoice._100.ObjectFactory().createCrossIndustryInvoice(invoice);

   // Marshalling to String or whatever you want
   StringWriter sw = new StringWriter();
   marshaller.marshal(xmlRoot, sw);
   return sw.toString();
}
```

## Running Tests

To run the tests, use the following command:

```sh
./gradlew test
```

## Project Structure

- `src/main/java`: Contains the main source code files.
- `src/test/java`: Contains the test source code files.
- `src/main/schema`: Contains ZUGFeRD XSD schema files.

## License

This project is licensed under the [MIT License](https://opensource.org/license/MIT). For more information, see the `LICENSE` file.

## Authors

- Torsten Herrmann

