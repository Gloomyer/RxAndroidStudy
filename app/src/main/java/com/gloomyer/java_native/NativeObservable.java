package com.gloomyer.java_native;


import java.util.Observable;

/**
 * @author Gloomy
 * @version 1.0
 * @name RxAndroidStudy
 * @class name：com.gloomyer.java_native
 * @class 被观察者
 * @time 2018/12/19 21:32
 * @change
 */
public class NativeObservable extends Observable {
    private int data = 0;

    public int getData() {
        return data;
    }

    public void setData(int data) {
        if (this.data != data) {
            this.data = data;
            //通知观察者，数据发生了改变
            setChanged();
            notifyObservers();
        }
    }
}
