
package com.rowland.cheffaue.domain.payload;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.ToStringBuilder;

public class Attributes {

    @SerializedName("course")
    @Expose
    private List<String> course = null;
    @SerializedName("cuisine")
    @Expose
    private List<String> cuisine = null;

    public List<String> getCourse() {
        return course;
    }

    public void setCourse(List<String> course) {
        this.course = course;
    }

    public List<String> getCuisine() {
        return cuisine;
    }

    public void setCuisine(List<String> cuisine) {
        this.cuisine = cuisine;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("course", course).append("cuisine", cuisine).toString();
    }

}
