package com.example.user.rhymerandlyricsfetcher.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Body implements Parcelable
{

    @SerializedName("track_list")
    @Expose
    private List<TrackList> trackList = null;
    public final static Parcelable.Creator<Body> CREATOR = new Creator<Body>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Body createFromParcel(Parcel in) {
            Body instance = new Body();
            in.readList(instance.trackList, (com.example.user.rhymerandlyricsfetcher.model.TrackList.class.getClassLoader()));
            return instance;
        }

        public Body[] newArray(int size) {
            return (new Body[size]);
        }

    }
            ;

    public List<TrackList> getTrackList() {
        return trackList;
    }

    public void setTrackList(List<TrackList> trackList) {
        this.trackList = trackList;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(trackList);
    }

    public int describeContents() {
        return 0;
    }

}