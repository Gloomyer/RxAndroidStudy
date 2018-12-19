package com.gloomyer.java;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Gloomy
 * @version 1.0
 * @name RxAndroidStudy
 * @class name：com.gloomyer.java
 * @class 被观察者实现类
 * @time 2018/12/19 21:20
 * @change
 */
public class WatchedImpl implements Watched {
    private List<Watcher> mWatchers = new ArrayList<>();

    @Override
    public void addWatcher(Watcher watcher) {
        mWatchers.add(watcher);
    }

    @Override
    public void removeWatcher(Watcher watcher) {
        mWatchers.remove(watcher);
    }

    @Override
    public void notifyWatchers(String arg) {
        for (Watcher watcher : mWatchers) {
            watcher.update(arg);
        }
    }
}
