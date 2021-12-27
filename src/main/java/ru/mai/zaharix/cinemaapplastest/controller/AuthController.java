package ru.mai.zaharix.cinemaapplastest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import ru.mai.zaharix.cinemaapplastest.entities.Customer;
import ru.mai.zaharix.cinemaapplastest.repositories.CustomerRepo;
import ru.mai.zaharix.cinemaapplastest.security.core.CustomerDetails;
import ru.mai.zaharix.cinemaapplastest.security.jwt.JwtProvider;
import ru.mai.zaharix.cinemaapplastest.security.payload.request.AuthRequest;
import ru.mai.zaharix.cinemaapplastest.security.payload.request.RegistrationRequest;
import ru.mai.zaharix.cinemaapplastest.security.payload.response.AuthResponse;
import ru.mai.zaharix.cinemaapplastest.security.payload.response.MessageResponse;
import ru.mai.zaharix.cinemaapplastest.service.impl.CustomerServiceImpl;

import javax.validation.Valid;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    private CustomerServiceImpl customerService;

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private JwtProvider jwtProvider;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/signup")
    public ResponseEntity<?> registerCustomer(@RequestBody @Valid RegistrationRequest registrationRequest) {
        if (customerRepo.existsByEmail(registrationRequest.getEmail())) {
            return ResponseEntity.badRequest().body(new MessageResponse("User is already created!"));
        }
        Customer customer = new Customer();
        customer.setName(registrationRequest.getName());
        customer.setSurname(registrationRequest.getSurname());
        customer.setEmail(registrationRequest.getEmail());
        customer.setRole(registrationRequest.getRole());
        customer.setPassword(passwordEncoder.encode(registrationRequest.getPassword()));
        customerService.addNewCustomer(customer);
        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }

    @PostMapping("/signin")
    public ResponseEntity<?> auth(@Valid @RequestBody AuthRequest authRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authRequest.getLogin(), authRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtProvider.generateToken(authentication);

        CustomerDetails customerDetails = (CustomerDetails) authentication.getPrincipal();

        String role = customerDetails.getAuthorities().toString()
                .replace("[", "").replace("]", "");

        return ResponseEntity.ok(new AuthResponse(token,
                customerDetails.getName(),
                customerDetails.getSurname(),
                customerDetails.getUsername(),
                role));
    }

//    @GetMapping("/user")
//    public ResponseEntity<Customer> getCustomer() {
//
//    }

}
