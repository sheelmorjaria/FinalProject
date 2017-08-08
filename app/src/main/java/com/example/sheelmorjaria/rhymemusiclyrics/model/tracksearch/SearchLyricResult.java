package com.example.sheelmorjaria.rhymemusiclyrics.model.tracksearch;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by user on 8/8/2017.
 */
@Root(name = "SearchLyricResult")
public class SearchLyricResult {

    @Element(name="TrackId", required = false)
    String trackId;


    @Element(name="LyricChecksum", required = false)
    String lyricChecksum;


    @Element(name="LyricId", required = false)
    String lyricId;


    @Element(name="SongUrl", required = false)
    String songUrl;


    @Element(name="ArtistUrl", required = false)
    String artistUrl;


    @Element(name="Artist", required = false)
    String artist;


    @Element(name="Song", required = false)
    String song;


    @Element(name="SongRank", required = false)
    String songRank;


    @Attribute(name="nil", required = false)
    Boolean nil;



    public String getTrackId() { return this.trackId; }
    public void setTrackId(String _value) { this.trackId = _value; }


    public String getLyricChecksum() { return this.lyricChecksum; }
    public void setLyricChecksum(String _value) { this.lyricChecksum = _value; }


    public String getLyricId() { return this.lyricId; }
    public void setLyricId(String _value) { this.lyricId = _value; }


    public String getSongUrl() { return this.songUrl; }
    public void setSongUrl(String _value) { this.songUrl = _value; }


    public String getArtistUrl() { return this.artistUrl; }
    public void setArtistUrl(String _value) { this.artistUrl = _value; }


    public String getArtist() { return this.artist; }
    public void setArtist(String _value) { this.artist = _value; }


    public String getSong() { return this.song; }
    public void setSong(String _value) { this.song = _value; }


    public String getSongRank() { return this.songRank; }
    public void setSongRank(String _value) { this.songRank = _value; }


    public Boolean getNil() { return this.nil; }
    public void setNil(Boolean _value) { this.nil = _value; }


}
