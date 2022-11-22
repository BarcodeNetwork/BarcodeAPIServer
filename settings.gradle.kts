rootProject.name = "BarcodeAPIServer"

pluginManagement {
    val kotlinVersion: String by settings
    val ktorVersion: String by settings
    val kspVersion: String by settings
    val barcodeGradlePluginsVersion: String by settings

    plugins {
        kotlin("jvm") version kotlinVersion apply false
        kotlin("plugin.serialization") version kotlinVersion apply false
        id("io.ktor.plugin") version ktorVersion apply false
        id("com.google.devtools.ksp") version kspVersion apply false
        id("com.vjh0107.ksp-extension") version "1.0.2" apply false
    }

    repositories {
        gradlePluginPortal()
        maven("https://jitpack.io")
    }
}

includeBuild("plugins/project-manager")
includeBuild("build-logic")
include("server")