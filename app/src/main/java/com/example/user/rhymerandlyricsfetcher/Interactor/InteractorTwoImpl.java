package com.example.user.rhymerandlyricsfetcher.Interactor;

import com.example.user.rhymerandlyricsfetcher.model.Constants;
import com.example.user.rhymerandlyricsfetcher.model.Track;
import com.example.user.rhymerandlyricsfetcher.service.RequestInterface;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import io.reactivex.Observable;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by user on 8/1/2017.
 */

    /**
     * Created by user on 8/1/2017.
     */
    public class InteractorTwoImpl  implements InteractorTwo{
        RequestInterface requestInterface;
        static OkHttpClient okHttpClient;
        static Retrofit retrofit;

        @Override
        public Observable<Track> getTracksWithLyrics(String word){
            return requestInterface.getTracksWithLyrics(word);
        }


        public InteractorTwoImpl() {
            HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            okHttpClient = new OkHttpClient.Builder()
                    .addInterceptor(httpLoggingInterceptor)
                    .build();
            retrofit = new Retrofit.Builder()
                    .baseUrl(Constants.LYRICSBASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .client(okHttpClient)
                    .build();
            requestInterface = retrofit.create(RequestInterface.class);
        }

    }

