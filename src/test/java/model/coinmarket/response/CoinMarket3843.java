package model.coinmarket.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CoinMarket3843
{
    @JsonProperty("symbol")
    private String symbol;

    @JsonProperty("self_reported_tags")
    private String selfReportedTags;

    @JsonProperty("tag-groups")
    private String tagGroups;

    @JsonProperty("twitter_username")
    private String twitterUsername;

    @JsonProperty("is_hidden")
    private int isHidden;

    @JsonProperty("description")
    private String description;

    @JsonProperty("date_added")
    private String dateAdded;

    @JsonProperty("logo")
    private String logo;


}