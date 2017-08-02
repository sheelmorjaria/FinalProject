package com.example.sheelmorjaria.rhymemusiclyrics.model;

/**
 * Created by user on 8/2/2017.
 */

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TrackList implements Parcelable
{

    @SerializedName("track")
    @Expose
    private Track track;
    public final static Parcelable.Creator<TrackList> CREATOR = new Creator<TrackList>() {


        @SuppressWarnings({
                "unchecked"
        })
        public TrackList createFromParcel(Parcel in) {
            TrackList instance = new TrackList();
            instance.track = ((Track) in.readValue((Track.class.getClassLoader())));
            return instance;
        }

        public TrackList[] newArray(int size) {
            return (new TrackList[size]);
        }

    }
            ;

    public Track getTrack() {
        return track;
    }

    public void setTrack(Track track) {
        this.track = track;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(track);
    }

    public int describeContents() {
        return 0;
    }

}

