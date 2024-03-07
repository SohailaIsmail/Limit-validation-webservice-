package NBK.Limits.Validation.service.imp;

import NBK.Limits.Validation.dto.customerDto;
import NBK.Limits.Validation.mapper.customerMapper;
import NBK.Limits.Validation.model.customer;
import NBK.Limits.Validation.repo.customerRepo;
import NBK.Limits.Validation.service.customerServ;
import org.springframework.stereotype.Service;

@Service
public class customerservimp implements customerServ {

    private customerRepo customerRepo; //injection elly hwa h5leh ekbary y use it

    public customerservimp(NBK.Limits.Validation.repo.customerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }


    @Override  //  to insert
    public customerDto createcustomer(customerDto customerdto) {

        customer  customer= customerMapper.maptocustomer(customerdto);
        customer savedcustomer=customerRepo.save(customer);
        return  customerMapper.maptocustomerDto(savedcustomer);
        // it will call customerrepo to save customer to DB


    }
}


