plugins {
    alias(libs.plugins.android.application)
    // alias(libs.plugins.hilt) // 暂时禁用Hilt
}

android {
    namespace = "com.bhcj.telling"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.bhcj.telling"
        minSdk = 29
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
    
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    
    
    buildFeatures {
        viewBinding = true
        dataBinding = true
    }
}

dependencies {
    // Core Android
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    
    // MVVM & Architecture
    implementation(libs.lifecycle.viewmodel)
    implementation(libs.lifecycle.livedata)
    implementation(libs.lifecycle.viewmodel.ktx)
    implementation(libs.lifecycle.livedata.ktx)
    implementation(libs.navigation.fragment)
    implementation(libs.navigation.ui)
    
    // Dependency Injection (暂时禁用)
    // implementation(libs.hilt.android)
    // annotationProcessor(libs.hilt.compiler)
    
    // Network - 完整依赖配置
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.squareup.okhttp3:okhttp:4.12.0")
    implementation("com.squareup.okhttp3:logging-interceptor:4.12.0")
    implementation("com.google.code.gson:gson:2.10.1")
    implementation("com.alibaba:fastjson:1.2.83")
    implementation("org.jbox2d:jbox2d:2.1.2.2")
    implementation("org.jbox2d:jbox2d-library:2.2.1.1")
    implementation("com.jawnnypoo:physicslayout:3.0.1")

    // 保留原有的libs引用作为备用
    implementation(libs.retrofit)
    implementation(libs.retrofit.gson)
    implementation(libs.okhttp)
    implementation(libs.okhttp.logging)
    implementation(libs.gson)
    
    // Reactive Programming
    implementation(libs.rxjava)
    implementation(libs.rxandroid)
    
    // Database
    implementation(libs.room.runtime)
    implementation(libs.room.rxjava)
    annotationProcessor(libs.room.compiler)
    
    // Image Loading
    implementation(libs.glide)
    
    // Utils
    implementation(libs.timber)
    
    // Testing
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}