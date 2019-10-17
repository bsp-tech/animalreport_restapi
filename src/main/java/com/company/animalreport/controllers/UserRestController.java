///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.company.animalreport.controllers;
//
//import com.company.animalreport.entities.User;
//import com.company.animalreport.service.inter.SecurityServiceInter;
//import com.company.animalreport.service.inter.UserServiceInter;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.servlet.ModelAndView;
//
//import javax.validation.Valid;
//
///**
// * @author Goshgar
// */
//
//@RestController
//@RequestMapping(value = "/user")
//public class UserRestController {
//    @Autowired
//    private UserServiceInter userServiceInter;
//
//    @Autowired
//    private SecurityServiceInter securityServiceInter;
//
//    @RequestMapping(path = "/register")
//    public ModelAndView register(ModelAndView modelAndView) {
//        modelAndView.addObject("user", new com.company.animalreport.entities.User());
//        modelAndView.setViewName("user/registration");
//        return modelAndView;
//    }
//
//    @Autowired
//    @Qualifier("pwdEncoder")
//    private PasswordEncoder passwordEncoder;
//
//
//    @RequestMapping(value = "/edit", method = RequestMethod.POST)
//    public ModelAndView editPost(@ModelAttribute @Valid User user, BindingResult result) {
//        if (result.hasErrors()) {
//            ModelAndView mv = new ModelAndView();
//            mv.setViewName("user/edit");
//            return mv;
//        }
//        userServiceInter.update(user);
//        return new ModelAndView("redirect:/user/edit?success");
//    }
//
//    @RequestMapping(path = "/edit")
//    public ModelAndView edit(ModelAndView modelAndView) {
//        com.company.animalreport.entities.User loggedInUser = securityServiceInter.getLoggedInUserDetails().getUser();
//        com.company.animalreport.entities.User user = userServiceInter.findById(loggedInUser.getId());
//        user.setPassword(null);
//        modelAndView.addObject("user", user);
//        modelAndView.setViewName("user/edit");
//        return modelAndView;
//    }
//
//
//    @RequestMapping(path = "/login")
//    public ModelAndView login(ModelAndView modelAndView) {
//        modelAndView.setViewName("user/login");
//        return modelAndView;
//    }
//
//    @RequestMapping(value = "/register", method = RequestMethod.POST)
//    public ModelAndView registerPost(@ModelAttribute @Valid User user,
//                                     BindingResult result) {
//        if (result.hasErrors()) {
//            ModelAndView mv = new ModelAndView();
//            mv.setViewName("user/registration");
//            return mv;
//        }
//        com.company.animalreport.entities.User u = userServiceInter.save(user);
//        return new ModelAndView("redirect:/user/login?success=true");
//    }
//
//}
