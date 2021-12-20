import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.kotlin

fun DependencyHandler.base() = implementations(
    kotlin("stdlib")
)

fun DependencyHandler.androidX() {
    implementation("androidx.core:core-ktx:${Versions.ANDROID.COREKTX}")
    implementation("androidx.appcompat:appcompat:${Versions.ANDROID.APPCOMPAT}")
    implementation("com.google.android.material:material:${Versions.ANDROID.MATERIAL}")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:${Versions.ANDROID.RUNTIME}")
}

fun DependencyHandler.compose() {
    implementation("androidx.compose.ui:ui:${Versions.COMPOSE.VERSION}")
    implementation("androidx.compose.material:material:${Versions.COMPOSE.VERSION}")
    implementation("androidx.compose.ui:ui-tooling-preview:${Versions.COMPOSE.VERSION}")
    implementation("androidx.activity:activity-compose:${Versions.COMPOSE.ACTIVITY}")

    implementation("io.coil-kt:coil-compose:${Versions.COIL}")
    implementation("com.airbnb.android:lottie-compose:${Versions.LOTTIE}")

    implementation("com.google.accompanist:accompanist-pager:${Versions.PAGER.VERSION}")
    implementation("com.google.accompanist:accompanist-pager-indicators:${Versions.PAGER.VERSION}")
}

fun DependencyHandler.testing() {
    testImplementation("junit:junit:4.+")
    androidTestImplementation ("androidx.test.ext:junit:1.1.3")
    androidTestImplementation ("androidx.test.espresso:espresso-core:3.4.0")
    androidTestImplementation( "androidx.compose.ui:ui-test-junit4:${Versions.COMPOSE.VERSION}")
}

