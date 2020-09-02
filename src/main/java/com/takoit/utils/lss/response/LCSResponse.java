package com.takoit.utils.lss.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import java.util.List;
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "lcs"
})
public class LCSResponse {
    public List<LSValue> getLcs() {
        return lcs;
    }

    public void setLcs(List<LSValue> lcs) {
        this.lcs = lcs;
    }
    @JsonProperty("lcs")
    private List<LSValue> lcs;
}
