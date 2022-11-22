import org.jetbrains.kotlin.konan.properties.loadProperties

plugins {
    `kotlin-dsl`
}

val properties = loadProperties(rootProject.gradle.parent?.rootProject?.projectDir?.path + "/gradle.properties")
val kotlinVersion = properties.getProperty("kotlinVersion")

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
}