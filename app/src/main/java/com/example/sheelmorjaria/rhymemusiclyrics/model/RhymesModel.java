package com.example.sheelmorjaria.rhymemusiclyrics.model;

/**
 * Created by user on 8/2/2017.
 */

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class RhymesModel  implements Parcelable
{

    @SerializedName("word")
    @Expose
    private String word;
    @SerializedName("freq")
    @Expose
    private Integer freq;
    @SerializedName("score")
    @Expose
    private Integer score;
    @SerializedName("flags")
    @Expose
    private String flags;
    @SerializedName("syllables")
    @Expose
    private String syllables;
    public final static Parcelable.Creator<RhymesModel> CREATOR = new Creator<RhymesModel>() {


        @SuppressWarnings({
                "unchecked"
        })
        public RhymesModel createFromParcel(Parcel in) {
            RhymesModel instance = new RhymesModel();
            instance.word = ((String) in.readValue((String.class.getClassLoader())));
            instance.freq = ((Integer) in.readValue((Integer.class.getClassLoader())));
            instance.score = ((Integer) in.readValue((Integer.class.getClassLoader())));
            instance.flags = ((String) in.readValue((String.class.getClassLoader())));
            instance.syllables = ((String) in.readValue((String.class.getClassLoader())));
            return instance;
        }

        public RhymesModel[] newArray(int size) {
            return (new RhymesModel[size]);
        }

    }
            ;

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public Integer getFreq() {
        return freq;
    }

    public void setFreq(Integer freq) {
        this.freq = freq;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getFlags() {
        return flags;
    }

    public void setFlags(String flags) {
        this.flags = flags;
    }

    public String getSyllables() {
        return syllables;
    }

    public void setSyllables(String syllables) {
        this.syllables = syllables;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(word);
        dest.writeValue(freq);
        dest.writeValue(score);
        dest.writeValue(flags);
        dest.writeValue(syllables);
    }

    public int describeContents() {
        return 0;
    }

}


