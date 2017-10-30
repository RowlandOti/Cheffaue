
package com.rowland.cheffaue.domain.payload;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Flavour implements Parcelable{

    @SerializedName("Piquant")
    @Expose
    private Float piquant;
    @SerializedName("Meaty")
    @Expose
    private Float meaty;
    @SerializedName("Bitter")
    @Expose
    private Float bitter;
    @SerializedName("Sweet")
    @Expose
    private Float sweet;
    @SerializedName("Sour")
    @Expose
    private Float sour;
    @SerializedName("Salty")
    @Expose
    private Float salty;

    public Float getPiquant() {

        return piquant != null ? piquant: 0;
    }

    public void setPiquant(Float piquant) {
        this.piquant = piquant;
    }

    public Float getMeaty() {
        return meaty != null ? meaty : 0;
    }

    public void setMeaty(Float meaty) {
        this.meaty = meaty;
    }

    public Float getBitter() {
        return bitter != null ? bitter : 0;
    }

    public void setBitter(Float bitter) {
        this.bitter = bitter;
    }

    public Float getSweet() {
        return sweet != null ? sweet : 0;
    }

    public void setSweet(Float sweet) {
        this.sweet = sweet;
    }

    public Float getSour() {
        return sour != null ? sour : 0;
    }

    public void setSour(Float sour) {
        this.sour = sour;
    }

    public Float getSalty() {
        return salty != null ? salty : 0;
    }

    public void setSalty(Float salty) {
        this.salty = salty;
    }

    @Override
    public String toString() {
        return "Flavour [Piquant = " + piquant + ", Bitter = " + bitter + ", Salty = " + salty + ", Sour = " + sour + ", Sweet = " + sweet + ", Meaty = " + meaty + "]";
    }


    public final static Parcelable.Creator<Flavour> CREATOR = new Parcelable.Creator<Flavour>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Flavour createFromParcel(Parcel in) {
            return new Flavour(in);
        }

        public Flavour[] newArray(int size) {
            return (new Flavour[size]);
        }

    };

    protected Flavour(Parcel in) {
        this.piquant = ((Float) in.readValue((Float.class.getClassLoader())));
        this.meaty = ((Float) in.readValue((Float.class.getClassLoader())));
        this.bitter = ((Float) in.readValue((Float.class.getClassLoader())));
        this.sweet = ((Float) in.readValue((Float.class.getClassLoader())));
        this.sour = ((Float) in.readValue((Float.class.getClassLoader())));
        this.salty = ((Float) in.readValue((Float.class.getClassLoader())));
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
