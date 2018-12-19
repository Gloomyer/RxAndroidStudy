package com.gloomyer.java_native;


/**
 * @author Gloomy
 * @version 1.0
 * @name RxAndroidStudy
 * @class name：com.gloomyer.java
 * @class describe
 * @time 2018/12/19 21:22
 * @change
 */
public class TestNative {
    public static void main(String... args) throws Exception {
        NativeObservable xiaoming = new NativeObservable();


        NativeObserver xiaohong = new NativeObserver(xiaoming);
        //NativeObserver xiaolv = new NativeObserver(xiaoming);
        //NativeObserver xiaolan = new NativeObserver(xiaoming);

        xiaoming.setData(1);
        xiaoming.setData(1);
        xiaoming.setData(2);
    }
}
