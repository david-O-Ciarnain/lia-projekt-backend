package com.example.backend_cleaningsupplie.mass_mailing;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MessagesRepo extends JpaRepository<Messages, String> {

    Optional<Messages> findByReceiverName(String receiverName);

    @Query("SELECT m FROM Messages m WHERE LOWER(m.message) LIKE LOWER(CONCAT('%',:keyword,'%'))" +
            "OR LOWER(m.receiverName) LIKE LOWER(CONCAT( '%',:keyword,'%'))")
    public List<Messages> searchMessages(@Param("keyword")String keyword);
}
