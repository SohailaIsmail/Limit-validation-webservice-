package NBK.Limits.Validation.dto;

import lombok.Data;

/*used to encapsulate data transferred between
 the controller and service layers,
 or between the service layer and the persistence layer. */
@Data
public class globalLimitsDto {
    private String channelid;
    private int Min_TXN_Limit;
    private int Max_TXN_Limit;
    private int Daily_Limit;
    private int Weekly_Limit;
    private int Monthly_Limit;
    private double debit_limit;
    private double credit_limit;
}
