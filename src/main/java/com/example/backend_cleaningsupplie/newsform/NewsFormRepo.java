package com.example.backend_cleaningsupplie.newsform;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NewsFormRepo extends JpaRepository<NewsForm,String> {

    Optional<NewsForm> findByTitle(String title);

    void deleteByTitle(String title);
    boolean existsByTitle(String title);
}
