Pony Project
===================
Pony project is a Java project, which supports generation e-invoice XML implementing [ZUGFeRD](https://www.ferd-net.de/) specification. 
It provides JAXB binding classes generated with ZUGFeRD XSDs version 2.3.2. - currently only for so called "EN-16931"
standard.

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

The `zfbinding` module contains a class `ZFBindingTest` that provides codes, how to use binding and helper classes.

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

