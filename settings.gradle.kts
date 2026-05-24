pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        maven{url = uri("https://android-sdk.is.com/")}
        maven { url = uri("https://jitpack.io")}
        mavenCentral()
    }
}

rootProject.name = "Project_experiment_2025_present"
//include(":app")
include(":jetpack:Test")
include(":KotlinDSA:Test")
//include(":DSA:Test")
include(":Android:Experiment")
include(":Kotlin:Exprement")
include(":Java:DSAPratice")
