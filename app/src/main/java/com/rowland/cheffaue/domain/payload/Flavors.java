
package com.rowland.cheffaue.domain.payload;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Flavors {

    @SerializedName("Piquant")
    @Expose
    private Double piquant;
    @SerializedName("Meaty")
    @Expose
    private Double meaty;
    @SerializedName("Bitter")
    @Expose
    private Double bitter;
    @SerializedName("Sweet")
    @Expose
    private Double sweet;
    @SerializedName("Sour")
    @Expose
    private Double sour;
    @SerializedName("Salty")
    @Expose
    private Double salty;

    public Double getPiquant() {
        return piquant;
    }

    public void setPiquant(Double piquant) {
        this.piquant = piquant;
    }

    public Double getMeaty() {
        return meaty;
    }

    public void setMeaty(Double meaty) {
        this.meaty = meaty;
    }

    public Double getBitter() {
        return bitter;
    }

    public void setBitter(Double bitter) {
        this.bitter = bitter;
    }

    public Double getSweet() {
        return sweet;
    }

    public void setSweet(Double sweet) {
        this.sweet = sweet;
    }

    public Double getSour() {
        return sour;
    }

    public void setSour(Double sour) {
        this.sour = sour;
    }

    public Double getSalty() {
        return salty;
    }

    public void setSalty(Double salty) {
        this.salty = salty;
    }

    @Override
    public String toString() {
        return "Flavors [Piquant = " + piquant + ", Bitter = " + bitter + ", Salty = " + salty + ", Sour = " + sour + ", Sweet = " + sweet + ", Meaty = " + meaty + "]";
    }

}
