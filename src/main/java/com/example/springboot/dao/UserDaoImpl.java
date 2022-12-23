package com.example.springboot.dao;

import com.example.springboot.entity.User;
import org.hibernate.Session;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

import java.util.List;

@Repository
public class UserDaoImpl implements com.example.springboot.dao.UserDao {
@PersistenceContext
private EntityManager entityManager;
    @Override

    public List<User> getAllUsers() {
        TypedQuery<User> query = entityManager.createQuery("from User", User.class);

        return query.getResultList();
    }

    @Override
    public void saveUser(User user) {
        entityManager.persist(user);

    }

    @Override
    public User getUser(int id) {
       return entityManager.find(User.class,id);
    }

    @Override
    public void update(int id, User user) {
    User user1=getUser(id);
    user1.setName(user.getName());
    user1.setSurname(user.getSurname());
    user1.setDepartment(user.getDepartment());
    user1.setSalary(user.getSalary());
    entityManager.merge(user1);
    }

    @Override
    public void delete(int id) {
        String s="delete from Users where id=:userId";
        TypedQuery<User>query= (TypedQuery<User>) entityManager.createQuery("delete from User where id=:userId");
        query.setParameter("userId",id);
        query.executeUpdate();
    }
}
