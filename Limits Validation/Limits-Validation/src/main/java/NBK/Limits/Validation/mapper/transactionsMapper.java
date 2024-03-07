package NBK.Limits.Validation.mapper;

import NBK.Limits.Validation.dto.transactionsDto;
import NBK.Limits.Validation.model.transactions;

public class transactionsMapper {

    public static transactions maptotransactions (transactionsDto transactionsDto){

        transactions transactions=new transactions(
                //convert object == dto into DB
                transactionsDto.getId(),
                transactionsDto.getChannelid(),
                transactionsDto.getAmount(),
                transactionsDto.getCurrency(),
                transactionsDto.getTransactionDate()
         );
        return transactions;
        }

        public static transactionsDto maptotransactionsDto(transactions transactions){
        transactionsDto transactionsDto=new transactionsDto(
                //convert DB into object == dto
                transactions.getId(),
                transactions.getChannelid(),
                transactions.getAmount(),
                transactions.getCurrency(),
                transactions.getTransactionDate()

        );
        return transactionsDto;
        }



}
