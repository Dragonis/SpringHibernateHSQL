package com.springapp.mvc;

import org.springframework.dao.DataAccessException;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Dragonis on 15.11.2015.
 */
public class ProductRepositoryImpl implements ProductRepository {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    @Override
    public void save(Product product) throws DataAccessException {
//        if (product.getID() == null) {
//            this.em.persist(product);
//        }
//        else {
//            this.em.merge(product);
//        }
    }

    @Transactional
    @Override
    public List findById(Integer id) throws DataAccessException {
//        return this.em.createQuery("SELECT product FROM Product product ORDER BY product.name").getResultList();
return null;
    }

}
