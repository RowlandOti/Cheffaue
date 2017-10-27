
package com.rowland.cheffaue.domain.payload;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Unit implements Parcelable{

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("abbreviation")
    @Expose
    private String abbreviation;
    @SerializedName("plural")
    @Expose
    private String plural;
    @SerializedName("pluralAbbreviation")
    @Expose
    private String pluralAbbreviation;
    @SerializedName("decimal")
    @Expose
    private Boolean decimal;

    protected Unit(Parcel in) {
        id = in.readString();
        name = in.readString();
        abbreviation = in.readString();
        plural = in.readString();
        pluralAbbreviation = in.readString();
        byte tmpDecimal = in.readByte();
        decimal = tmpDecimal == 0 ? null : tmpDecimal == 1;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getPlural() {
        return plural;
    }

    public void setPlural(String plural) {
        this.plural = plural;
    }

    public String getPluralAbbreviation() {
        return pluralAbbreviation;
    }

    public void setPluralAbbreviation(String pluralAbbreviation) {
        this.pluralAbbreviation = pluralAbbreviation;
    }

    public Boolean getDecimal() {
        return decimal;
    }

    public void setDecimal(Boolean decimal) {
        this.decimal = decimal;
    }

    @Override
    public String toString() {
        return "Unit [id = " + id + ", name = " + name + ", plural = " + plural + ", abbreviation = " + abbreviation + ", decimal = " + decimal + ", pluralAbbreviation = " + pluralAbbreviation + "]";
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(name);
        dest.writeString(abbreviation);
        dest.writeString(plural);
        dest.writeString(pluralAbbreviation);
        dest.writeByte((byte) (decimal == null ? 0 : decimal ? 1 : 2));
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Unit> CREATOR = new Creator<Unit>() {
        @Override
        public Unit createFromParcel(Parcel in) {
            return new Unit(in);
        }

        @Override
        public Unit[] newArray(int size) {
            return new Unit[size];
        }
    };
}
