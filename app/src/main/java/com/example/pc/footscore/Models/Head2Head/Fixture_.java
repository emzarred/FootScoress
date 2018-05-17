package com.example.pc.footscore.Models.Head2Head;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by pc on 09/05/2018.
 */

public class Fixture_ {
   /* @SerializedName("_links")
    @Expose
    private Links_____ links;*/
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("status")
    @Expose
    private Object status;
    @SerializedName("matchday")
    @Expose
    private Integer matchday;
    @SerializedName("homeTeamName")
    @Expose
    private String homeTeamName;
    @SerializedName("awayTeamName")
    @Expose
    private String awayTeamName;
    @SerializedName("result")
    @Expose
    private Result_____ result;
    @SerializedName("odds")
    @Expose
    private Object odds;

   /* public Links_____ getLinks() {
        return links;
    }

    public void setLinks(Links_____ links) {
        this.links = links;
    }*/

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Object getStatus() {
        return status;
    }

    public void setStatus(Object status) {
        this.status = status;
    }

    public Integer getMatchday() {
        return matchday;
    }

    public void setMatchday(Integer matchday) {
        this.matchday = matchday;
    }

    public String getHomeTeamName() {
        return homeTeamName;
    }

    public void setHomeTeamName(String homeTeamName) {
        this.homeTeamName = homeTeamName;
    }

    public String getAwayTeamName() {
        return awayTeamName;
    }

    public void setAwayTeamName(String awayTeamName) {
        this.awayTeamName = awayTeamName;
    }

    public Result_____ getResult() {
        return result;
    }

    public void setResult(Result_____ result) {
        this.result = result;
    }

    public Object getOdds() {
        return odds;
    }

    public void setOdds(Object odds) {
        this.odds = odds;
    }
}
