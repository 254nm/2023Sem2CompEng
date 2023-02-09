group = "me.txmc"
version = "1.0-SNAPSHOT"
description = "School project"
java.sourceCompatibility = JavaVersion.VERSION_11

plugins {
    `java-library`
}

repositories {
    mavenLocal()
    mavenCentral()
    maven { url = uri("https://repo.txmc.me/releases") }
}

dependencies {
    compileOnly("org.projectlombok:lombok:1.18.24")
    annotationProcessor("org.projectlombok:lombok:1.18.24")
}
tasks.jar {
    manifest {
        attributes(
            "Main-Class" to "me.txmc.school.Main"
        )
    }
}


tasks.withType<JavaCompile>() {
    options.encoding = "UTF-8"
}