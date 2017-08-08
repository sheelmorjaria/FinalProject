package com.example.sheelmorjaria.rhymemusiclyrics.model.lyrics;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "GetLyricResult")
public class GetLyricResult {

    @Element(name="TrackId", required = false)
    String trackId;


    @Element(name="LyricChecksum", required = false)
    String lyricChecksum;


    @Element(name="LyricId", required = false)
    String lyricId;


    @Element(name="LyricSong", required = false)
    String lyricSong;


    @Element(name="LyricArtist", required = false)
    String lyricArtist;


    @Element(name="LyricUrl", required = false)
    String lyricUrl;


    @Element(name="LyricCovertArtUrl", required = false)
    String lyricCovertArtUrl;


    @Element(name="LyricRank", required = false)
    String lyricRank;


    @Element(name="LyricCorrectUrl", required = false)
    String lyricCorrectUrl;


    @Element(name="Lyric", required = false)
    String lyric;


    @Attribute(name="xsd", required = false)
    String xsd;


    @Attribute(name="xsi", required = false)
    String xsi;



    public String getTrackId() { return this.trackId; }
    public void setTrackId(String _value) { this.trackId = _value; }


    public String getLyricChecksum() { return this.lyricChecksum; }
    public void setLyricChecksum(String _value) { this.lyricChecksum = _value; }


    public String getLyricId() { return this.lyricId; }
    public void setLyricId(String _value) { this.lyricId = _value; }


    public String getLyricSong() { return this.lyricSong; }
    public void setLyricSong(String _value) { this.lyricSong = _value; }


    public String getLyricArtist() { return this.lyricArtist; }
    public void setLyricArtist(String _value) { this.lyricArtist = _value; }


    public String getLyricUrl() { return this.lyricUrl; }
    public void setLyricUrl(String _value) { this.lyricUrl = _value; }


    public String getLyricCovertArtUrl() { return this.lyricCovertArtUrl; }
    public void setLyricCovertArtUrl(String _value) { this.lyricCovertArtUrl = _value; }


    public String getLyricRank() { return this.lyricRank; }
    public void setLyricRank(String _value) { this.lyricRank = _value; }


    public String getLyricCorrectUrl() { return this.lyricCorrectUrl; }
    public void setLyricCorrectUrl(String _value) { this.lyricCorrectUrl = _value; }


    public String getLyric() { return this.lyric; }
    public void setLyric(String _value) { this.lyric = _value; }


    public String getXsd() { return this.xsd; }
    public void setXsd(String _value) { this.xsd = _value; }


    public String getXsi() { return this.xsi; }
    public void setXsi(String _value) { this.xsi = _value; }


}