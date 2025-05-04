package com.example.dockerdemo.security;

import com.example.dockerdemo.model.Role;
import com.example.dockerdemo.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    // In a real application, this would be replaced with a repository or DAO
    private static final Map<String, User> USERS_DB = new ConcurrentHashMap<>();

    static {
        // Initialize with sample users
        User user = User.builder()
                .id(1L)
                .username("user")
                .email("user@example.com")
                .password("$2a$10$dXJ3SW6G7P50lGmMkkmwe.20cQQubK3.HZWzG3YB1tlRy.fqvM/BG") // "password"
                .roles(Set.of(new Role(1L, "ROLE_USER")))
                .build();

        User admin = User.builder()
                .id(2L)
                .username("admin")
                .email("admin@example.com")
                .password("$2a$10$dXJ3SW6G7P50lGmMkkmwe.20cQQubK3.HZWzG3YB1tlRy.fqvM/BG") // "admin"
                .roles(Set.of(new Role(1L, "ROLE_USER"), new Role(2L, "ROLE_ADMIN")))
                .build();

        USERS_DB.put(user.getUsername(), user);
        USERS_DB.put(admin.getUsername(), admin);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = USERS_DB.get(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        
        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                user.isEnabled(),
                user.isAccountNonExpired(),
                user.isCredentialsNonExpired(),
                user.isAccountNonLocked(),
                getAuthorities(user.getRoles())
        );
    }

    private Collection<? extends GrantedAuthority> getAuthorities(Collection<Role> roles) {
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
    }
}
