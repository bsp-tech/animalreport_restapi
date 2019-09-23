/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.imtahan.security;

import com.company.imtahan.entities.User;
import com.company.imtahan.projections.UserProjection;
import com.company.imtahan.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

/**
 *
 * @author sarkhanrasullu
 */
@Component
public class SecurityUtil {

    @Autowired
    private UserRepository userRepo;
    
    public boolean hasAuthority(String authority) {
        return loggedInUser().getRoleId().getName().equals(authority.toUpperCase());
    }

    public UserProjection loggedInUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null) {
            return null;
        }//org.springframework.security.oauth2.provider.OAuth2Authentication

//        OAuth2Authentication auth = (OAuth2Authentication) authentication;
        UserProjection user = userRepo.getByEmail(authentication.getPrincipal().toString());
        return user;
    }
    
    public User loggedInUserEntity(){
          UserProjection userProjection = loggedInUser();
          if(userProjection!=null){
              return userRepo.getOne(userProjection.getId());
          }
          return null;
    }

//    public static String logout(HttpServletRequest request, HttpServletResponse response) {
//        CookieClearingLogoutHandler cookieClearingLogoutHandler = new CookieClearingLogoutHandler(AbstractRememberMeServices.SPRING_SECURITY_REMEMBER_ME_COOKIE_KEY);
//        SecurityContextLogoutHandler securityContextLogoutHandler = new SecurityContextLogoutHandler();
//        cookieClearingLogoutHandler.logout(request, response, null);
//        securityContextLogoutHandler.logout(request, response, null);
//
//        return "redirect:/login";
//    }
}
