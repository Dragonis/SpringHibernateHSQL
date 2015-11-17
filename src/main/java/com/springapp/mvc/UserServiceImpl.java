package com.springapp.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired private UserRepository userRepository;

    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    @Override
    public String getUserNameAndSurname(Long id) {

        String name = "", surname = "";
        ApplicationContext context = new ClassPathXmlApplicationContext("springs.xml");
        User user = (User) context.getBean("User");
        userRepository.saveAndFlush(user);
        user = null;

        // 1st Case to gets name and surname  from database
        Query query = entityManager.createQuery("select a from account a");
        List<User> users = query.getResultList();

        //2nd case to get name and surname from database
//      User user = userRepository.findOne(id);
//      name = user.getFirstName();
//      surname = user.getLastName();
        name = users.get(0).getFirstName();
        surname = users.get(0).getLastName();
        return name + " " + surname;
    }
}
