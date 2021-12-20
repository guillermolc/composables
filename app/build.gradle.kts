plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("maven-publish")
}

android {

    compileSdk = AppVersion.targetSdk

    defaultConfig {
        minSdk = AppVersion.minSdk
        targetSdk = AppVersion.targetSdk
        applicationId = AppVersion.appId
        versionCode = AppVersion.versionCode
        versionName = AppVersion.versionName
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

    implementation(project(":shared"))

    base()
    androidX()
    compose()



    testing()
}
