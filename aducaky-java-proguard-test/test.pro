# Specify the entrypoint where ProGuard starts to determine what's reachable.
-keep class com.aducaky.api.proguard.** { *; }

# For the testing framework.
-keep class org.junit.** { *; }