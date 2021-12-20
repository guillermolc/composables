buildscript{

    repositories {
        google()
        mavenCentral()
    }

    dependencies {
        classpath("com.android.tools.build:gradle:${Versions.GRADLE}")
        classpath(kotlin("gradle-plugin", version = Versions.KOTLIN))
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
