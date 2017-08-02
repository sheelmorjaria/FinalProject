package com.example.sheelmorjaria.rhymemusiclyrics.model;

/**
 * Created by user on 8/2/2017.
 */

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MusicGenreList implements Parcelable
{

    @SerializedName("music_genre")
    @Expose
    private MusicGenre musicGenre;
    public final static Parcelable.Creator<MusicGenreList> CREATOR = new Creator<MusicGenreList>() {


        @SuppressWarnings({
                "unchecked"
        })
        public MusicGenreList createFromParcel(Parcel in) {
            MusicGenreList instance = new MusicGenreList();
            instance.musicGenre = ((MusicGenre) in.readValue((MusicGenre.class.getClassLoader())));
            return instance;
        }

        public MusicGenreList[] newArray(int size) {
            return (new MusicGenreList[size]);
        }

    }
            ;

    public MusicGenre getMusicGenre() {
        return musicGenre;
    }

    public void setMusicGenre(MusicGenre musicGenre) {
        this.musicGenre = musicGenre;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(musicGenre);
    }

    public int describeContents() {
        return 0;
    }

}