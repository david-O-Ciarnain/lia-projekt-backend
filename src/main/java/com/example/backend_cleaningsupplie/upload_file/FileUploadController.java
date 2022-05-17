package com.example.backend_cleaningsupplie.upload_file;

import com.example.backend_cleaningsupplie.upload_file.entity.FileDB;
import com.example.backend_cleaningsupplie.upload_file.message.ResponseFile;
import com.example.backend_cleaningsupplie.upload_file.message.ResponseMessage;
import com.example.backend_cleaningsupplie.upload_file.sevice.FileStorageService;
import com.example.backend_cleaningsupplie.upload_file.sevice.ImageStorageService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("http://localhost:8081")
@RequestMapping(path = "uploadFiles")
@AllArgsConstructor
public class FileUploadController {

    private final FileStorageService fileStorageService;
    private final ImageStorageService imageStorageService;

    @PostMapping
    public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {

        String message;

        try {
            fileStorageService.store(file);
            message = "Uploaded the file successfully: " + file.getOriginalFilename();
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));

        } catch (Exception e) {

            message = "Could not upload the file: " + file.getOriginalFilename();
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));

        }
    }


    @GetMapping("/files")
    public ResponseEntity<List<ResponseFile>> getAllFiles(String searchOnNameAndType) {
        List<ResponseFile> files = fileStorageService.getAllFiles(searchOnNameAndType).map(fileDB -> {
            String fileDownLoadUri = ServletUriComponentsBuilder
                    .fromCurrentContextPath()
                    .path("/files/")
                    .path(fileDB.getId())
                    .toUriString();

            return new ResponseFile(
                    fileDB.getName(),
                    fileDownLoadUri,
                    fileDB.getType(),
                    fileDB.getUploadDate(),
                    fileDB.getData().length);
        }).collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(files);
    }
    @GetMapping("/files/{id}")
    public FileDB findById(@PathVariable String id){
        return fileStorageService.getFileById(id);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable String id){
        try {

            fileStorageService.deletedFileByID(id);
            return ResponseEntity.noContent().build();
        }catch (Exception e){
           return ResponseEntity.notFound().build();
        }
    }

    //save image to its own table
    @PostMapping(path = "/img")
    public ResponseEntity<ResponseMessage>uploadImg(@RequestParam("file")MultipartFile file){

        String message;

        try {
            imageStorageService.storeImg(file);
            message="Uploaded the image successfully: " + file.getOriginalFilename();
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        }catch (Exception e){
            message="Could not upload the image: " + file.getOriginalFilename() + " make sure the file is a image";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
    }
    @GetMapping(path = "/findImg")
    public ResponseEntity<List<ResponseFile>>getAllImages(String searchOnNameAndType){
        List<ResponseFile>files = imageStorageService.getAllImg(searchOnNameAndType).map(fileImgDB -> {

            String fileDownLoadUri = ServletUriComponentsBuilder
                    .fromCurrentContextPath()
                    .path("/findImg")
                    .path(fileImgDB.getId())
                    .toUriString();

            return new ResponseFile(
                    fileImgDB.getName(),
                    fileDownLoadUri,
                    fileImgDB.getType(),
                    fileImgDB.getUploadDate(),
                    fileImgDB.getData().length
            );
        }).collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(files);
    }
}
