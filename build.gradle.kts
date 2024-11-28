plugins {
    kotlin("jvm") version "2.0.20"
    id("com.gradleup.shadow") version "8.3.1"
    application
}

group = "net.radstevee.textadventure"
version = "0.0.0"

repositories {
    mavenCentral()
}

tasks.assemble {
    dependsOn("shadowJar")
}

kotlin {
    jvmToolchain(21)
}

application {
    mainClass.set("net.radstevee.textadventure.MainKt")
}