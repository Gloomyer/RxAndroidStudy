package com.gloomyer.rxJava;

import android.annotation.SuppressLint;

import java.util.concurrent.TimeUnit;

import android.os.Build;
import android.support.annotation.RequiresApi;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;

/**
 * @author Gloomy
 * @version 1.0
 * @name RxAndroidStudy
 * @class name：com.gloomyer.rxJava
 * @class describe
 * @time 2018/12/19 21:46
 * @change
 */
public class RxJavaTest {
    public static final String TAG = RxJavaTest.class.getSimpleName();

    public static void main(String... args) {
        //createObseraable1();
        //createObseraable2();
        //createObseraable3();
        filter();
    }

    /**
     * 创建被观察者
     */
    private static void createObseraable1() {
        //定义被观察者
        Observable<String> observable = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                emitter.onNext("1");
                emitter.onNext("2");
                emitter.onNext(downloadJson());
                emitter.onNext("end");
                emitter.onComplete();
            }
        });
        System.out.println("new observable:" + observable);
        //定义观察者
        Observer<String> subscriber = new Observer<String>() {

            @Override
            public void onSubscribe(Disposable d) {
                System.out.println("onSubscribe:" + d);
            }

            @Override
            public void onNext(String s) {
                System.out.println("onNext:" + s + "  thread:" + Thread.currentThread().getName());
            }

            @Override
            public void onError(Throwable t) {
                System.out.println("onError:" + t);
            }

            @Override
            public void onComplete() {
                System.out.println("onComplete");
            }
        };

        //执行订阅
        observable.subscribe(subscriber);
    }

    /**
     * 创建被观察者
     */
    private static void createObseraable2() {
        //定义被观察者
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                for (int i = 1; i <= 10; i++) {
                    emitter.onNext(i);
                }
                emitter.onComplete();
            }
        }).subscribe(new Observer<Integer>() {

            @Override
            public void onSubscribe(Disposable d) {
                System.out.println("onSubscribe:" + d.isDisposed());
            }

            @Override
            public void onNext(Integer s) {
                System.out.println("onNext:" + s + "  thread:" + Thread.currentThread().getName());
            }

            @Override
            public void onError(Throwable t) {
                System.out.println("onError:" + t);
            }

            @Override
            public void onComplete() {
                System.out.println("onComplete");
            }
        });
    }

    @SuppressLint("CheckResult")
    private static void createObseraable3() {
        Integer[] items = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        Observable<Integer> observable = Observable.fromArray(items);
        observable.subscribe(item -> System.out.println("createObseraable3:" + item));
    }


    @SuppressLint("CheckResult")
    private static void filter() {
        Observable.just(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .filter(i -> i >= 5)
                //.observeOn(Schedulers.io())
                .subscribe(i ->
                        System.out.println("out:" + i
                                + " thread:" + Thread.currentThread().getName()));
    }

    /**
     * 调用网络下载
     *
     * @return
     */
    private static String downloadJson() {
        return "{\"data\":\"1\"}";
    }
}
