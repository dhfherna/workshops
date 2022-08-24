package co.com.bancolombia.usermanagment.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class UserDTO extends AuthDTO {

    private Integer id;
    private String name;
    private String lastName;
}
