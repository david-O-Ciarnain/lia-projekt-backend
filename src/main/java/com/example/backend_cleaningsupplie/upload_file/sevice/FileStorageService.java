package com.example.backend_cleaningsupplie.upload_file.sevice;

import com.example.backend_cleaningsupplie.upload_file.entity.FileDB;
import com.example.backend_cleaningsupplie.upload_file.file_repo.FileRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Objects;
import java.util.stream.Stream;

@Service
@AllArgsConstructor
public class FileStorageService {


    private final FileRepo fileRepo;



    //post request
    public FileDB store(MultipartFile file) throws IOException {
        if (Objects.requireNonNull(file.getContentType()).startsWith("image")) {
            throw new IOException("need to be a file");
        }
        String fileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));

        FileDB fileDB = new FileDB(fileName, file.getContentType(), LocalDate.now(), file.getBytes());
        return fileRepo.save(fileDB);
    }



    //get request


    public Stream<FileDB> getAllFiles(String searchOnNameAndType) {
        if(searchOnNameAndType == null || searchOnNameAndType.isEmpty()){
            return fileRepo.findAll().stream();
        }
            return fileRepo.searchOnFileNameAndFileType(searchOnNameAndType).stream();
    }

    public void deletedFileByID(String id) {
        checkIfIdExits(id);
        fileRepo.deleteById(id);
    }
    //TODO fix update file if text file

    public void checkIfIdExits(String id) {

        boolean exists = fileRepo.existsById(id);
        if (!exists) {
            throw new IllegalStateException("file with id" + id + " do not exist");
        }
    }

}
