package com.example.pc.footscore.Models;

/**
 * Created by pc on 27/04/2018.
 */


import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LeagueTable {

   /* @SerializedName("_links")
    @Expose
    private Links links;*/
    @SerializedName("leagueCaption")
    @Expose
    private String leagueCaption;
    @SerializedName("matchday")
    @Expose
    private Integer matchday;
    @SerializedName("standing")
    @Expose
    private List<Standing> standing = null;

   /* public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;*/


    public String getLeagueCaption() {
        return leagueCaption;
    }

    public void setLeagueCaption(String leagueCaption) {
        this.leagueCaption = leagueCaption;
    }

    public Integer getMatchday() {
        return matchday;
    }

    public void setMatchday(Integer matchday) {
        this.matchday = matchday;
    }

    public List<Standing> getStanding() {
        return standing;
    }

    public void setStanding(List<Standing> standing) {
        this.standing = standing;
    }

}
