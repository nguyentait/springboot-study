package com.example.demo.repository;

import com.example.demo.entity.IdentityCard;
import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    public Optional<User> findByEmail(String email);
//    //JPQL
//    @Query("select u from User u where u.email = ?1")
//    public User myCustomQuery(String email);
//    //Native SQL
//    @Query(value = "select * from user u where u.email =?1",nativeQuery = true)
//    public User myCustomQuery2(String email);
//    @Query(value = "select * from user u where u.name = :name", nativeQuery = true)
//    User findUserByName(@Param("name") String name);
//    @Modifying
//    @Transactional
//    @Query(value = "Update user set name = ?1")
//    public void updateProfile(String name, String avatar, String phone, Date birthday, Long id);
}

