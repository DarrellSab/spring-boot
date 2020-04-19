package com.example.demo.repository;

import com.example.demo.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UsersRepository extends JpaRepository<User, Integer> {
    ///Those two methods are the main Queries which are using in this application
    @Query("FROM User p WHERE p.name= :searchText OR p.birthday= :searchText ORDER BY p.id DESC ")
    public Page<User> findUserByNameOrBirthdayIgnoreCase(Pageable pageable, @Param("searchText") String name);

    @Query("select p from User p where p.name like %?1%")
    public List<User> findUserByNameIgnoreCase(String name);

}
