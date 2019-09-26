/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.imtahan.eventhandlers;

import com.company.imtahan.security.SecurityUtil;

import java.lang.reflect.Method;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.event.AbstractRepositoryEventListener;

/**
 * @author sarkhanrasullu
 */
public abstract class AbstractCommonRepositoryEventListener<T> extends AbstractRepositoryEventListener<T> {

//      @Autowired
//    SecurityUtil securityUtil;
//
//    @Autowired
//    UserRepository userRepo;

    @Override
    public void onBeforeCreate(T entity) {
        try {
            setInsertDate(entity, new Date());
//            setInsertUserId(entity);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void onBeforeSave(T entity) {
        try {
            setLastChangeDate(entity, new Date());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void setInsertDate(T entity, Date date) throws Exception {
        Class<?> c = entity.getClass();
        Method method = c.getDeclaredMethod("setInsertDate", Date.class);
        method.invoke(entity, date);
    }


    private void setInsertUserId(T entity) throws Exception {
        Class<?> c = entity.getClass();
        Method method = c.getDeclaredMethod("setInsertUserId", User.class);
        method.invoke(entity, userRepo.getOne(securityUtil.loggedInUser().getId()));
    }

    private void setLastChangeDate(T entity, Date date) throws Exception {
        Class<?> c = entity.getClass();
        Method method = c.getDeclaredMethod("setLastChangeDate", Date.class);
        method.invoke(entity, date);
    }
}
