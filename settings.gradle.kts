pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        jcenter()
        mavenCentral()
        maven("https://jitpack.io")
    }
}

rootProject.name = "HotelApp"
include(":app")
include(":hotel")
include(":apartments")
include(":reservation")
include(":payment")
include(":core-data")
include(":core-ui")
