package com.example.user.rhymerandlyricsfetcher.model;

/**
 * Created by user on 8/1/2017.
 */


import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Message implements Parcelable
{

    @SerializedName("header")
    @Expose
    private Header header;
    @SerializedName("body")
    @Expose
    private Body body;
    public final static Parcelable.Creator<Message> CREATOR = new Creator<Message>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Message createFromParcel(Parcel in) {
            Message instance = new Message();
            instance.header = ((Header) in.readValue((Header.class.getClassLoader())));
            instance.body = ((Body) in.readValue((Body.class.getClassLoader())));
            return instance;
        }

        public Message[] newArray(int size) {
            return (new Message[size]);
        }

    }
            ;

    public Header getHeader() {
        return header;
    }

    public void setHeader(Header header) {
        this.header = header;
    }

    public Body getBody() {
        return body;
    }

    public void setBody(Body body) {
        this.body = body;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(header);
        dest.writeValue(body);
    }

    public int describeContents() {
        return 0;
    }

}