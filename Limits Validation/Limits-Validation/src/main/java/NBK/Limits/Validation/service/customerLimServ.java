package NBK.Limits.Validation.service;

import NBK.Limits.Validation.dto.customerLimDto;

//--->>>>>service(interface) class where all methods here and waiting to implementing <<<<<--------//
//API will call service layer
public interface customerLimServ {

    customerLimDto createcustomerLim (customerLimDto customerLimitDto); //to connect service with repo and model
    customerLimDto getcustomerlimbyid(long id);


    }

