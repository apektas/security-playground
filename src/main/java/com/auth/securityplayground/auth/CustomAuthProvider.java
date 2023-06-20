package com.auth.securityplayground.auth;

import com.auth.securityplayground.models.Authority;
import com.auth.securityplayground.models.Customer;
import com.auth.securityplayground.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
@AllArgsConstructor
public class CustomAuthProvider implements AuthenticationProvider {

    CustomerRepository customerRepository;
    PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String username = authentication.getName();
        String pwd = authentication.getCredentials().toString();

        List<Customer> customers = customerRepository.findByEmail(username);

        if (customers.size() == 0) {
            throw new BadCredentialsException("No user registered with this details");
        }

        Customer customer = customers.get(0);

        if(!passwordEncoder.matches(pwd, customer.getPwd())){
            throw new BadCredentialsException("Invalid password");
        }

        // After successful authentication ProviderManager clear the credentials from Authentication object
        // using eraseCredentials() method
        return new UsernamePasswordAuthenticationToken(username, pwd, loadGrantedAuthorities(customer.getAuthorities()));
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
    }



    private List<GrantedAuthority> loadGrantedAuthorities(Collection<Authority> authoritySet){
        List<GrantedAuthority> authorities = new ArrayList<>();

        for (Authority authority: authoritySet){
            authorities.add(new SimpleGrantedAuthority(authority.getName()));
        }
        return authorities;
    }
}
