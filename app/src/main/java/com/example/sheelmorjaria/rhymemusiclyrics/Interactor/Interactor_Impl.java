package com.example.sheelmorjaria.rhymemusiclyrics.Interactor;

/**
 * Created by user on 8/2/2017.
 */

import com.example.sheelmorjaria.rhymemusiclyrics.model.Constants;
import com.example.sheelmorjaria.rhymemusiclyrics.model.rhymes.RhymesModel;
import com.example.sheelmorjaria.rhymemusiclyrics.service.RequestInterface;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.List;

import io.reactivex.Observable;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by user on 8/1/2017.
 */

public class Interactor_Impl implements Interactor {
    RequestInterface requestInterface;
    static OkHttpClient okHttpClient;
    static Retrofit retrofit;

    @Override
    public Observable<List<RhymesModel>> getRhymeResults(String word){
        return requestInterface.getRhymeResults(word);
    }


    public Interactor_Impl() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .build();
        retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build();
        requestInterface = retrofit.create(RequestInterface.class);
    }

}
