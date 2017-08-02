package com.example.sheelmorjaria.rhymemusiclyrics.model;

/**
 * Created by user on 8/2/2017.
 */

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MusicGenre implements Parcelable
{

    @SerializedName("music_genre_id")
    @Expose
    private Integer musicGenreId;
    @SerializedName("music_genre_parent_id")
    @Expose
    private Integer musicGenreParentId;
    @SerializedName("music_genre_name")
    @Expose
    private String musicGenreName;
    @SerializedName("music_genre_name_extended")
    @Expose
    private String musicGenreNameExtended;
    @SerializedName("music_genre_vanity")
    @Expose
    private String musicGenreVanity;
    public final static Parcelable.Creator<MusicGenre> CREATOR = new Creator<MusicGenre>() {


        @SuppressWarnings({
                "unchecked"
        })
        public MusicGenre createFromParcel(Parcel in) {
            MusicGenre instance = new MusicGenre();
            instance.musicGenreId = ((Integer) in.readValue((Integer.class.getClassLoader())));
            instance.musicGenreParentId = ((Integer) in.readValue((Integer.class.getClassLoader())));
            instance.musicGenreName = ((String) in.readValue((String.class.getClassLoader())));
            instance.musicGenreNameExtended = ((String) in.readValue((String.class.getClassLoader())));
            instance.musicGenreVanity = ((String) in.readValue((String.class.getClassLoader())));
            return instance;
        }

        public MusicGenre[] newArray(int size) {
            return (new MusicGenre[size]);
        }

    }
            ;

    public Integer getMusicGenreId() {
        return musicGenreId;
    }

    public void setMusicGenreId(Integer musicGenreId) {
        this.musicGenreId = musicGenreId;
    }

    public Integer getMusicGenreParentId() {
        return musicGenreParentId;
    }

    public void setMusicGenreParentId(Integer musicGenreParentId) {
        this.musicGenreParentId = musicGenreParentId;
    }

    public String getMusicGenreName() {
        return musicGenreName;
    }

    public void setMusicGenreName(String musicGenreName) {
        this.musicGenreName = musicGenreName;
    }

    public String getMusicGenreNameExtended() {
        return musicGenreNameExtended;
    }

    public void setMusicGenreNameExtended(String musicGenreNameExtended) {
        this.musicGenreNameExtended = musicGenreNameExtended;
    }

    public String getMusicGenreVanity() {
        return musicGenreVanity;
    }

    public void setMusicGenreVanity(String musicGenreVanity) {
        this.musicGenreVanity = musicGenreVanity;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(musicGenreId);
        dest.writeValue(musicGenreParentId);
        dest.writeValue(musicGenreName);
        dest.writeValue(musicGenreNameExtended);
        dest.writeValue(musicGenreVanity);
    }

    public int describeContents() {
        return 0;
    }

}

