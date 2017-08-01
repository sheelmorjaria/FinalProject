package com.example.user.rhymerandlyricsfetcher.model;

/**
 * Created by user on 8/1/2017.
 */

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SecondaryGenres implements Parcelable
{

    @SerializedName("music_genre_list")
    @Expose
    private List<Object> musicGenreList = null;
    public final static Parcelable.Creator<SecondaryGenres> CREATOR = new Creator<SecondaryGenres>() {


        @SuppressWarnings({
                "unchecked"
        })
        public SecondaryGenres createFromParcel(Parcel in) {
            SecondaryGenres instance = new SecondaryGenres();
            in.readList(instance.musicGenreList, (java.lang.Object.class.getClassLoader()));
            return instance;
        }

        public SecondaryGenres[] newArray(int size) {
            return (new SecondaryGenres[size]);
        }

    }
            ;

    public List<Object> getMusicGenreList() {
        return musicGenreList;
    }

    public void setMusicGenreList(List<Object> musicGenreList) {
        this.musicGenreList = musicGenreList;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(musicGenreList);
    }

    public int describeContents() {
        return 0;
    }

}