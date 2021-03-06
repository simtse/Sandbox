plugins {
  id("com.android.application")
  kotlin("android")
}

android {
  compileSdk = 30
  buildToolsVersion = "30.0.3"

  defaultConfig {
    applicationId = "simon.sandbox"
    minSdk = 23
    targetSdk = 30
    versionCode = 1
    versionName = "1.0"

    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    vectorDrawables {
      useSupportLibrary = true
    }
  }

  buildTypes {
    release {
      isMinifyEnabled = false
      proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
    }
  }
  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
  }
  kotlinOptions {
    jvmTarget = "11"
    useIR = true
  }
  buildFeatures {
    compose = true
  }
  composeOptions {
    kotlinCompilerExtensionVersion = rootProject.extra["compose_version"] as String
    kotlinCompilerVersion = "1.4.32"
  }
}

dependencies {

  implementation("androidx.core:core-ktx:1.6.0")
  implementation("androidx.appcompat:appcompat:1.3.1")
  implementation("com.google.android.material:material:1.4.0")
  implementation("androidx.compose.material:material:${rootProject.extra["compose_version"]}")
  implementation("androidx.compose.material:material-icons-extended:${rootProject.extra["compose_version"]}")
  implementation("androidx.compose.ui:ui:${rootProject.extra["compose_version"]}")
  implementation("androidx.compose.ui:ui-tooling:${rootProject.extra["compose_version"]}")
  implementation("androidx.constraintlayout:constraintlayout-compose:1.0.0-beta02")
  implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.3.1")
  implementation("androidx.activity:activity-compose:1.3.1")
  implementation("io.coil-kt:coil-compose:1.3.0")
  testImplementation("junit:junit:4.13.2")
  androidTestImplementation("androidx.test.ext:junit:1.1.3")
  androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
  androidTestImplementation("androidx.compose.ui:ui-test-junit4:${rootProject.extra["compose_version"]}")
}