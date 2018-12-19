package com.gloomyer.java;

/**
 * @author Gloomy
 * @version 1.0
 * @name RxAndroidStudy
 * @class name：com.gloomyer.java
 * @class 被观察者
 * @time 2018/12/19 21:19
 * @change
 */
public interface Watched {
    void addWatcher(Watcher watcher);
    void removeWatcher(Watcher watcher);
    void notifyWatchers(String arg);
}
