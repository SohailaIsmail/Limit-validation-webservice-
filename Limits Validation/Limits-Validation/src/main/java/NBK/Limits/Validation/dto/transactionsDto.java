package NBK.Limits.Validation.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;


/*used to encapsulate data transferred between
 the controller and service layers,
 or between the service layer and the persistence layer. */
@Data
@AllArgsConstructor
public class transactionsDto {

    private long id;
    private String channelid;
    private int amount;
    private String currency;
    private LocalDateTime transactionDate;

}
