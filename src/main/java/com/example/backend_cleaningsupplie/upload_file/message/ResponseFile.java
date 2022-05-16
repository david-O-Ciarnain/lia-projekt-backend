package com.example.backend_cleaningsupplie.upload_file.message;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


import java.time.LocalDate;


@Getter
@Setter
@AllArgsConstructor
public class ResponseFile {
    private String name;
    private String url;
    private String type;

    private long size;


}
