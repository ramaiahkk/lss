package com.takoit.utils.lss.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "lcs"
})
public class LCSResponse {
    @JsonProperty("lcs")
    @Setter
    @Getter
    private List<LSValue> lcs;
}
