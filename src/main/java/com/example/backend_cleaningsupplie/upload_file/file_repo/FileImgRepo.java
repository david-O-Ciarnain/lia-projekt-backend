package com.example.backend_cleaningsupplie.upload_file.file_repo;

import com.example.backend_cleaningsupplie.upload_file.entity.FileImgDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FileImgRepo extends JpaRepository<FileImgDB, String> {


    @Query("SELECT fi FROM FileImgDB fi " +
            "WHERE LOWER(fi.name) LIKE LOWER(CONCAT( '%',:keyword, '%'))" +
            "OR LOWER(fi.type) LIKE LOWER(CONCAT('%',:keyword, '%'))")
     List<FileImgDB> searchOnNameAndType(@Param("keyword") String keyword);

    Optional<FileImgDB> findByName(String name);
    void deleteByName(String name);
    boolean existsByName(String name);

}
