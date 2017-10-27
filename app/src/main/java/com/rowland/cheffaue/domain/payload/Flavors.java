
package com.rowland.cheffaue.domain.payload;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Flavors implements Parcelable{

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


    public final static Parcelable.Creator<Flavors> CREATOR = new Parcelable.Creator<Flavors>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Flavors createFromParcel(Parcel in) {
            return new Flavors(in);
        }

        public Flavors[] newArray(int size) {
            return (new Flavors[size]);
        }

    };

    protected Flavors(Parcel in) {
        this.piquant = ((Double) in.readValue((Double.class.getClassLoader())));
        this.meaty = ((Double) in.readValue((Double.class.getClassLoader())));
        this.bitter = ((Double) in.readValue((Double.class.getClassLoader())));
        this.sweet = ((Double) in.readValue((Double.class.getClassLoader())));
        this.sour = ((Double) in.readValue((Double.class.getClassLoader())));
        this.salty = ((Double) in.readValue((Double.class.getClassLoader())));
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(piquant);
        dest.writeValue(meaty);
        dest.writeValue(bitter);
        dest.writeValue(sweet);
        dest.writeValue(sour);
        dest.writeValue(salty);
    }

    public int describeContents() {
        return 0;
    }

}
