package NBK.Limits.Validation.repo;

import NBK.Limits.Validation.model.customerlimits;
import org.springframework.data.jpa.repository.JpaRepository;


//to get all DB methods to operate it in  customer limits entity
public interface customerLimRepo extends JpaRepository<customerlimits,Long > {
}
