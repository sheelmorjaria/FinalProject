package com.example.sheelmorjaria.rhymemusiclyrics.Interactor;

/**
 * Created by user on 8/2/2017.
 */

import com.example.sheelmorjaria.rhymemusiclyrics.model.Constants;
import com.example.sheelmorjaria.rhymemusiclyrics.model.tracksearch.ArrayOfSearchLyricResult;
import com.example.sheelmorjaria.rhymemusiclyrics.service.RequestInterface2;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import io.reactivex.Observable;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

/**
 * Created by user on 8/1/2017.
 */

/**
 * Created by user on 8/1/2017.
 */
public class InteractorTwoImpl  implements InteractorTwo{
    RequestInterface2 requestInterface;
    static OkHttpClient okHttpClient;
    static Retrofit retrofit;

    @Override
    public Observable<ArrayOfSearchLyricResult> getTracksWithLyrics(String q_lyrics){
        return requestInterface.getTracksWithLyrics(q_lyrics);
    }

    public InteractorTwoImpl() {
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
        requestInterface = retrofit.create(RequestInterface2.class);
    }

}
