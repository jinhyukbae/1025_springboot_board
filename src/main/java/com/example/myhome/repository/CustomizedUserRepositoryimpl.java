package com.example.myhome.repository;

import com.example.myhome.model.QUser;
import com.example.myhome.model.User;
import com.querydsl.jpa.impl.JPAQuery;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class CustomizedUserRepositoryimpl implements CustomizedUserRepository {

    @PersistenceContext
    private EntityManager em;


    @Override
    public List<User> findByCustomUsername(String username) {
        QUser qUser = QUser.user;
        JPAQuery<?> query = new JPAQuery<>(em);
        List<User> users = query.select(qUser)
                .from(qUser)
                .where(qUser.username.contains(username))
                .fetch();

        return users;

    }


}
