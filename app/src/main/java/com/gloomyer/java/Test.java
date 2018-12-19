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
public class Test {
    public static void main(String... args) throws Exception {
        Watched xiaoming = new WatchedImpl();


        Watcher xiaohong = new WatcherImpl();
        Watcher xiaolv = new WatcherImpl();
        Watcher xiaolan = new WatcherImpl();

        xiaoming.addWatcher(xiaohong);
        xiaoming.addWatcher(xiaolv);
        xiaoming.addWatcher(xiaolan);


        xiaoming.notifyWatchers("偷东西啦!");
    }
}
