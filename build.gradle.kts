import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    alias(libs.plugins.shadow)
    alias(libs.plugins.kotlin)
}

group = "de.dayeeet.plugin"
version = "1.0.0"

repositories {
    mavenCentral()
    mavenLocal()
    maven("https://repo.papermc.io/repository/maven-public/")
}

dependencies {
    testImplementation(rootProject.libs.kotlinTest)
    implementation(rootProject.libs.kotlinJvm)
    compileOnly(libs.paper)
}

kotlin {
    jvmToolchain(21)
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "17"
}

tasks.named("shadowJar", ShadowJar::class) {
    mergeServiceFiles()
    archiveFileName.set("${project.name}.jar")
}

tasks.test {
    useJUnitPlatform()
}

repositories {
    maven("https://repo.papermc.io/repository/maven-public/")
}


