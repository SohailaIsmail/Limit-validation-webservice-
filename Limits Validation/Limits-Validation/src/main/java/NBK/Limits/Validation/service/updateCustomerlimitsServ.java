package NBK.Limits.Validation.service;

import NBK.Limits.Validation.dto.customerLimDto;
//--->>>>>service(interface) class where all methods here and waiting to implementing <<<<<--------//
//API will call service layer
public interface updateCustomerlimitsServ {

    customerLimDto upadteDailylim(long id, String channel, double amount);
    customerLimDto upadteweeklylim(long id, String channel, double amount);
    customerLimDto upadtemonthlylim(long id, String channel, double amount);

}
