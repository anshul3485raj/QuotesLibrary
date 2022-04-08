
-optimizations !code/simplification/arithmetic
-keepattributes
-keepattributes InnerClasses
-keepattributes EnclosingMethod


-dontskipnonpubliclibraryclasses
-forceprocessing
-optimizationpasses 5
-keepclassmembers class mypackage.** { *; }



-dontwarn okhttp3.internal.platform.*
-dontwarn android.support.**
-dontwarn android.app.Notification
-dontwarn org.apache.log4j.**
-dontwarn com.google.common.**
-dontwarn okio.**
-dontwarn com.squareup.okhttp3.**
-keep class com.squareup.okhttp3.** { *; }
-keep interface com.squareup.okhttp3.** { *; }
-dontwarn javax.annotation.Nullable
-dontwarn javax.annotation.ParametersAreNonnullByDefault