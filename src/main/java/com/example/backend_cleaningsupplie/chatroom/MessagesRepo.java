package com.example.backend_cleaningsupplie.chatroom;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MessagesRepo extends JpaRepository<Messages, String> {

Optional<Messages>deleteMessagesByTitle(String title);

    @Query("SELECT m FROM Messages m WHERE LOWER(m.fulltext) LIKE LOWER(CONCAT('%',:keyword,'%'))" +
            "OR LOWER(m.title) LIKE LOWER(CONCAT( '%',:keyword,'%'))")
    public List<Messages> searchMessages(@Param("keyword")String keyword);
}
