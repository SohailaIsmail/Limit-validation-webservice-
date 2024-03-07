package NBK.Limits.Validation.controller;


import NBK.Limits.Validation.dto.customerLimDto;
import NBK.Limits.Validation.service.transUpdateCustServ;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

//-------->>>>>> Control Customer Limit table by check channel <<--------------\\

@RestController
@RequestMapping("/update limit for") //url for API to define this customerlimits controller class
public class transUpdateCustController {

    private transUpdateCustServ transUpdateCustServ;

    public transUpdateCustController(NBK.Limits.Validation.service.transUpdateCustServ transUpdateCustServ) {
        this.transUpdateCustServ = transUpdateCustServ;
    }




    //method to update daily limit with transaction date
    @PutMapping("/daily by id/{id}/{daynum}")
    public ResponseEntity<customerLimDto> upadteDaily(@PathVariable int id,
                                                         @PathVariable  int daynum,
                                                         @RequestBody Map<String, Double> request) {

        double amount = request.get("amount");
        customerLimDto customerLimDto = transUpdateCustServ.upadteDaily(id, daynum, amount);
        return ResponseEntity.ok(customerLimDto);
    }






    //method to update weekly limit with transaction date
    @PutMapping("/weekly by id/{id}/{daynum}")
    public ResponseEntity<customerLimDto> upadteWeekly(@PathVariable int id,
                                                      @PathVariable  int daynum,
                                                      @RequestBody Map<String, Double> request) {

        double amount = request.get("amount");
        customerLimDto customerLimDto = transUpdateCustServ.upadteWeekly(id, daynum, amount);
        return ResponseEntity.ok(customerLimDto);
    }




    //method to update monthly limit with transaction date
    @PutMapping("/monthly by id/{id}/{daynum}")
    public ResponseEntity<customerLimDto> upadteMonthly(@PathVariable int id,
                                                      @PathVariable  int daynum,
                                                      @RequestBody Map<String, Double> request) {

        double amount = request.get("amount");
        customerLimDto customerLimDto = transUpdateCustServ.upadteMonthly(id, daynum, amount);
        return ResponseEntity.ok(customerLimDto);
    }


}
