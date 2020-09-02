package com.takoit.utils.lss.request;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "setOfStrings"
})
public class LCSRequest {

    @JsonProperty("setOfStrings")
    private List<SetOfString> setOfStrings = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<>();

    @JsonProperty("setOfStrings")
    public List<SetOfString> getSetOfStrings() {
        return setOfStrings;
    }

    @JsonProperty("setOfStrings")
    public void setSetOfStrings(List<SetOfString> setOfStrings) {
        this.setOfStrings = setOfStrings;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
