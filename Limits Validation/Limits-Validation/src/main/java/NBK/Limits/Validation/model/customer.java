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
@Table(name = "customers")
@Entity
public class customer {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
@Column(name = "first_name")
    private String firstname;

}
