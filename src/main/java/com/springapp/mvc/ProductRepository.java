package com.springapp.mvc;

import org.springframework.dao.DataAccessException;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ProductRepository {
    @Transactional
    void save(Product product) throws DataAccessException;

    List findById(Integer id) throws  DataAccessException;
    // and another operations to database.
}
