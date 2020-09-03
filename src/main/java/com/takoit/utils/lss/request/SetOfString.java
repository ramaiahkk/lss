package com.takoit.utils.lss.request;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "value"
})
@Validated
@NoArgsConstructor
@AllArgsConstructor
public class SetOfString {

    @JsonProperty("value")
    @Getter
    @Setter
    @NotNull(message = "Can 't be null")
    @NotEmpty(message = "Can 't be Empty")
    @NotBlank(message = "Can 't be Blank")
    @Length(min = 2, message = "Can 't be Min")
    @Size(min = 2,message = "Can 't be Min")
    private String value;
}
