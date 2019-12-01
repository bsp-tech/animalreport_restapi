//package com.company.animalreport.service.impl;
//
//
//import com.company.animalreport.bean.CustomUserDetail;
//import com.company.animalreport.entities.User;
//import com.company.animalreport.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Component
//public class CustomUserDetailServiceImpl implements UserDetailsService {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Override
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//
//        User user = userRepository.findByEmailAndEnabled(email, true);
//
//        List<GrantedAuthority> roles = user.getGroupId().getAuthGroupRoleList()
//                .stream()
//                .map(u -> new SimpleGrantedAuthority(u.getRoleId().getName()))
//                .collect(Collectors.toList());
//
//        UserDetails userDetails = new CustomUserDetail(
//                user,
//                user.getEmail(),
//                user.getPassword(),
//                roles);
//
//        return userDetails;
//    }
//}
