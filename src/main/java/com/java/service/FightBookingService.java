package com.java.service;

import com.java.dto.FlightBookingAcknowledgement;
import com.java.dto.FlightBookingRequest;
import com.java.entity.PassengerInfo;
import com.java.entity.PaymentInfo;
import com.java.repository.PassengerInfoRepository;
import com.java.repository.PaymentInfoRepository;
import com.java.utils.PaymentUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

@Service
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FightBookingService {

    @Autowired
    private PassengerInfoRepository passengerInfoRepository;

    @Autowired
    private PaymentInfoRepository paymentInfoRepository;

    @Transactional
    public FlightBookingAcknowledgement bookFlightTicket(FlightBookingRequest request){


        PassengerInfo passengerInfo = request.getPassengerInfo();;
        passengerInfo = passengerInfoRepository.save(passengerInfo);

        PaymentInfo paymentInfo = request.getPaymentInfo();

        PaymentUtils.validateCredentials(paymentInfo.getAccountNo(),passengerInfo.getFare());

        paymentInfo.setPassengerId(passengerInfo.getPId());
        paymentInfo.setAmount(passengerInfo.getFare());

        paymentInfoRepository.save(paymentInfo);

        return new FlightBookingAcknowledgement("Success",passengerInfo.getFare(), UUID.randomUUID().toString().split("-")[0],passengerInfo);

    }
}
