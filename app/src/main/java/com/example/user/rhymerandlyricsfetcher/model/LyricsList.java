package com.example.user.rhymerandlyricsfetcher.model;

/**
 * Created by user on 8/1/2017.
 */

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LyricsList implements Parcelable
{

    @SerializedName("message")
    @Expose
    private Message message;
    public final static Parcelable.Creator<LyricsList> CREATOR = new Creator<LyricsList>() {


        @SuppressWarnings({
                "unchecked"
        })
        public LyricsList createFromParcel(Parcel in) {
            LyricsList instance = new LyricsList();
            instance.message = ((Message) in.readValue((Message.class.getClassLoader())));
            return instance;
        }

        public LyricsList[] newArray(int size) {
            return (new LyricsList[size]);
        }

    }
            ;

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(message);
    }

    public int describeContents() {
        return 0;
    }

}