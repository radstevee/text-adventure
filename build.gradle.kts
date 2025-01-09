plugins {
    kotlin("jvm") version "2.1.0"
    id("com.gradleup.shadow") version "9.0.0-beta4"
}

group = "net.radsteve.textadventure"
version = "0.0.0"

repositories {
    mavenCentral()
}

tasks {
    assemble {
        dependsOn(shadowJar)
    }
}
