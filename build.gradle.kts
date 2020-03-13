import org.jetbrains.kotlin.gradle.dsl.KotlinJsCompile

plugins {
    kotlin("multiplatform") version Versions.org_jetbrains_kotlin_multiplatform_gradle_plugin
    id("de.fayard.buildSrcVersions") version Versions.de_fayard_buildsrcversions_gradle_plugin
}

repositories {
    mavenCentral()
    maven("https://dl.bintray.com/kotlin/dokka")
    maven("https://jitpack.io")
}

group = "demo"
version = "0.1.0"

val kotlinNativeDataPath = System.getenv("KONAN_DATA_DIR")?.let { File(it) }
    ?: File(System.getProperty("user.home")).resolve(".konan")
val mingw64Path = File(System.getenv("MINGW64_DIR") ?: "C:/msys64/mingw64")
val mingw32Path = File(System.getenv("MINGW32_DIR") ?: "C:/msys64/mingw32")

kotlin {

//    val hostOs = System.getProperty("os.name")
//    if (hostOs == "Mac OS X") {
//        macosX64()
//    }
//    if (hostOs == "Linux") {
//        linuxX64()
//    }
//    if (hostOs.startsWith("Windows")) {
//        mingwX64()
//        mingwX86()
//    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(kotlin("stdlib-common"))
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
            }
        }

        jvm {
            compilations["main"].defaultSourceSet {
                dependencies {
                    implementation(kotlin("stdlib-jdk8"))
                }
            }

            compilations["test"].defaultSourceSet {
                dependencies {
                    implementation(kotlin("test-junit"))
                }
            }
        }

        js {
            nodejs()

            sequenceOf("", "Test").forEach {
                tasks.getByName<KotlinJsCompile>("compile${it}KotlinJs") {
                    kotlinOptions {
                        moduleKind = "umd"
                        noStdlib = true
                        metaInfo = true
                    }
                }
            }
            compilations["main"].defaultSourceSet {
                dependencies {
                    implementation(kotlin("stdlib-js"))
                }
            }
            compilations["test"].defaultSourceSet {
                dependencies {
                    implementation(kotlin("test-js"))
                }
            }
        }

        targets.withType<org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget> {
            binaries {
                sharedLib {
                    baseName = "KtMath"
                    linkerOpts("-L/usr/lib64", "-L/usr/lib/x86_64-linux-gnu", "-lSDL2")
                }
            }

        }
    }
}

