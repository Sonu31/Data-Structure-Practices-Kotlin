- What are the two ways to get data from a native library in Android?
   a. By using JNI (Java Native Interface) with native C/C++ code (.cpp file).
   b.By using a prebuilt .so (shared object) library file directly.

-----------
## 1 way
1.How to  Native Library using Code
   Using full native code (C++ + JNI bridge) 
   — yaha hum .cpp file likhte hain aur JNI (Java Native Interface) ke zariye function ko call karte hain.

  Step 1 :- Download NdK Version (27.0.12077973) & Cmake (3.31.6)

  Step 2:- Create the package these path (D:\Technology\Android\Project_experiment_2025_present\app\src\main)
``` 
 app/
  ├── src/
  │   ├── main/
  │   │   ├── cpp/              ✅ (Yahi pe C++ files aayengi)
  │   │   │    ├── native-lib.cpp
  │   │   │    │── CMackeLists.txt
  │   │   ├── java/
  │   │   ├── AndroidManifest.xml
  │   │   ├── res/
```

### 📄 CMakeLists.txt

Below is the content of the `CMakeLists.txt` file used to build the native C++ library:

```cmake
cmake_minimum_required(VERSION 3.10.2)
project("app")

# Creates a native library
add_library(native-lib SHARED native-lib.cpp)

# Searches for the log library
find_library(log-lib log)

# Links native library with log library
target_link_libraries(native-lib ${log-lib})
```

### 🧩 Native C++ Code (`native-lib.cpp`)

Below is the C++ code used for creating a simple JNI function that returns a string from the native layer:

```cpp
#include <jni.h>
#include <string>

extern "C"
JNIEXPORT jstring JNICALL
Java_com_android_experiment_NativeLib_getHello(JNIEnv *env, jobject /* this */) {
    return env->NewStringUTF("Hello from Native!");
}
```

### ⚙️ Gradle Configuration for Native (C++) Integration

Below is the configuration you need to add inside your **`app/build.gradle`** file
to enable native (C++) build using CMake and NDK.

```gradle
android {
    // Specify the NDK version (must be installed in your Android SDK)
    ndkVersion = "27.0.12077973"

    defaultConfig {
        ...

        // Native build configuration
        externalNativeBuild {
            cmake {
                // Use shared C++ standard library
                arguments.add("-DANDROID_STL=c++_shared")
            }
        }

        // Specify which ABIs (CPU architectures) to build for
        ndk {
            abiFilters.addAll(listOf("armeabi-v7a", "arm64-v8a"))
        }
    }

    // Configure CMake build script path and version
    externalNativeBuild {
        cmake {
            path = file("src/main/cpp/CMakeLists.txt")
            version = "3.31.6"
        }
    }

    // Ensures JNI libraries are packaged correctly
    packagingOptions {
        jniLibs {
            useLegacyPackaging = true
        }
    }
}
```
### 💻 Kotlin Code for Native Library Integration (`NativeLib.kt`)

Below is the Kotlin class used to connect your Android app with the native C++ library using JNI.

```kotlin
package com.android.experiment.nativeLibImp

class NativeLib {

    // Declares the native function implemented in C++
    external fun getHello(): String

    companion object {
        // Loads the native library (.so file) at runtime
        init {
            System.loadLibrary("native-lib")
        }
    }
}
```
### 🚀 Calling Native Function from Any Screen

Once your native library is properly set up,  
you can call the JNI function from any Activity or Fragment in your Android app.

Example usage inside an **Activity**:


```kotlin
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.android.experiment.nativeLibImp.NativeLib

class WelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        val lib = NativeLib()
        Log.i("Welcome Screen", "onCreate: ${lib.getHello()}")
    }
}

```


## 2 way
 Using prebuilt native library (.so file) 
— yaha hum sirf .so (shared object) file ko project me integrate karte hain aur uske native functions ko directly call karte hain, bina .cpp likhe.

Step 1 :- Download NdK Version (27.0.12077973) & Cmake (3.31.6)

Step 2:- Create the package these path (D:\Technology\Android\Project_experiment_2025_present\app\src\main)
```
app/
├── src/
│   ├── main/
│   │   ├── jniLibs────────────────│    
│   │   │                          ├── arm64-v8a───────────│──libc++_shared.so
│   │   │                          │                       │──libnative-lib.so
│   │   ├── java/                  │── armeabi-v7a─────│──libc++_shared.so
│   │   ├── AndroidManifest.xml                        │──libnative-lib.so
│   │   ├── res/

```

This path get File :-libc++_shared.so
D:\Prashansa Technologies\IndiaTalk_App\app\build\intermediates\merged_native_libs\fcmDebug\mergeFcmDebugNativeLibs\out\lib\arm64-v8a

### ⚙️ Gradle Configuration for Native (C++) Integration

Below is the configuration you need to add inside your **`app/build.gradle`** file
to enable native (C++) build using CMake and NDK.

```gradle
android {
    // Specify the NDK version (must be installed in your Android SDK)
    ndkVersion = "27.0.12077973"

    defaultConfig {
        ...


        // Specify which ABIs (CPU architectures) to build for
        ndk {
            abiFilters.addAll(listOf("armeabi-v7a", "arm64-v8a"))
        }
    }

    // Ensures JNI libraries are packaged correctly
    packagingOptions {
        jniLibs {
            useLegacyPackaging = true
        }
    }
}
```
### 💻 Kotlin Code for Native Library Integration (`NativeLib.kt`)

Below is the Kotlin class used to connect your Android app with the native C++ library using JNI.

```kotlin
package com.android.experiment.nativeLibImp

class NativeLib {

    // Declares the native function implemented in C++
    external fun getHello(): String

    companion object {
        // Loads the native library (.so file) at runtime
        init {
            System.loadLibrary("native-lib")
        }
    }
}
```
### 🚀 Calling Native Function from Any Screen

Once your native library is properly set up,  
you can call the JNI function from any Activity or Fragment in your Android app.

Example usage inside an **Activity**:


```kotlin
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.android.experiment.nativeLibImp.NativeLib

class WelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        val lib = NativeLib()
        Log.i("Welcome Screen", "onCreate: ${lib.getHello()}")
    }
}

```

## Completed 
