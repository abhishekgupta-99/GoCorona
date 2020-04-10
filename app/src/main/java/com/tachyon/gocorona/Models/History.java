
package com.tachyon.gocorona.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class History {

    @SerializedName("day")
    @Expose
    private String day;
    @SerializedName("total")
    @Expose
    private com.tachyon.gocorona.Models.Total total;
    @SerializedName("statewise")
    @Expose
    private ArrayList<com.tachyon.gocorona.Models.Statewise> statewise = null;

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public com.tachyon.gocorona.Models.Total getTotal() {
        return total;
    }

    public void setTotal(com.tachyon.gocorona.Models.Total total) {
        this.total = total;
    }

    public ArrayList<com.tachyon.gocorona.Models.Statewise> getStatewise() {
        return statewise;
    }

    public void setStatewise(ArrayList<com.tachyon.gocorona.Models.Statewise> statewise) {
        this.statewise = statewise;
    }

}
