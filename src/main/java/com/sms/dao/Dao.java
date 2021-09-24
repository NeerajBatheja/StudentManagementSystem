package com.sms.dao;

import java.util.List;
import java.util.Optional;

import com.sms.model.User;

public interface Dao<T> {
    
    Optional<T> get(T id);
    
    List<T> getAll(User user);
    List<T> getAll();
    
    boolean save(T t);
    
    void update(T t, String[] params);
    
    void delete(T t);
    
}