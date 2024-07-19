package com.simplePayment.simplePayment.dtos;

import com.simplePayment.simplePayment.domain.user.UserType;

import java.math.BigDecimal;

public record UserDTO (String firstName, String lastName, BigDecimal balance, String email, String password, UserType userType) {

}
