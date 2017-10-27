
package com.rowland.cheffaue.domain.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Unit implements Parcelable
{

    private String id;

    private String name;

    private String abbreviation;

    private String plural;

    private String pluralAbbreviation;

    private Boolean decimal;
    public final static Parcelable.Creator<Unit> CREATOR = new Creator<Unit>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Unit createFromParcel(Parcel in) {
            return new Unit(in);
        }

        public Unit[] newArray(int size) {
            return (new Unit[size]);
        }

    }
    ;

    protected Unit(Parcel in) {
        this.id = ((String) in.readValue((String.class.getClassLoader())));
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        this.abbreviation = ((String) in.readValue((String.class.getClassLoader())));
        this.plural = ((String) in.readValue((String.class.getClassLoader())));
        this.pluralAbbreviation = ((String) in.readValue((String.class.getClassLoader())));
        this.decimal = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
    }

    public Unit() {
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

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(name);
        dest.writeValue(abbreviation);
        dest.writeValue(plural);
        dest.writeValue(pluralAbbreviation);
        dest.writeValue(decimal);
    }

    public int describeContents() {
        return  0;
    }

}
