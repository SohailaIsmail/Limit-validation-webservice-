package NBK.Limits.Validation.service.imp;
import NBK.Limits.Validation.dto.customerLimDto;
import NBK.Limits.Validation.mapper.customerLimMapper;
import NBK.Limits.Validation.model.customerlimits;
import NBK.Limits.Validation.repo.customerLimRepo;
import NBK.Limits.Validation.service.customerLimServ;
import org.springframework.stereotype.Service;


@Service
public class customerlimserimp implements  customerLimServ {

    private customerLimRepo customerLimRepo;  //dependency injection to inject this account dependency

    public customerlimserimp(NBK.Limits.Validation.repo.customerLimRepo customerLimRepo) {
        this.customerLimRepo = customerLimRepo;
    }


    @Override //to insert
    public customerLimDto createcustomerLim(customerLimDto customerLimitDto) {
        customerlimits customerlimits= customerLimMapper.mapTocustomerlimits(customerLimitDto);
        customerlimits savedcustomerlimits =customerLimRepo.save(customerlimits);
        return customerLimMapper.maptocustomerLimDto(savedcustomerlimits);// it will call customerrepo to save customer to DB
    }

    @Override //to show record
    public customerLimDto getcustomerlimbyid(long id) {

            customerlimits customerlimits = customerLimRepo.findById(id).orElseThrow(() ->
                    new RuntimeException("The user isn't exist"));//check if id is existing or not

            return customerLimMapper.maptocustomerLimDto(customerlimits);

        }



}













