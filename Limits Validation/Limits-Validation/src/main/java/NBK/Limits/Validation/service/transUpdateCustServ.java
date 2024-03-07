package NBK.Limits.Validation.service;

import NBK.Limits.Validation.dto.customerLimDto;


//--->>>>>service(interface) class where all methods here and waiting to implementing <<<<<--------//
public interface transUpdateCustServ {
    customerLimDto upadteDaily(long id, int daynum, double amount);
    customerLimDto upadteWeekly(long id, int daynum, double amount);
    customerLimDto upadteMonthly(long id, int daynum, double amount);

}
