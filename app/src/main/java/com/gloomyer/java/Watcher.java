package com.gloomyer.java;

/**
 * @author Gloomy
 * @version 1.0
 * @name RxAndroidStudy
 * @class name：com.gloomyer.java
 * @class 观察者
 * @time 2018/12/19 21:18
 * @change
 */
public interface Watcher {

    /**
     * 接受参数
     *
     * @param arg
     */
    void update(String arg);
}
