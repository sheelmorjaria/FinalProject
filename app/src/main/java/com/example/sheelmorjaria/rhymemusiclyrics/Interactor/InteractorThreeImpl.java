package com.example.sheelmorjaria.rhymemusiclyrics.Interactor;

import com.example.sheelmorjaria.rhymemusiclyrics.model.Constants;
import com.example.sheelmorjaria.rhymemusiclyrics.model.lyrics.GetLyricResult;
import com.example.sheelmorjaria.rhymemusiclyrics.service.RequestInterface;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import io.reactivex.Observable;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

/**
 * Created by user on 8/3/2017.
 */

public class InteractorThreeImpl implements InteractorThree {
    RequestInterface requestInterface;
    static OkHttpClient okHttpClient;
    static Retrofit retrofit;
    @Override
    public Observable<GetLyricResult> getLyrics(String lyricId, String lyricChecksum){
        return requestInterface.getLyrics(lyricId, lyricChecksum);
    }
    public InteractorThreeImpl() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .build();
        retrofit = new Retrofit.Builder()
                .baseUrl(Constants.LYRICSBASE_URL)
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build();
        requestInterface = retrofit.create(RequestInterface.class);
    }
}
