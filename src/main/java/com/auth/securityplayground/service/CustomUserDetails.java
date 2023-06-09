package com.auth.securityplayground.service;

import com.auth.securityplayground.models.Customer;
import com.auth.securityplayground.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CustomUserDetails implements UserDetailsService {

    CustomerRepository customerRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        List<GrantedAuthority> authorityList = new ArrayList<>();
        List<Customer> customers = customerRepository.findByEmail(username);

        if (customers.size() == 0)
            throw new UsernameNotFoundException("User not found: "  + username);

        // actual user
        Customer user = customers.get(0);
        authorityList.add(new SimpleGrantedAuthority(user.getRole()));
        return new User(user.getEmail(), user.getPwd(), authorityList);
    }
}
