package NBK.Limits.Validation.controller;


import NBK.Limits.Validation.dto.customerDto;
import NBK.Limits.Validation.dto.customerLimDto;
import NBK.Limits.Validation.service.customerServ;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


//create rest API for customer serv
@RestController
@RequestMapping("/add customer") //url for API to define this customerlimits controller class
public class customerservController {

     private customerServ customerServ;

    public customerservController(NBK.Limits.Validation.service.customerServ customerServ) {
        this.customerServ = customerServ;
    }



    //add customer  API
    @PostMapping
    public ResponseEntity<customerDto> addcustomer(@RequestBody customerDto customerDto) {
        // the RequestBody will map the request to the object
        return new ResponseEntity<>(customerServ.createcustomer(customerDto), HttpStatus.CREATED);


    }
}
