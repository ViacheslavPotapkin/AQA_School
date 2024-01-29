package response;

import com.google.gson.Gson;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(fluent = true)
@NoArgsConstructor
@EqualsAndHashCode
public class DogResponse {
    private String message;
    private String status;

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
