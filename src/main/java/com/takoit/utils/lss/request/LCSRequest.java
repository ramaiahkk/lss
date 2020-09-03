package com.takoit.utils.lss.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.takoit.utils.lss.validation.ValidateLCS;
import lombok.Getter;
import lombok.Setter;


import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "setOfStrings"
})
public class LCSRequest {

    @JsonProperty("setOfStrings")
    @Getter
    @Setter
    @NotNull(message = "setOfStrings should not be null.")
    @NotEmpty(message = "setOfStrings should not be empty.")
    @Size(min = 2)
    @ValidateLCS(message = "\"setOfStrings\" must be a Set")

    private List<@Valid SetOfString> setOfStrings = null;

}
