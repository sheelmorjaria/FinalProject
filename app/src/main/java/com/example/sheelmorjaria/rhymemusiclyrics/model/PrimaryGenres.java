package com.example.sheelmorjaria.rhymemusiclyrics.model;

/**
 * Created by user on 8/2/2017.
 */

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PrimaryGenres implements Parcelable
{

    @SerializedName("music_genre_list")
    @Expose
    private List<MusicGenreList> musicGenreList = null;
    public final static Parcelable.Creator<PrimaryGenres> CREATOR = new Creator<PrimaryGenres>() {


        @SuppressWarnings({
                "unchecked"
        })
        public PrimaryGenres createFromParcel(Parcel in) {
            PrimaryGenres instance = new PrimaryGenres();
            in.readList(instance.musicGenreList, (com.example.sheelmorjaria.rhymemusiclyrics.model.MusicGenreList.class.getClassLoader()));
            return instance;
        }

        public PrimaryGenres[] newArray(int size) {
            return (new PrimaryGenres[size]);
        }

    }
            ;

    public List<MusicGenreList> getMusicGenreList() {
        return musicGenreList;
    }

    public void setMusicGenreList(List<MusicGenreList> musicGenreList) {
        this.musicGenreList = musicGenreList;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(musicGenreList);
    }

    public int describeContents() {
        return 0;
    }

}