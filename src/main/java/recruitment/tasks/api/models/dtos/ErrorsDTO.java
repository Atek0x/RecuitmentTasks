package recruitment.tasks.api.models.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import recruitment.tasks.api.models.Errors;

@Data
@NoArgsConstructor
public class ErrorsDTO {

    @JsonProperty("errors")
    Errors errors;

    public ErrorsDTO(Errors errors) {
        this.errors = errors;
    }
}
