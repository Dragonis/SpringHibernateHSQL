package com.springapp.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired private UserRepository userRepository;

    @Transactional
    @Override
    public String getUserNameAndSurname(Long id) {

        ApplicationContext context = new ClassPathXmlApplicationContext("springs.xml");
        User user = (User) context.getBean("User");
        userRepository.saveAndFlush(user);

//      User user = userRepository.findOne(id);
        String name = user.getFirstName();
        String surname = user.getLastName();
        return name + " " + surname;
    }
}
