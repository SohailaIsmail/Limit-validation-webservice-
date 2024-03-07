package NBK.Limits.Validation.service;

import NBK.Limits.Validation.dto.customerLimDto;
import NBK.Limits.Validation.dto.transactionsDto;
import NBK.Limits.Validation.model.transactions;
import org.mapstruct.Mapper;
//--->>>>>service(interface) class where all methods here and waiting to implementing <<<<<--------//
public interface transactionsServ {


    transactionsDto createtransaction(transactionsDto transactionsDto);

}