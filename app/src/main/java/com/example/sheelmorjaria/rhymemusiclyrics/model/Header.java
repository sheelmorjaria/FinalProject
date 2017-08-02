package com.example.sheelmorjaria.rhymemusiclyrics.model;

/**
 * Created by user on 8/2/2017.
 */

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Header implements Parcelable
{

    @SerializedName("status_code")
    @Expose
    private Integer statusCode;
    @SerializedName("execute_time")
    @Expose
    private Double executeTime;
    @SerializedName("available")
    @Expose
    private Integer available;
    public final static Parcelable.Creator<Header> CREATOR = new Creator<Header>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Header createFromParcel(Parcel in) {
            Header instance = new Header();
            instance.statusCode = ((Integer) in.readValue((Integer.class.getClassLoader())));
            instance.executeTime = ((Double) in.readValue((Double.class.getClassLoader())));
            instance.available = ((Integer) in.readValue((Integer.class.getClassLoader())));
            return instance;
        }

        public Header[] newArray(int size) {
            return (new Header[size]);
        }

    }
            ;

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public Double getExecuteTime() {
        return executeTime;
    }

    public void setExecuteTime(Double executeTime) {
        this.executeTime = executeTime;
    }

    public Integer getAvailable() {
        return available;
    }

    public void setAvailable(Integer available) {
        this.available = available;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(statusCode);
        dest.writeValue(executeTime);
        dest.writeValue(available);
    }

    public int describeContents() {
        return 0;
    }

}
