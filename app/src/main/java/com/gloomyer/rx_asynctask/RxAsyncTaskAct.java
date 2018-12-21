package com.gloomyer.rx_asynctask;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.gloomyer.rxandroidstudy.R;


import java.io.IOException;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @author Gloomy
 * @version 1.0
 * @name RxAndroidStudy
 * @class name：com.gloomyer.rx_asynctask
 * @class describe
 * @time 2018/12/22 1:35
 * @change
 */
public class RxAsyncTaskAct extends AppCompatActivity {

    private static final String IMAGE_URL = "https://gloomyer.com/img/img/avatar.png";
    private ImageView ivImage;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx_asynctask);
        ivImage = findViewById(R.id.iv_image);
    }

    @SuppressLint("CheckResult")
    public void downloadImg(View v) {
        //原始方式
//        new MyTask().execute(IMAGE_URL);
        //rxAndroid
        rxDownload()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(bytes -> {
                    Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
                    ivImage.setImageBitmap(bitmap);
                });
    }

    /**
     * 原始方式
     */
    private class MyTask extends AsyncTask<String, Void, byte[]> {

        @Override
        protected byte[] doInBackground(String... strings) {
            try {
                return downloadImg();
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }

        @Override
        protected void onPostExecute(byte[] bytes) {
            Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
            ivImage.setImageBitmap(bitmap);
        }
    }

    /**
     * Rx方式
     *
     * @return
     */
    private Observable<byte[]> rxDownload() {
        return Observable.create(emitter -> {
            emitter.onNext(downloadImg());
            emitter.onComplete();
        });
    }

    private byte[] downloadImg() throws IOException {
        OkHttpClient client = new OkHttpClient
                .Builder()
                .build();
        Request request = new Request.Builder().get()
                .url(IMAGE_URL)
                .build();
        Call call = client.newCall(request);
        Response response = call.execute();
        assert response.body() != null;
        return response.body().bytes();
    }
}
