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
public class CoinMarketStatus
{
    @JsonProperty("error_message")
    private String errorMessaqe;

    @JsonProperty("elapsed")
    private int elapsed;

    @JsonProperty("credit_count")
    private int creditCount;

    @JsonProperty("error_code")
    private int errorCode;

    @JsonProperty("timestamp")
    private String timestamp;

    @JsonProperty("notice")
    private String notice;


}