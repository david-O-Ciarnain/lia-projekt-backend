package com.example.backend_cleaningsupplie.upload_file;

import com.example.backend_cleaningsupplie.upload_file.entity.FileDB;
import com.example.backend_cleaningsupplie.upload_file.message.ResponseFile;
import com.example.backend_cleaningsupplie.upload_file.message.ResponseMessage;
import com.example.backend_cleaningsupplie.upload_file.sevice.FileStorageService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("http://localhost:8081")
@RequestMapping("/uploadfile")
@AllArgsConstructor
public class FileUploadController {

    private final FileStorageService fileStorageService;

    @PostMapping("/upload")
    public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {

        String message = "";

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
    public ResponseEntity<List<ResponseFile>> getAllFiles() {
        List<ResponseFile> files = fileStorageService.getAllFiles().map(fileDB -> {
            String fileDownLoadUri = ServletUriComponentsBuilder
                    .fromCurrentContextPath()
                    .path("/files/")
                    .path(fileDB.getId())
                    .toUriString();

            return new ResponseFile(
                    fileDB.getName(),
                    fileDownLoadUri,
                    fileDB.getType(),
                    fileDB.getData().length
            );
        }).collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(files);
    }

    @GetMapping("/files/{id}")
    public ResponseEntity<byte[]>getFileById(@PathVariable("id") String id){
        FileDB fileDB = fileStorageService.getFileById(id);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,"attachment; filename\"" + fileDB.getName() +"\"")
                .body(fileDB.getData());
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
}
