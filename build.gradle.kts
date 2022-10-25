plugins {
    kotlin("jvm") version "1.6.21"

    // For build.gradle (Groovy DSL)
//    id "org.jetbrains.kotlin.jvm" version "1.6.21"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")

    implementation("org.springframework:spring-context:5.3.23")
    implementation("org.springframework.data:spring-data-redis:2.7.5")
    implementation("io.lettuce:lettuce-core:6.2.1.RELEASE")
}
//
//packagingOptions {
//    resources.excludes += "DebugProbesKt.bin"
//}

tasks.test {
    useJUnitPlatform()
}