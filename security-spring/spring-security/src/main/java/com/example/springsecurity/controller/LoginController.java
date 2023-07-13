package com.example.springsecurity.controller;

import com.example.springsecurity.dto.LoginRequestDto;
import com.example.springsecurity.dto.LoginResponseDto;
import com.example.springsecurity.model.Customer;
import com.example.springsecurity.model.UserDetailsImpl;
import com.example.springsecurity.repository.CustomerRepository;

import com.example.springsecurity.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LoginController {


    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody Customer customer) {
        Customer customer1 = null;
        ResponseEntity response = null;

        try {
            String hashPwd = passwordEncoder.encode(customer.getPwd());
            customer.setPwd(hashPwd);

            customer1 = customerRepository.save(customer);

            if (customer1.getId() > 0) {
                response = ResponseEntity.status(HttpStatus.CREATED).body("Customer successfully registered");
            }

        } catch (Exception ex) {
            response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An exeception occured : " + ex.getMessage());
        }
        return response;
    }


    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> loginUser(@RequestBody LoginRequestDto loginRequestDto) {
        try {
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequestDto.getEmail(), loginRequestDto.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);

            UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

            String email = userDetails.getUsername();

            int index = email.indexOf("@");

            String name = email.substring(0, index);

            String token = jwtUtils.generateJwtToken(authentication);

            String role = userDetails.getAuthorities().toArray()[0].toString().equals("ROLE_ADMIN") ? "Adminstrator" : "Customer";

            return ResponseEntity.ok(LoginResponseDto.builder().token(token).id(userDetails.getId()).name(name).role(role).build());

        } catch (Exception e) {
            throw e;
        }

    }


}
