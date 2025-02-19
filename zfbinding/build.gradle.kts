plugins {
    // Apply the java-library plugin for API and implementation separation.
    `java-library`
    id("io.freefair.lombok") version "8.12.1"
    id("com.github.ben-manes.versions") version "0.52.0"
    id("com.github.bjornvester.xjc") version "1.8.2"
    id("maven-publish")
}

repositories {
    mavenCentral()
}

dependencies {
    //implementation(libs.guava)

    implementation("jakarta.xml.bind:jakarta.xml.bind-api:4.0.2")
    implementation("org.glassfish.jaxb:jaxb-runtime:4.0.5")

    // Testing
    testImplementation(libs.junit.api)
    testRuntimeOnly(libs.junit.engine)
    testImplementation(libs.junit.launcher)
}

xjc {
    xjcVersion.set("4.0.2")
    xsdDir.set(file("$projectDir/src/main/schema"))
    markGenerated.set(true)
}

tasks.named<Test>("test") {
    useJUnitPlatform()
}
// Apply a specific Java toolchain to ease working on different environments.
java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(23)
    }
}

group = "de.il.torsten"
version = "2.3.2"

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            from(components["java"])
        }
    }
    repositories {
        maven {
            name = "local"
            url = uri("file://${System.getProperty("user.home")}/.m2/repository")
        }
    }
}
