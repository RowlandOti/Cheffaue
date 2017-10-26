
package com.rowland.cheffaue.domain.payload;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.ToStringBuilder;

public class Source {

    @SerializedName("sourceDisplayName")
    @Expose
    private String sourceDisplayName;
    @SerializedName("sourceSiteUrl")
    @Expose
    private String sourceSiteUrl;
    @SerializedName("sourceRecipeUrl")
    @Expose
    private String sourceRecipeUrl;

    public String getSourceDisplayName() {
        return sourceDisplayName;
    }

    public void setSourceDisplayName(String sourceDisplayName) {
        this.sourceDisplayName = sourceDisplayName;
    }

    public String getSourceSiteUrl() {
        return sourceSiteUrl;
    }

    public void setSourceSiteUrl(String sourceSiteUrl) {
        this.sourceSiteUrl = sourceSiteUrl;
    }

    public String getSourceRecipeUrl() {
        return sourceRecipeUrl;
    }

    public void setSourceRecipeUrl(String sourceRecipeUrl) {
        this.sourceRecipeUrl = sourceRecipeUrl;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("sourceDisplayName", sourceDisplayName).append("sourceSiteUrl", sourceSiteUrl).append("sourceRecipeUrl", sourceRecipeUrl).toString();
    }

}
