package NBK.Limits.Validation.service.imp;

import NBK.Limits.Validation.dto.customerLimDto;
import NBK.Limits.Validation.dto.transactionsDto;
import NBK.Limits.Validation.mapper.customerLimMapper;
import NBK.Limits.Validation.mapper.transactionsMapper;
import NBK.Limits.Validation.model.customerlimits;
import NBK.Limits.Validation.model.transactions;
import NBK.Limits.Validation.repo.transactionsRepo;
import NBK.Limits.Validation.service.transactionsServ;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;

@Service
public class transactionsServImp implements transactionsServ {
    //to inject dependencies
    private transactionsRepo transactionsRepo;

    public transactionsServImp(NBK.Limits.Validation.repo.transactionsRepo transactionsRepo) {
        this.transactionsRepo = transactionsRepo;
    }

    @Override //  to insert
    public transactionsDto createtransaction(transactionsDto transactionsDto) {
        transactions transactions= transactionsMapper.maptotransactions(transactionsDto);{
            transactions savedtrans=transactionsRepo.save(transactions);
            //to save record into dto
            return transactionsMapper.maptotransactionsDto(savedtrans);


        }
    }


}
