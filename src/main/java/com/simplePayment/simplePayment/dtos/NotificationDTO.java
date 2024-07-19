package com.simplePayment.simplePayment.dtos;

import com.simplePayment.simplePayment.domain.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

public record NotificationDTO(String email, String message) {

}
