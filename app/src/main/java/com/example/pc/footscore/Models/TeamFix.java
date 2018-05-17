package com.example.pc.footscore.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by pc on 08/05/2018.
 */

public class TeamFix {
   /* @SerializedName("_links")
    @Expose
    private Links links;*/
    @SerializedName("timeFrameStart")
    @Expose
    private String timeFrameStart;
    @SerializedName("timeFrameEnd")
    @Expose
    private String timeFrameEnd;
    @SerializedName("count")
    @Expose
    private Integer count;
    @SerializedName("fixtures")
    @Expose
    private List<Fixture> fixtures = null;

   /* public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }*/

    public String getTimeFrameStart() {
        return timeFrameStart;
    }

    public void setTimeFrameStart(String timeFrameStart) {
        this.timeFrameStart = timeFrameStart;
    }

    public String getTimeFrameEnd() {
        return timeFrameEnd;
    }

    public void setTimeFrameEnd(String timeFrameEnd) {
        this.timeFrameEnd = timeFrameEnd;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<Fixture> getFixtures() {
        return fixtures;
    }

    public void setFixtures(List<Fixture> fixtures) {
        this.fixtures = fixtures;
    }
}
