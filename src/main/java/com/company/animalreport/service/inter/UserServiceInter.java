package com.company.animalreport.service.inter;


import com.company.animalreport.entities.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserServiceInter {
    public User findById(Integer id);

    public List<User> findAll();

    public User save(User user);

    public User update(User user);

    public int delete(Integer id);
}
