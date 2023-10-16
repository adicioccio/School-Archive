//
//  main.cpp
//  Week11
//
//  Created by Adam Di Cioccio on 2022-04-03.
//
#include "Lab5.h"
#include <jni.h>

int main() {
    return 0;
}

JNIEXPORT jdouble JNICALL Java_Lab5_calculateSTDDev (JNIEnv * env, jclass jc, jintArray array) {
    int length = env->GetArrayLength(array);
    jint* nums = (env)->GetIntArrayElements(array, NULL);
    
    int sum = 0;
    int mean = 0;
    int mean1 = 0;
    int answer = 0;
    
    for (int i  = 0; i <= length; i++) {
        sum += nums[i];
    }
    
    mean = sum / length;
    
    sum = 0;
    
    for (int i = 0; i <= length; i++) {
        sum += (nums[i] - mean) * (nums[i] - mean);
    }
    
    mean1 = sum / length;
    answer = mean1;
    
    env->ReleaseIntArrayElements(array, nums, 0);
    
    return answer;
}

JNIEXPORT jdouble JNICALL Java_Lab5_calculateMean (JNIEnv * env, jclass jc, jintArray array) {
    int length = env->GetArrayLength(array);
    jint* nums = (env)->GetIntArrayElements(array, NULL);
    
    int sum = 0;
    int answer = 0;
    
    for (int i  = 0; i <= length; i++) {
        sum += nums[i];
    }
    
    answer = sum / length;
    
    env->ReleaseIntArrayElements(array, nums, 0);
    
    return answer;
}

