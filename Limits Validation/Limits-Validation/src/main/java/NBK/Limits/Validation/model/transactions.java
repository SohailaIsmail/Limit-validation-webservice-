package NBK.Limits.Validation.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;


import java.time.LocalDateTime;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Transactions")
public class transactions {

    @Id
    private long id;

    @Column(nullable = false)
    private String channelid;

    @Column(nullable = false)
    private int amount;

    @Column(nullable = false)
    private String currency;

    @CreatedDate
    @CreationTimestamp
    @Column(nullable = false)
    private LocalDateTime transactionDate;

}