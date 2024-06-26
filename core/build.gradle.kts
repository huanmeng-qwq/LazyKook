plugins {
    kotlin("jvm") version "2.0.0"
    id("io.ktor.plugin") version "2.3.12"
}

group = "com.huanmeng-qwq.lazykook"
version = "1.0.0"

repositories {
    mavenCentral()
    maven("https://jitpack.io")
}

application {
    mainClass = "unset"
}

sourceSets {
    main {
        kotlin.srcDirs("src/main/codegen")
    }
}

dependencies {
    testImplementation("org.jetbrains.kotlin:kotlin-test")
    api("com.fasterxml.jackson.module:jackson-module-kotlin:2.17.+")
    api("ch.qos.logback:logback-classic:1.5.6")

    api("io.ktor:ktor-server-core-jvm")
    api("io.ktor:ktor-server-netty-jvm")

    api("io.ktor:ktor-client-core-jvm")
    api("io.ktor:ktor-client-cio-jvm")
    api("io.ktor:ktor-client-websockets")

    implementation("org.bspfsystems:yamlconfiguration:2.0.2")
    api("com.huanmeng-qwq:event-core:1.0.4") {
        exclude(group = "com.google.guava")
    }
    api("com.google.guava:guava:33.2.1-jre")
}
val codegenTask = tasks.create("codegen") {
    group = "LazyKook"
    dependsOn(project(":code-gen").tasks.named("shadowJar"))
    doLast {
        val file = sourceSets.main.get().kotlin.srcDirs.last()
        val outputFile = project(":code-gen").tasks.named("shadowJar").get().outputs.files
        javaexec {
            classpath(outputFile.files)
            mainClass = "me.huanmeng.lazykook.codegen.Main"
            val destFile = file.resolve("me/huanmeng/lazykook/alive/type")
            destFile.mkdirs()
            args = arrayListOf(destFile.absolutePath)
        }
    }
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}