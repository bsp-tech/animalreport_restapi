package com.company.imtahan.service;

import com.company.imtahan.entities.User;
import com.company.imtahan.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("userDetailsService")
public class CustomUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepo.findByEmail(email);

        if (user != null) {
            String[] authoritiesArr = new String[]{ user.getRoleId().getName().toUpperCase()};

            return new CustomUserDetails(
                    user.getEmail(),
                    user.getPassword(),
                    true,
                    AuthorityUtils.createAuthorityList(authoritiesArr),
                    user
            );
        } else {
            throw new UsernameNotFoundException("User not found.");
        }

    }
}
