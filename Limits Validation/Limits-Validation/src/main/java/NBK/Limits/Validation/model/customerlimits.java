package NBK.Limits.Validation.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "customer_limits")
@Entity
public class customerlimits {


    @Id
    private long id;

    @Column(nullable = false)
    private String channel;

    @Column(nullable = false)
    private int current_daily_txn;

    @Column(nullable = false)
    private int current_weekly_txn;

    @Column(nullable = false)
    private int current_monthly_txn;

}

