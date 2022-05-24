package com.example.backend_cleaningsupplie.appuser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface AppUserRepo extends JpaRepository<AppUser, String> {


  AppUser findByUsername(String username);

    Optional<AppUser> findByEmail(String email);

void deleteByFirstName(String firstName);
boolean existsByFirstName(String firstName);

    @Transactional
    @Modifying
    @Query("UPDATE AppUser a SET a.enabled = TRUE WHERE a.username= ?1")
    int enableAppUser(String username);

    @Query("SELECT a FROM AppUser a " +
            "WHERE LOWER(a.firstName) LIKE LOWER(CONCAT( '%',:keyword, '%'))" +
            "OR LOWER(a.lastName) LIKE LOWER(CONCAT('%',:keyword, '%')) " +
            "OR LOWER(a.email) LIKE LOWER(CONCAT('%',:keyword, '%'))" +
            "OR LOWER(a.username)LIKE LOWER(CONCAT('%',:keyword, '%')) ")
    public List<AppUser> search(@Param("keyword") String keyword);
}
