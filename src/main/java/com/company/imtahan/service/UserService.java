package com.company.imtahan.service;

import com.company.imtahan.dto.ResponseDTO;
import com.company.imtahan.entities.User;
import com.company.imtahan.entities.UserRole;
import com.company.imtahan.projections.UserProjection;
import com.company.imtahan.repository.UserRepository;
import com.company.imtahan.security.SecurityUtil;
import com.company.imtahan.util.CommonUtil;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author sarkhanrasullu
 */
@Service
@Transactional
public class UserService {

    @Autowired
    SecurityUtil securityUtil;

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private EmailService emailService;

    @Autowired
    private BCryptPasswordEncoder encoder;

    public User getById(Integer id){
        return userRepo.findByIdCustom(id);
    }
    
    
    public ResponseDTO save(User user, Integer id) {
        user.setId(id);
        user.setLastChangeDate(new Date());
        if(user.getPassword()==null || user.getPassword().trim().isEmpty()){
           User u= userRepo.findById(user.getId()).get();
           user.setPassword(u.getPassword());
        }else{
           user.setPassword(encoder.encode(user.getPassword()));
        }
        
        userRepo.save(user);
        return new ResponseDTO("Successfully updated.");
    }
    
    public ResponseDTO addUser(User user, boolean loggedinuser) {
        UserProjection loggedInUser = securityUtil.loggedInUser();
        if (loggedInUser != null && loggedinuser) {
            System.out.println("loggedin user");
            User loggedInUser_ = userRepo.getOne(loggedInUser.getId());
            user.setId(loggedInUser_.getId());
            user.setRoleId(loggedInUser_.getRoleId());

            if (user.getPassword() == null || user.getPassword().trim().isEmpty()) {
                user.setPassword(loggedInUser_.getPassword());
            } else {
                user.setPassword(encoder.encode(user.getPassword()));
            }
        } else {
            System.out.println("not logged in user");
            user.setRoleId(new UserRole(2));
            if(user.getPassword()!=null && !user.getPassword().trim().isEmpty()){
                user.setPassword(encoder.encode(user.getPassword()));
            }else if(user.getId()!=null){
                user.setPassword(userRepo.getOne(user.getId()).getPassword());
            }
        }
        userRepo.save(user);

        return new ResponseDTO("Successfully registered.");
    }

    public ResponseDTO sendForgotEmail(User user) {
        ResponseDTO r = new ResponseDTO();

        User found = userRepo.findByEmail(user.getEmail());
        if (found == null) {
            r.setErrorMessage("no such user");
            r.setCode(-1);
            return r;
        }

        String forgotKey = CommonUtil.nDigit(4);
        found.setForgotKey(forgotKey);
        userRepo.save(found);

        emailService.sendEmail("Reset Password", "Verification Code:" + forgotKey, found.getEmail());

        return r;
    }

    public ResponseDTO resetPassword(User user) {
        ResponseDTO r = new ResponseDTO();

        User found = userRepo.findByForgotKey(user.getForgotKey());
        if (found == null) {
            r.setErrorMessage("key is invalid");
            r.setCode(-2);
            return r;
        }

        found.setPassword(encoder.encode(user.getPassword()));
        userRepo.save(found);
        return r;
    }

    public ResponseDTO verifyEmail(User user) {
        ResponseDTO r = new ResponseDTO();

        User found = userRepo.findByForgotKey(user.getForgotKey());
        if (found == null) {
            r.setErrorMessage("key is invalid");
            r.setCode(-2);
            return r;
        }

        return r;
    }
}
