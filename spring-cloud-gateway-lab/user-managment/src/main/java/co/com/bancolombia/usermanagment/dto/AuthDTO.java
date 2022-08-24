package co.com.bancolombia.usermanagment.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class AuthDTO {

    private String user;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String pass;
}
