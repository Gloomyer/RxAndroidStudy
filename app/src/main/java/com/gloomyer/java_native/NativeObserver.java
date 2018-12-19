package com.gloomyer.java_native;

import java.util.Observable;
import java.util.Observer;

/**
 * @author Gloomy
 * @version 1.0
 * @name RxAndroidStudy
 * @class name：com.gloomyer.java_native
 * @class 观察者
 * @time 2018/12/19 21:35
 * @change
 */
public class NativeObserver implements Observer {

    public NativeObserver(NativeObservable observable) {
        observable.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("data is changed:" + ((NativeObservable) o).getData());
    }

}
