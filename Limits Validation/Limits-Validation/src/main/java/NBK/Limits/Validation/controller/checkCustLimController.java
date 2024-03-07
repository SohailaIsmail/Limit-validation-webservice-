package NBK.Limits.Validation.controller;

import NBK.Limits.Validation.dto.customerLimDto;
import NBK.Limits.Validation.service.checkCustomerLimitServ;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

//-------->>>>>> Controller for Checking Customer Limit table <<--------------\\
@RestController
@RequestMapping("/check customer limits") //url for API to define this customerlimits controller class
public class checkCustLimController {



    private checkCustomerLimitServ checkCustomerLimitServ;

    public checkCustLimController(checkCustomerLimitServ checkCustomerLimitServ) {
        this.checkCustomerLimitServ = checkCustomerLimitServ;
    }

    //check all limits
        @PutMapping("/{id}/{channel}")
        public ResponseEntity<String> checklimits(@PathVariable int id,
                                                  @PathVariable String channel,
                                                  @RequestBody Map<String, Double> request) {


            double amount = request.get("amount");
            String customerLimDto = checkCustomerLimitServ.checklimits(id, channel, amount);
            return ResponseEntity.ok(customerLimDto);


        }
    //------->>>>>checking and add the amount<<<<<<<-------------\\



        // check daily limits
    @PutMapping ("/daily for id/{id}/{channel}")
        public ResponseEntity<customerLimDto>checkdailylimits(@PathVariable int id,
                                                              @PathVariable String channel,
                                                              @RequestBody Map<String,Double> request ){


            double amount = Double.parseDouble(String.valueOf(request.get("amount")));

            customerLimDto customerLimDto= checkCustomerLimitServ.checkdailylimits(id, channel, amount);
            return ResponseEntity.ok(customerLimDto);

    }


        // check weekly limits
    @PutMapping ("/weekly for id/{id}/{channel}")
    public ResponseEntity<customerLimDto>checkweeklylimits(@PathVariable int id,
                                                             @PathVariable String channel,
                                                             @RequestBody Map<String,Double> request ) {
        double amount = request.get("amount");

        customerLimDto customerLimDto = checkCustomerLimitServ.checkweeklylimits(id, channel, amount);
        return ResponseEntity.ok(customerLimDto);

    }




    // check monthly limits
    @PutMapping ("/monthly for id/{id}/{channel}")
    public ResponseEntity<customerLimDto>checkmonthlyylimits(@PathVariable int id,
                                                             @PathVariable String channel,
                                                             @RequestBody Map<String,Double> request ) {
        double amount = request.get("amount");

        customerLimDto customerLimDto = checkCustomerLimitServ.checkmonthlylimits(id, channel, amount);
        return ResponseEntity.ok(customerLimDto);
    }

}