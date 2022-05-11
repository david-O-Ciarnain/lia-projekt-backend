package com.example.backend_cleaningsupplie.upload_file.file_repo;

import com.example.backend_cleaningsupplie.upload_file.entity.FileImgDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileImgRepo extends JpaRepository<FileImgDB, String> {
}
