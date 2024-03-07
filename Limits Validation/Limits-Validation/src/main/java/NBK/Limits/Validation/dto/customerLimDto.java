package NBK.Limits.Validation.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/*used to encapsulate data transferred between
 the controller and service layers,
 or between the service layer and the persistence layer. */
@Data
@AllArgsConstructor
public class customerLimDto {

    private long id;
    private String channel;
    private int current_daily_txn;
    private int current_weekly_txn;
    private int current_monthly_txn;
}
