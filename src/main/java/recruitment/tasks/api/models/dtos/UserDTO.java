package recruitment.tasks.api.models.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import recruitment.tasks.api.models.User;

import java.util.List;

@Data
@NoArgsConstructor
public class UserDTO {

    @JsonProperty("user")
    User user;

    @JsonIgnore
    List<User> users;

    public UserDTO(User user) {
        this.user = user;
    }
}
