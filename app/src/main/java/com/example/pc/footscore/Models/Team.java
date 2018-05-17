package com.example.pc.footscore.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by pc on 27/04/2018.
 */

public class Team {
   /* @SerializedName("_links")
    @Expose
    private Links_ links;*/
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("code")
    @Expose
    private Object code;
    @SerializedName("shortName")
    @Expose
    private String shortName;
    @SerializedName("squadMarketValue")
    @Expose
    private Object squadMarketValue;
    @SerializedName("crestUrl")
    @Expose
    private String crestUrl;

   /* public Links_ getLinks() {
        return links;
    }

    public void setLinks(Links_ links) {
        this.links = links;
    }*/

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getCode() {
        return code;
    }

    public void setCode(Object code) {
        this.code = code;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public Object getSquadMarketValue() {
        return squadMarketValue;
    }

    public void setSquadMarketValue(Object squadMarketValue) {
        this.squadMarketValue = squadMarketValue;
    }

    public String getCrestUrl() {
        return crestUrl;
    }

    public void setCrestUrl(String crestUrl) {
        this.crestUrl = crestUrl;
    }
}

