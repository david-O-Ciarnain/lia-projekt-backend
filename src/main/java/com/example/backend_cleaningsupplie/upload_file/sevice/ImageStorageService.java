package com.example.backend_cleaningsupplie.upload_file.sevice;

import com.example.backend_cleaningsupplie.upload_file.entity.FileImgDB;
import com.example.backend_cleaningsupplie.upload_file.file_repo.FileImgRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
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
        FileImgDB fileImgDB = new FileImgDB(fileName, file.getContentType(), LocalDate.now(), file.getBytes());
        return fileImgRepo.save(fileImgDB);
    }

    public Stream<FileImgDB> getAllImg(String searchOnNameAndType ) {

        if(searchOnNameAndType == null || searchOnNameAndType.isEmpty()) {
            return fileImgRepo.findAll().stream();
        }
            return  fileImgRepo.searchOnNameAndType(searchOnNameAndType).stream();
    }

    public void deleteImageByName(String name) {
        checkIfNameExits(name);
        fileImgRepo.deleteByName(name);
    }

    public void checkIfNameExits(String name) {

        boolean exists = fileImgRepo.existsByName(name);
        if (!exists) {
            throw new IllegalStateException("file with name" + name + " do not exist");
        }
    }
}

