package NBK.Limits.Validation.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Global_Limits")
public class globalLimits {


    @Id
    private String channelid;

    @Column(nullable = false)
    private int Min_TXN_Limit;

    @Column(nullable = false)
    private int Max_TXN_Limit;

    @Column(nullable = false)
    private int Daily_Limit;

    @Column(nullable = false)
    private int Weekly_Limit;

    @Column(nullable = false)
    private int Monthly_Limit;


    @Column(nullable = false)
    private double debit_limit;

    @Column(nullable = false)
    private double credit_limit;

}
