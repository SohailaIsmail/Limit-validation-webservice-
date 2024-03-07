package NBK.Limits.Validation.controller;


import NBK.Limits.Validation.dto.transactionsDto;
import NBK.Limits.Validation.service.transactionsServ;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


//create rest API for transaction serv
@RestController
@RequestMapping("/add/transactions")
public class transactionsController {
    private transactionsServ transactionsServ;// to inject the dependancies

    public transactionsController(NBK.Limits.Validation.service.transactionsServ transactionsServ) {
        this.transactionsServ = transactionsServ;
    }


    //insert transaction record
    @PostMapping

    public ResponseEntity<transactionsDto> addtransactions (@RequestBody transactionsDto transactionsDto){
        return new ResponseEntity<>(transactionsServ.createtransaction(transactionsDto), HttpStatus.CREATED);

    }


}
