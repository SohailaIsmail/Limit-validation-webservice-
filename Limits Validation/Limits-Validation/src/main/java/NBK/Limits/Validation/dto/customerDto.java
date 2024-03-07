package NBK.Limits.Validation.dto;

import lombok.AllArgsConstructor;
import lombok.Data;


/*used to encapsulate data transferred between
 the controller and service layers,
 or between the service layer and the persistence layer. */
@Data //to import setters and getters
@AllArgsConstructor
public class customerDto {

    private long id;
    private String firstname;

}