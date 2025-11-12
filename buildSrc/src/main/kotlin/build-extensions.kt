import org.gradle.api.Project
import org.gradle.kotlin.dsl.*

val Project.mod: ModData get() = ModData(this)
fun Project.prop(key: String): String? = findProperty(key)?.toString()

val Project.loader: String? get() = prop("loader")

@JvmInline
value class ModData(private val project: Project) {
	val id: String get() = modProp("id")
	val name: String get() = modProp("name")
	val version: String get() = modProp("version")
	val group: String get() = modProp("group")
	val author: String get() = modProp("author")
	val description: String get() = modProp("description")
	val license: String get() = modProp("license")
	val credits: String get() = modProp("credits")
	val minecraft_version: String get() = prop("minecraft_version")

	fun propOrNull(key: String) = project.prop(key)
	fun prop(key: String) = requireNotNull(propOrNull(key)) { "Missing '$key'" }
	fun modPropOrNull(key: String) = project.prop("mod.$key")
	fun modProp(key: String) = requireNotNull(modPropOrNull(key)) { "Missing 'mod.$key'" }
}