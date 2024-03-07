package NBK.Limits.Validation.controller;

import NBK.Limits.Validation.dto.customerLimDto;
import NBK.Limits.Validation.service.customerLimServ;
import NBK.Limits.Validation.service.updateCustomerlimitsServ;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

//-------->>>>>> Control Customer Limit table by check channel <<--------------\\
@RestController
@RequestMapping("/update limits ") //url for API to define this customerlimits controller class
public class updateCustomerlimitsController {

    private updateCustomerlimitsServ updateCustomerlimitsServ;


    public updateCustomerlimitsController(NBK.Limits.Validation.service.updateCustomerlimitsServ updateCustomerlimitsServ) {
        this.updateCustomerlimitsServ = updateCustomerlimitsServ;
    }

    //method to update daily limit
        @PutMapping("/daily to id/{id}/{channel}")
        public ResponseEntity<customerLimDto> upadteDailylim(@PathVariable int id,
                                                             @PathVariable String channel,
                                                             @RequestBody Map<String, Double> request) {

            double amount = request.get("amount");
            customerLimDto customerLimDto = updateCustomerlimitsServ.upadteDailylim(id, channel, amount);
            return ResponseEntity.ok(customerLimDto);
        }


        //method to update weekly limit
        @PutMapping("/weekly to id/{id}/{channel}")
        public ResponseEntity<customerLimDto> upadteweeklylim(@PathVariable int id,
                                                              @PathVariable String channel,
                                                              @RequestBody Map<String, Double> request) {

            double amount = request.get("amount");
            customerLimDto customerLimDto = updateCustomerlimitsServ.upadteweeklylim(id, channel, amount);
            return ResponseEntity.ok(customerLimDto);
        }

        //method to update monthly limit
        @PutMapping("/monthly to id/{id}/{channel}")
        public ResponseEntity<customerLimDto> upadtemonthlylim(@PathVariable int id,
                                                               @PathVariable String channel,
                                                               @RequestBody Map<String, Double> request) {

            double amount = request.get("amount");
            customerLimDto customerLimDto = updateCustomerlimitsServ.upadtemonthlylim(id, channel, amount);
            return ResponseEntity.ok(customerLimDto);
        }
    }
