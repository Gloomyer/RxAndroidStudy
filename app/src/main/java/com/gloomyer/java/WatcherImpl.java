package com.gloomyer.java;

/**
 * @author Gloomy
 * @version 1.0
 * @name RxAndroidStudy
 * @class name：com.gloomyer.java
 * @class describe
 * @time 2018/12/19 21:22
 * @change
 */
public class WatcherImpl implements Watcher {
    @Override
    public void update(String arg) {
        System.out.println(arg);
    }
}
