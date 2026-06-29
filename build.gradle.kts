plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    // Selenium - upgraded to 4.44.0 for Chrome 149 compatibility
    implementation("org.seleniumhq.selenium:selenium-java:4.44.0")

    // SLF4J implementation to suppress "Failed to load StaticLoggerBinder" warning
    implementation("org.slf4j:slf4j-simple:2.0.13")

    // TestNG
    testImplementation("org.testng:testng:7.9.0")
}

tasks.test {
    useTestNG {
        suites("src/test/resources/testng.xml")
    }
}