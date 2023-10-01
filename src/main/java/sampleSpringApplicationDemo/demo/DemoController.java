package sampleSpringApplicationDemo.demo;

import com.java.dto.FlightBookingAcknowledgement;
import com.java.dto.FlightBookingRequest;
import com.java.service.FightBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.*;

@RestController
@EnableTransactionManagement
public class DemoController {

    @Autowired
    private FightBookingService fightBookingService;

    @RequestMapping
    public String defaultMethod(){
        return "Welcome to SpringBoot Demo";

    }
    @PostMapping(value ="/flight")
    public FlightBookingAcknowledgement bookFlightTicket(@RequestBody FlightBookingRequest request){
        return fightBookingService.bookFlightTicket(request);
    }
}
