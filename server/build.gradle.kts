plugins {
    id("barcodeapiserver.shared")
    id("com.vjh0107.ksp-extension")
    id("io.ktor.plugin")
    kotlin("plugin.serialization")
    application
}

group = "com.vjh0107.barcode"
version = "1.0.0"

application {
    mainClass.set("com.vjh0107.barcode.api.server.BarcodeAPIApplicationKt")
}

repositories {
    mavenCentral()
}

dependencies {
    implementationAll(Deps.Ktor.SERVER)
    implementation(Deps.Koin.KTOR)
    ksp(Deps.Koin.KSP_COMPILER)
    implementation(Deps.Library.Logger.LOGBACK_CLASSIC)
    implementation(Deps.Library.Logger.SLF4J_JDK14)
    implementation("com.vjh0107.barcode:barcodeframework-platform-ktor:1.0.1-beta2")

    testImplementation(Deps.KotlinX.Coroutines.TEST)
    testImplementation(Deps.Library.KOTLIN_TEST)
    testImplementation(Deps.Ktor.SERVER_TEST)
    testImplementation(Deps.Koin.TEST)
}