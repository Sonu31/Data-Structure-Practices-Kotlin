#include <jni.h>
#include <string>

extern "C"
JNIEXPORT jstring JNICALL


Java_com_android_experiment_NativeLib_getHello(JNIEnv *env, jobject /* this */) {
    return env->NewStringUTF("Hello from Native!");
}