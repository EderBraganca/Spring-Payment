package com.simplePayment.simplePayment.services;

import com.simplePayment.simplePayment.domain.user.User;
import com.simplePayment.simplePayment.domain.user.UserType;
import com.simplePayment.simplePayment.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void validationTransaction(User sender, BigDecimal amount) throws Exception {
        if(sender.getUserType() == UserType.MERCHANT){
            throw new Exception("O usuário do tipo lojista não está autorizado a realizar transações.");
        }

        if(sender.getBalance().compareTo(amount) < 0){
            throw new Exception("O usuário não possui saldo suficiente!");
        }
    }
    public User findUserById(Long id) throws Exception {
        return this.userRepository.findUserById(id).orElseThrow(() -> new Exception("Usuário não encontrado."));
    }

    public void saveUser(User user){
        this.userRepository.save(user);
    }

}
