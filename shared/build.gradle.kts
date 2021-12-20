plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
    id("maven-publish")
}

android {

    compileSdk = AppVersion.targetSdk

    defaultConfig {
        minSdk = AppVersion.minSdk
        targetSdk = AppVersion.targetSdk
        testInstrumentationRunner = AppVersion.androidTestInstrumentation
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Versions.COMPOSE.VERSION
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = "11"
    }

    packagingOptions {
        resources.pickFirsts += "META-INF/AL2.0"
        resources.pickFirsts += "META-INF/LGPL2.1"
    }
}

dependencies {

    base()
    androidX()
    compose()
    testing()

}

afterEvaluate {
    publishing {
        publications {
            create<MavenPublication>("release") {
                from(components["release"])
                groupId = "guillermo.lagos.composables.shared"
                artifactId = "Composables"
                version = "1.0.0"
            }
        }
    }
}