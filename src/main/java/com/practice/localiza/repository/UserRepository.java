//package com.practice.localiza.repository;
//
//import com.practice.localiza.entity.User;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Modifying;
//import org.springframework.data.jpa.repository.Query;
//import jakarta.transaction.Transactional;
//
//public interface UserRepository extends JpaRepository<User, Long> {
//
//    @Modifying
//    @Transactional
//    @Query("UPDATE User u SET u.password = :novaSenha WHERE id = :id")
//    public void alterarSenha(String novaSenha, long id);
//
//}
//
