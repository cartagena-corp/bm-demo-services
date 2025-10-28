package com.demo.demo.security;

import com.demo.demo.db.domain.User;
import com.demo.demo.db.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String numeroDocumento) throws UsernameNotFoundException {
        try {
            long docNumber = Long.parseLong(numeroDocumento);
            User user = userRepository.findByNumeroDocumento(docNumber);
            if (user == null) {
                throw new UsernameNotFoundException("Usuario no encontrado con documento: " + numeroDocumento);
            }
            return new CustomUserDetails(user);
        } catch (NumberFormatException e) {
            throw new UsernameNotFoundException("El documento debe ser un número: " + numeroDocumento);
        }
    }
}
