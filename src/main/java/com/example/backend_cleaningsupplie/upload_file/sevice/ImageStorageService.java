package com.example.backend_cleaningsupplie.upload_file.sevice;

import com.example.backend_cleaningsupplie.upload_file.entity.FileImgDB;
import com.example.backend_cleaningsupplie.upload_file.file_repo.FileImgRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Objects;
import java.util.stream.Stream;

@Service
@AllArgsConstructor
public class ImageStorageService {

    private final FileImgRepo fileImgRepo;

    public FileImgDB storeImg(MultipartFile file) throws IOException {

        if (!Objects.requireNonNull(file.getContentType()).startsWith("image")) {
            throw new IOException("need to be a image file");
        }

        String fileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
        FileImgDB fileImgDB = new FileImgDB(fileName, file.getContentType(), file.getBytes());
        return fileImgRepo.save(fileImgDB);
    }

    public Stream<FileImgDB>getAllImg(){
        return fileImgRepo.findAll().stream();
    }
    public FileImgDB findImageById(String id){
        return fileImgRepo.findById(id).orElseThrow(() -> new IllegalStateException("Can't find image"));
    }
    public void deleteImageById(String id){
        checkIfIdExits(id);
        fileImgRepo.deleteById(id);
    }

    public void checkIfIdExits(String id) {

        boolean exists = fileImgRepo.existsById(id);
        if (!exists) {
            throw new IllegalStateException("file with id" + id + " do not exist");
        }
    }
}

