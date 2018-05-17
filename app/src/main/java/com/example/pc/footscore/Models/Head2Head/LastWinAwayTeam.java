package com.example.pc.footscore.Models.Head2Head;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by pc on 09/05/2018.
 */

public class LastWinAwayTeam {
   /* @SerializedName("_links")
    @Expose
    private Links____ links;*/
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("status")
    @Expose
    private String status;
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
    private Result____ result;
   /* @SerializedName("odds")
    @Expose
    private Odds__ odds;

    public Links____ getLinks() {
        return links;
    }

    public void setLinks(Links____ links) {
        this.links = links;
    }*/

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
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

    public Result____ getResult() {
        return result;
    }

    public void setResult(Result____ result) {
        this.result = result;
    }

   /* public Odds__ getOdds() {
        return odds;
    }

    public void setOdds(Odds__ odds) {
        this.odds = odds;
    }*/

}
