plugins {
	id("java-library")
	id("idea")
}

version = mod.version

base {
	archivesName = mod.id
}

java {
	println("Java ${project.prop("java.version")}")
	toolchain.languageVersion = JavaLanguageVersion.of(project.prop("java.version")!!)
	// withSourcesJar()
	// withJavadocJar()
}

repositories {
	maven("https://libraries.minecraft.net") { name = "Mojang" }
	mavenCentral()
	exclusiveContent {
		forRepository {
			maven("https://repo.spongepowered.org/repository/maven-public") { name = "Sponge" }
		}
		filter { includeGroupAndSubgroups("org.spongepowered") }
	}
	exclusiveContent {
		forRepositories(
			maven("https://maven.parchmentmc.org") { name = "ParchmentMC" }
		)
		filter { includeGroup("org.parchmentmc.data") }
	}
	maven("https://maven.quiltmc.org/repository/release/") { name = "QuiltMC" }
	maven("https://maven.fabricmc.net/") { name = "FabricMC" }
	maven("https://maven.minecraftforge.net") { name = "MinecraftForge" }
}

tasks {
	processResources {
		val expandProps = mapOf(
			"java_version" to mod.propOrNull("java.version"),
			"version" to mod.version,
			"group" to mod.group,
			"mod_name" to mod.name,
			"mod_author" to mod.author,
			"mod_id" to mod.id,
			"license" to mod.license,
			"description" to mod.description,
			"credits" to mod.credits,
			"minecraft_version" to mod.propOrNull("minecraft_version"),
			"minecraft_version_range" to mod.propOrNull("minecraft_version_range"),
			"minecraftforge_version" to mod.propOrNull("minecraftforge_version"),
			"minecraftforge_version_range" to mod.propOrNull("minecraftforge_version_range"),
			"minecraftforge_eventbus_validator_version" to
				mod.propOrNull("minecraftforge_eventbus_validator_version"),
		).filterValues { it?.isNotEmpty() == true }.mapValues { (_, v) -> v!! }

		val jsonExpandProps = expandProps.mapValues { (_, v) -> v.replace("\n", "\\\\n") }

		filesMatching(listOf("META-INF/mods.toml")) {
			expand(expandProps)
		}

		filesMatching(listOf("pack.mcmeta", "*.mixins.json")) {
			expand(jsonExpandProps)
		}

		inputs.properties(expandProps)
	}
}
