package NBK.Limits.Validation.service.imp;

import NBK.Limits.Validation.dto.customerLimDto;
import NBK.Limits.Validation.mapper.customerLimMapper;
import NBK.Limits.Validation.model.customerlimits;
import NBK.Limits.Validation.repo.customerLimRepo;
import NBK.Limits.Validation.service.transUpdateCustServ;
import org.springframework.stereotype.Service;

//-------------->>Implement the Trans update customer service<<<<<<-----------\\
//-------------->>by transaction date<<<<<<-----------\\


@Service
public class transUpdateCustServImp implements transUpdateCustServ {

    private customerLimRepo customerLimRepo;   //to inject dependencies

    public transUpdateCustServImp(NBK.Limits.Validation.repo.customerLimRepo customerLimRepo) {
        this.customerLimRepo = customerLimRepo;
    }


            /*  update daily limit based on trans day so if it is the first which is 1
                in the day the limit set to be = amount
                else  adding amount to total*/
    @Override
    public customerLimDto upadteDaily(long id, int daynum, double amount) {
        customerlimits customerlimits = customerLimRepo.findById(id).orElseThrow(() ->
                new RuntimeException("The user isn't exist"));//check if id is existing or not

        if (daynum ==1){

            customerlimits.setCurrent_daily_txn((int) amount);
            customerlimits updated =customerLimRepo.save(customerlimits);
            return customerLimMapper.maptocustomerLimDto(updated);

        }
        else {
            double total = customerlimits.getCurrent_daily_txn() + amount;
            customerlimits.setCurrent_daily_txn((int) total);
            customerlimits updated =customerLimRepo.save(customerlimits);
            return customerLimMapper.maptocustomerLimDto(updated);
        }

    }



    /*  update week limit based on trans day so if it is the first which is 1
    in the week the limit set to be = amount
    else  adding amount to total*/
    @Override
    public customerLimDto upadteWeekly(long id, int daynum, double amount) {
        customerlimits customerlimits = customerLimRepo.findById(id).orElseThrow(() ->
                new RuntimeException("The user isn't exist"));//check if id is existing or not

        if (daynum ==1){
            customerlimits.setCurrent_weekly_txn((int) amount);
            customerlimits updated =customerLimRepo.save(customerlimits);
            return customerLimMapper.maptocustomerLimDto(updated);

        }
        else {
            double total = customerlimits.getCurrent_weekly_txn() + amount;
            customerlimits.setCurrent_weekly_txn((int) total);
            customerlimits updated =customerLimRepo.save(customerlimits);
            return customerLimMapper.maptocustomerLimDto(updated);
        }
    }



            /*  update month limit based on trans day so if it is the first which is 1
                in the month the limit set to be = amount
                else  adding amount to total*/
    @Override
    public customerLimDto upadteMonthly(long id, int daynum, double amount) {
        customerlimits customerlimits = customerLimRepo.findById(id).orElseThrow(() ->
                new RuntimeException("The user isn't exist"));//check if id is existing or not

        if (daynum ==1){
            customerlimits.setCurrent_monthly_txn((int) amount);
            customerlimits updated =customerLimRepo.save(customerlimits);
            return customerLimMapper.maptocustomerLimDto(updated);

        }
        else {
            double total = customerlimits.getCurrent_monthly_txn() + amount;
            customerlimits.setCurrent_monthly_txn((int) total);
            customerlimits updated =customerLimRepo.save(customerlimits);
            return customerLimMapper.maptocustomerLimDto(updated);
        }
    }



}

