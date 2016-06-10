#include <jni.h>
#include <stdio.h>

jstring Java_com_example_phoenix_ejemplondk_MainActivity_fibboJni(JNIEnv *env, jobject instance) {
    char text[10];

    sprintf(text, "%d", fibonacciC(33));

   return (*env)->NewStringUTF(env, text );
}

int fibonacciC(int n){
    if(n<2){
        return n;
    }else{
        return (fibonacciC(n-2)+fibonacciC(n-1));
    }
}