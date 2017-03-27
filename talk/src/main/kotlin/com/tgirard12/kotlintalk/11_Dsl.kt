package com.tgirard12.kotlintalk


@DslMarker
annotation class AndroidDslMarker

val dslResult = """
android {
    compileSdkVersion 25
    buildToolsVersion "25.0.3"
    defaultConfig {
        applicationId "com.tgirard12.kotlintalk"
        minSdkVersion 25
        targetSdkVersion 19
        versionCode 1
        versionName "1-snapshot"
        testInstrumentationRunner null
    }
    signingConfigs {
       debug {
            storeFile "debug.keystore"
            storePassword ""
            keyAlias ""
            keyPassword ""
       }
       release {
            storeFile "release.keystore"
            storePassword "password"
            keyAlias "alias"
            keyPassword "password"
       }
       test {
            storeFile "test.keystore"
            storePassword ""
            keyAlias ""
            keyPassword ""
       }
    }
}"""


typealias SigningConfigs = ArrayList<SigningConfig>

@AndroidDslMarker
class Android {
    var compileSdkVersion: Int = -1
    var buildToolsVersion: String = ""
    var defaultConfig: DefaultConfiguration? = null
    var signingConfigsList = SigningConfigs()

    override fun toString(): String = """
android {
    compileSdkVersion $compileSdkVersion
    buildToolsVersion "$buildToolsVersion"
    $defaultConfig
    signingConfigs {
${signingConfigsList.joinToString(separator = "\n", prefix = "", postfix = "")}
    }
}
"""
}

@AndroidDslMarker
class DefaultConfiguration {
    var applicationId: String = ""
    var minSdkVersion: Int = -1
    var targetSdkVersion: Int = -1
    var versionCode: Int = -1
    var versionName: String? = null
    var testInstrumentationRunner: String? = null

    override fun toString(): String = """defaultConfig {
        applicationId "$applicationId"
        minSdkVersion $minSdkVersion
        targetSdkVersion $targetSdkVersion
        versionCode $versionCode
        versionName "$versionName"
        testInstrumentationRunner $testInstrumentationRunner
    }"""
}

class SigningConfig(val name: String) {
    var storeFile: String = "~/.android/debug.keystore"
    var storePassword: String = ""
    var keyAlias: String = ""
    var keyPassword: String = ""

    override fun toString(): String = """       $name {
            storeFile "$storeFile"
            storePassword "$storePassword"
            keyAlias "$keyAlias"
            keyPassword "$keyPassword"
       }"""
}


fun main(args: Array<String>) {

    //val android =


    //println(android)


    /*
https://github.com/gradle/gradle-script-kotlin/blob/master/samples/hello-android/build.gradle.kts
    */
}


fun android(f: Android.() -> Unit): Android = Android().apply(f)


fun Android.defaultConfig(f: DefaultConfiguration.() -> Unit) {
    defaultConfig = DefaultConfiguration().apply(f)
}


fun Android.signingConfigs(f: SigningConfigs.() -> Unit) = f(signingConfigsList)


fun SigningConfigs.signingConfig(name: String, f: SigningConfig.() -> Unit) {
    val signingConfig = SigningConfig(name).apply(f)
    this.add(signingConfig)
}


fun SigningConfigs.debug(f: SigningConfig.() -> Unit) = signingConfig("debug", f)
fun SigningConfigs.release(f: SigningConfig.() -> Unit) = signingConfig("release", f)
