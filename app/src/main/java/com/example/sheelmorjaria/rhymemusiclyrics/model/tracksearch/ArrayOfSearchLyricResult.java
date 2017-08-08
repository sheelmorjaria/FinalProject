package com.example.sheelmorjaria.rhymemusiclyrics.model.tracksearch;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(name = "ArrayOfSearchLyricResult")
public class ArrayOfSearchLyricResult {

    @ElementList(name = "SearchLyricResult", inline = true, required = false)
    List<SearchLyricResult> searchLyricResult;


    @Attribute(name="xsd", required = false)
    String xsd;


    @Attribute(name="xsi", required = false)
    String xsi;



    public List<SearchLyricResult> getSearchLyricResult() { return this.searchLyricResult; }
    public void setSearchLyricResult(List<SearchLyricResult> _value) { this.searchLyricResult = _value; }


    public String getXsd() { return this.xsd; }
    public void setXsd(String _value) { this.xsd = _value; }


    public String getXsi() { return this.xsi; }
    public void setXsi(String _value) { this.xsi = _value; }




}