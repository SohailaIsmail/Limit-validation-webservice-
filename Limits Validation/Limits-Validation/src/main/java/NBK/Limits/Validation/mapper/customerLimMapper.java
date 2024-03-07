package NBK.Limits.Validation.mapper;

import NBK.Limits.Validation.dto.customerLimDto;
import NBK.Limits.Validation.model.customerlimits;

public class customerLimMapper {
    // to convert dto to entity
    public static customerlimits mapTocustomerlimits (customerLimDto customerLimDto){

        customerlimits customerlimits = new  customerlimits(

                customerLimDto.getId(),
                customerLimDto.getChannel(),
                customerLimDto.getCurrent_daily_txn(),
                customerLimDto.getCurrent_weekly_txn(),
                customerLimDto.getCurrent_monthly_txn()
        ); // now  i return customer object to db
        return customerlimits;

    }


    // to convert entity to  dto

    public static customerLimDto maptocustomerLimDto (customerlimits customerlimits){
        // send values to dto constructor
        customerLimDto customerLimDto = new customerLimDto(
                customerlimits.getId(),
                customerlimits.getChannel(),
                customerlimits.getCurrent_daily_txn(),
                customerlimits.getCurrent_weekly_txn(),
                customerlimits.getCurrent_monthly_txn()
        );
        return customerLimDto;

    }




}
