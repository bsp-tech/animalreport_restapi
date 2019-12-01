//package com.company.animalreport.service.impl;
//
//import com.company.animalreport.entities.User;
//import com.company.animalreport.repository.UserRepository;
//import com.company.animalreport.service.inter.SecurityServiceInter;
//import com.company.animalreport.service.inter.UserServiceInter;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class UserServiceImpl implements UserServiceInter {
//    @Autowired
//    UserRepository userRepository;
//
//    @Autowired
//    private SecurityServiceInter securityServiceInter;
//
//    @Autowired
//    @Qualifier("pwdEncoder")
//    private PasswordEncoder passwordEncoder;
//
//
//    @Override
//    public User findById(Integer id) {
//        return userRepository.findById(id).get();
//    }
//
//    @Override
//    public List<User> findAll() {
//        return (List<User>) userRepository.findAll();
//    }
//
//    @Override
//    public User save(User user) {
//        return null;
//    }
//
//    @Override
//    public User update(User user) {
//        return null;
//    }
//
//
////    @Override
////    public User save(User user) {
////        user.setInsertDateTime(new java.sql.Date(new Date().getTime()));
////        user.setGroupId(new AuthGroup(2));
////        user.setEnabled(true);
////        user.setPassword(passwordEncoder.encode(user.getPassword().trim()));
////        return uss.save(user);
////    }
//
////    @Override
////    public com.bsptech.itcommunity.entity.User update(User user) {
////        com.bsptech.itcommunity.entity.User newUser = securityServiceInter.getLoggedInUserDetails().getUser();
////        newUser = userDataInter.getOne(newUser.getId());
////
////        newUser.setAge(user.getAge());
////        newUser.setEmail(user.getEmail());
////        newUser.setGenderId(user.getGenderId());
////        newUser.setName(user.getName());
////        newUser.setSurname(user.getSurname());
////        newUser.setPhone(user.getPhone());
////        newUser.setLastUpdateDateTime(new java.sql.Date(new Date().getTime()));
////        if(user.getPassword()!=null && !user.getPassword().trim().isEmpty()){
////            newUser.setPassword(passwordEncoder.encode(user.getPassword().trim()));
////        }
////
////        return userDataInter.save(newUser);
////    }
//
//    @Override
//    public int delete(Integer id) {
//        userRepository.deleteById(id);
//        return 0;
//    }
//}
