package NBK.Limits.Validation.service.imp;

import NBK.Limits.Validation.dto.customerLimDto;
import NBK.Limits.Validation.mapper.customerLimMapper;
import NBK.Limits.Validation.model.customerlimits;
import NBK.Limits.Validation.repo.customerLimRepo;
import NBK.Limits.Validation.service.customerLimServ;
import NBK.Limits.Validation.service.updateCustomerlimitsServ;
import org.springframework.stereotype.Service;



//-->>>>>> Implementing the service that Update Customer Limit table by check channel <<--------------\\
@Service
public class updateCustomerlimitsServImp implements updateCustomerlimitsServ {
        private customerLimRepo customerLimRepo;  //dependency injection to inject this account dependency

    public updateCustomerlimitsServImp(NBK.Limits.Validation.repo.customerLimRepo customerLimRepo) {
        this.customerLimRepo = customerLimRepo;
    }

      //to update customer daily limit
        @Override
        public customerLimDto upadteDailylim(long id, String channel, double amount) {

            customerlimits customerlimits = customerLimRepo.findById(id).orElseThrow(() ->
                    new RuntimeException("The user isn't exist"));//check if id is existing or not

            if (!"IPN".equals(channel)){

                throw new RuntimeException("not IPN channel");

            }
            double total = customerlimits.getCurrent_daily_txn() + amount;
            customerlimits.setCurrent_daily_txn((int) total);
            customerlimits updated =customerLimRepo.save(customerlimits);
            return customerLimMapper.maptocustomerLimDto(updated);

        }



     //to update customer weekly limit
        @Override
        public customerLimDto upadteweeklylim(long id, String channel, double amount) {

            customerlimits customerlimits = customerLimRepo.findById(id).orElseThrow(() ->
                    new RuntimeException("The user isn't exist"));//check if id is existing or not

            double total = customerlimits.getCurrent_weekly_txn() + amount;
            customerlimits.setCurrent_weekly_txn((int) total);
            customerlimits updated =customerLimRepo.save(customerlimits);
            return customerLimMapper.maptocustomerLimDto(updated);

        }


        //to update customer monthly limit
        @Override
        public customerLimDto upadtemonthlylim(long id, String channel, double amount) {

            customerlimits customerlimits = customerLimRepo.findById(id).orElseThrow(() ->
                    new RuntimeException("The user isn't exist"));//check if id is existing or not

            double total = customerlimits.getCurrent_monthly_txn() + amount;
            customerlimits.setCurrent_monthly_txn((int) total);
            customerlimits updated =customerLimRepo.save(customerlimits);
            return customerLimMapper.maptocustomerLimDto(updated);

        }
    }
