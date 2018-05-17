package com.example.pc.footscore.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by pc on 01/05/2018.
 */

public class Fixtures {
   /* @SerializedName("_links")
    @Expose
    private Links links;*/
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
