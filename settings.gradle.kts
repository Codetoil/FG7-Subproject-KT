pluginManagement {
	repositories {
		gradlePluginPortal()
		mavenCentral()
		maven("https://maven.minecraftforge.net") { name = "MinecraftForge" }
	}
}

plugins {
	id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
	id("net.minecraftforge.accesstransformers") version "5.0.1" apply false
	id("net.minecraftforge.gradle") version "7.0.0-beta.46" apply false
	id("net.minecraftforge.jarjar") version "0.2.3" apply false
}

include(":minecraftforge")

rootProject.name = "FG7-Subproject-KT"

