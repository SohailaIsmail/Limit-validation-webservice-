package NBK.Limits.Validation.service;
import NBK.Limits.Validation.dto.customerLimDto;

//--->>>>>service(interface) class where all methods here and waiting to implementing <<<<<--------//
//API will call service layer



public interface checkCustomerLimitServ {


    //check all limits
    String checklimits(long id, String channel, double amount);



    //check daily
    customerLimDto checkdailylimits(long id, String channel , double amount);


    //check weekly
    customerLimDto checkweeklylimits(long id, String channel ,double amount);

    //check monthly
    customerLimDto checkmonthlylimits(long id, String channel ,double amount);


}
