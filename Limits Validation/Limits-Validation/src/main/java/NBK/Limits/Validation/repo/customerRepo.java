package NBK.Limits.Validation.repo;
import NBK.Limits.Validation.model.customer;
import org.springframework.data.jpa.repository.JpaRepository;


//to get all DB methods to operate it in  customer limits entity
public interface customerRepo extends JpaRepository<customer,Long>{


}
