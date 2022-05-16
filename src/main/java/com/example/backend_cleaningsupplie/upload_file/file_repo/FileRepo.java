package com.example.backend_cleaningsupplie.upload_file.file_repo;

import com.example.backend_cleaningsupplie.upload_file.entity.FileDB;

import com.example.backend_cleaningsupplie.upload_file.entity.FileImgDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FileRepo extends JpaRepository<FileDB,String> {

    @Query("SELECT fi FROM FileDB fi " +
            "WHERE LOWER(fi.name) LIKE LOWER(CONCAT( '%',:keyword, '%'))" +
            "OR LOWER(fi.type) LIKE LOWER(CONCAT('%',:keyword, '%'))")
    List<FileDB> searchOnFileNameAndFileType(@Param("keyword") String keyword);

}
