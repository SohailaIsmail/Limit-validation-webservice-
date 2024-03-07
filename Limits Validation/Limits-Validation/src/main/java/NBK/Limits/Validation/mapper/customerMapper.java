package NBK.Limits.Validation.mapper;

import NBK.Limits.Validation.dto.customerDto;
import NBK.Limits.Validation.model.customer;

public class customerMapper {
    public static customer maptocustomer (customerDto customerDto){

        customer customer= new customer(
                //convert object == dto into DB
                customerDto.getId(),
                customerDto.getFirstname()
        );

        return customer;
    }

    public static customerDto maptocustomerDto(customer customer){
        customerDto customerDto=new customerDto(
                //convert DB into object == dto
                customer.getId(),
                customer.getFirstname()
        );
        return customerDto;
    }






}


