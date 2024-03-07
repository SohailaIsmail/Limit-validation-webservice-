package NBK.Limits.Validation.service.imp;

import NBK.Limits.Validation.dto.customerLimDto;
import NBK.Limits.Validation.mapper.customerLimMapper;
import NBK.Limits.Validation.model.customerlimits;
import NBK.Limits.Validation.model.globalLimits;
import NBK.Limits.Validation.repo.customerLimRepo;
import NBK.Limits.Validation.service.checkCustomerLimitServ;
import NBK.Limits.Validation.service.customerLimServ;
import org.springframework.stereotype.Service;
    @Service
public class checkCustomerLimitServImp implements checkCustomerLimitServ {


        //dependency injection to inject this account dependency
        private NBK.Limits.Validation.repo.customerLimRepo customerLimRepo;


        public checkCustomerLimitServImp(NBK.Limits.Validation.repo.customerLimRepo customerLimRepo) {
            this.customerLimRepo = customerLimRepo;
        }



        // check all customer limit
        @Override
        public String checklimits(long id, String channel, double amount) {


            customerlimits customerlimits = customerLimRepo.findById(id).orElseThrow(() ->
                    new RuntimeException("The user isn't exist"));//check if id is existing or not



            // I still search how to make channel not manual --> pass channel from table record
            if (channel.equals("IPN")){

                if (customerlimits.getCurrent_daily_txn() < amount//20000
                        ||customerlimits.getCurrent_weekly_txn() < amount
                        || customerlimits.getCurrent_monthly_txn() < amount) {

                    return "Transaction rejected: Transaction limit reached";

                }

                // If the transaction amount does not exceed any limit, return an approval message
                return "Transaction approved";
            }

            return "NOT IPN Channel";

        }

      //------->>>>>checking and add the amount<<<<<<<-------------\\



        // check daily customer limit
      @Override
    public customerLimDto checkdailylimits(long id, String channel, double amount) {
        customerlimits customerlimits = customerLimRepo.findById(id).orElseThrow(() ->
                new RuntimeException("The user isn't exist"));//check if id is existing or not

        if(channel.equals("IPN")){

            if (customerlimits.getCurrent_daily_txn() < amount ){

                throw new RuntimeException("Transaction rejected:TXN limit reached");
            }
        }
        double dremainng = customerlimits.getCurrent_daily_txn() -amount;
        customerlimits.setCurrent_daily_txn((int) dremainng);
        customerlimits savedailylim = customerLimRepo.save(customerlimits);
        return customerLimMapper.maptocustomerLimDto(savedailylim);

    }
//      if(channel.equals("IPN")){
//
//            globalLimits globalLimits = new globalLimits();
//            int total= (int) (customerlimits.getCurrent_daily_txn()+ amount);
//            if (globalLimits.getDaily_Limit() < total ){
//
//                throw new RuntimeException("Transaction rejected:TXN limit reached");
//            }
//        }
//        int total= (int) (customerlimits.getCurrent_daily_txn()+ amount);
//        customerlimits.setCurrent_daily_txn((int) total);
//        customerlimits savedailylim = customerLimRepo.save(customerlimits);
//        return customerLimMapper.maptocustomerLimDto(savedailylim);
//
//    }


        // check weekly customer limit
        @Override
    public customerLimDto checkweeklylimits(long id, String channel,double amount) {
        customerlimits customerlimits = customerLimRepo.findById(id).orElseThrow(() ->
                new RuntimeException("The user isn't exist"));//check if id is existing or not

            if (customerlimits.getCurrent_weekly_txn()< amount ){

                throw new RuntimeException("Transaction rejected:TXN limit reached");
            }

        double wremainng = customerlimits.getCurrent_weekly_txn() -amount;
        customerlimits.setCurrent_weekly_txn((int) wremainng);
        customerlimits saveweeklylim = customerLimRepo.save(customerlimits);
        return customerLimMapper.maptocustomerLimDto(saveweeklylim);

    }



        // check monthly customer limit
        @Override
    public customerLimDto checkmonthlylimits(long id,String channel, double amount) {
        customerlimits customerlimits = customerLimRepo.findById(id).orElseThrow(() ->
                new RuntimeException("The user isn't exist"));//check if id is existing or not

            if (customerlimits.getCurrent_monthly_txn()< amount ){

                throw new RuntimeException("Transaction rejected:TXN limit reached");
            }

        double mremainng = customerlimits.getCurrent_monthly_txn() -amount;
        customerlimits.setCurrent_monthly_txn((int) mremainng);
        customerlimits savemonthlylim = customerLimRepo.save(customerlimits);
        return customerLimMapper.maptocustomerLimDto(savemonthlylim);

    }
}