plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    id("com.google.gms.google-services")
}

android {
    namespace = "com.android.experiment"
    compileSdk = 35
    ndkVersion = "27.0.12077973"


    defaultConfig {
        applicationId = "com.android.experiment"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

//        externalNativeBuild {
//            cmake {
//                arguments.add("-DANDROID_STL=c++_shared")
//            }
//        }

        ndk {
            abiFilters.addAll(listOf("armeabi-v7a", "arm64-v8a"))
        }


    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

//    externalNativeBuild {
//        cmake {
//            path = file("src/main/cpp/CMakeLists.txt")
//            version = "3.31.6"
//        }
//    }

    packagingOptions {
        jniLibs {
            useLegacyPackaging = true
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

  /* sdp-ssp */
   implementation ("com.intuit.sdp:sdp-android:1.1.0")
   implementation ("com.intuit.ssp:ssp-android:1.1.0")

       /* Ratrofit */
       implementation ("com.squareup.retrofit2:retrofit:2.9.0")
       implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
       implementation ("com.squareup.retrofit2:converter-scalars:2.9.0")

        /*coroutines*/
        implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.1")
        implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.1")


     // ViewModel
         implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.7.0")
         implementation ("androidx.fragment:fragment-ktx:1.6.2")
         implementation ("androidx.activity:activity-ktx:1.8.0")

    implementation  ("io.agora.rtc:full-sdk:4.5.2")
    implementation("commons-codec:commons-codec:1.9")

//    implementation ("io.agora:authentication:1.5.3")

    implementation(platform("com.google.firebase:firebase-bom:34.9.0"))
    implementation("com.google.firebase:firebase-analytics")
    implementation("com.google.firebase:firebase-messaging:24.0.0")
//    implementation platform("com.google.firebase:firebase-bom:33.1.2")
    implementation ("com.google.firebase:firebase-database")
    implementation ("com.google.firebase:firebase-messaging")
}