package co.com.bancolombia.usermanagment.configuration;

import co.com.bancolombia.usermanagment.dto.UserDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class DummyConfig {

    private List<UserDTO> dummyUsersList;

    @Bean
    protected List<UserDTO> getDummyUsersList() {
        dummyUsersList = new ArrayList<>();
        dummyUsersList.add(UserDTO.builder()
                .id(1).name("Fernando").lastName("Hernandez").user("nerfo").pass("Clave123*").build());
        dummyUsersList.add(UserDTO.builder()
                .id(2).name("Laura").lastName("Mahecha").user("stepha").pass("Clave123*").build());
        return dummyUsersList;
    }
}
