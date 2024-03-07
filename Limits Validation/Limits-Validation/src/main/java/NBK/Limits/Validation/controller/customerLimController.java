package NBK.Limits.Validation.controller;


import NBK.Limits.Validation.dto.customerLimDto;
import NBK.Limits.Validation.service.customerLimServ;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

//create rest API for customer limit serv
@RestController
@RequestMapping("/customer limits") //url for API to define this customerlimits controller class
public class customerLimController {

    private customerLimServ customerLimServ;

    public customerLimController(NBK.Limits.Validation.service.customerLimServ customerLimServ) {
        this.customerLimServ = customerLimServ;
    }


    //insert customer limits  record
    @PostMapping("/add ")
    public ResponseEntity<customerLimDto> addcustomerlimits(@RequestBody customerLimDto customerLimDto) {
        // the RequestBody will map the request to the object
        return new ResponseEntity<>(customerLimServ.createcustomerLim(customerLimDto), HttpStatus.CREATED);


    }


    //get customer API
    @GetMapping("/get by id/{id}")
    public ResponseEntity<customerLimDto> getcustomerlimbyid(@PathVariable long id) {
        customerLimDto customerLimDto = customerLimServ.getcustomerlimbyid(id);
        return ResponseEntity.ok(customerLimDto);


    }
}