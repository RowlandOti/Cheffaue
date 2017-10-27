package com.rowland.cheffaue.domain.model;

import android.os.Parcel;
import android.os.Parcelable;

public class NutritionEstimate implements Parcelable {

    private String attribute;

    private String description;

    private Double value;

    private Unit unit;

    public final static Parcelable.Creator<NutritionEstimate> CREATOR = new Creator<NutritionEstimate>() {


        @SuppressWarnings({
                "unchecked"
        })
        public NutritionEstimate createFromParcel(Parcel in) {
            return new NutritionEstimate(in);
        }

        public NutritionEstimate[] newArray(int size) {
            return (new NutritionEstimate[size]);
        }

    };

    protected NutritionEstimate(Parcel in) {
        this.attribute = ((String) in.readValue((String.class.getClassLoader())));
        this.description = ((String) in.readValue((String.class.getClassLoader())));
        this.value = ((Double) in.readValue((Double.class.getClassLoader())));
        this.unit = ((Unit) in.readValue((Unit.class.getClassLoader())));
    }

    public NutritionEstimate() {
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        return "NutritionEstimate [unit = " + unit + ", description = " + description + ", value = " + value + ", attribute = " + attribute + "]";
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(attribute);
        dest.writeValue(description);
        dest.writeValue(value);
        dest.writeValue(unit);
    }

    public int describeContents() {
        return 0;
    }

}
