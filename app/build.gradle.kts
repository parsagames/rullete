plugins {
    id("com.android.application")
}

android {
    namespace = "com.example.myapp"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.myapp"
        minSdk = 23
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"
    }

    signingConfigs {
        create("release") {
            val storeFilePath =
                project.findProperty("RELEASE_STORE_FILE") as String?

            val storePasswordValue =
                project.findProperty("RELEASE_STORE_PASSWORD") as String?

            val keyAliasValue =
                project.findProperty("RELEASE_KEY_ALIAS") as String?

            val keyPasswordValue =
                project.findProperty("RELEASE_KEY_PASSWORD") as String?

            if (!storeFilePath.isNullOrBlank() &&
                !storePasswordValue.isNullOrBlank() &&
                !keyAliasValue.isNullOrBlank() &&
                !keyPasswordValue.isNullOrBlank()
            ) {
                storeFile = file(storeFilePath)
                storePassword = storePasswordValue
                keyAlias = keyAliasValue
                keyPassword = keyPasswordValue
            }
        }
    }

    buildTypes {
        release {
            signingConfig = signingConfigs.getByName("release")
            isMinifyEnabled = false
            isShrinkResources = false
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

dependencies {
    // The app uses Android's built-in WebView, so no external Kotlin/AndroidX
    // dependencies are required. This avoids duplicate Kotlin stdlib classes.
}
