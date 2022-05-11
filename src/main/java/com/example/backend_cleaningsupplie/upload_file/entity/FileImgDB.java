package com.example.backend_cleaningsupplie.upload_file.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "img")
public class FileImgDB {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid",strategy = "uuid2")
    private String id;

    private String name;
    private String type;
    @Column(name = "date_of_upload")
    private LocalDate uploadDate;

    @Lob
    private byte[] data;

    public FileImgDB(String name, String type, LocalDate uploadDate, byte[] data) {
        this.name = name;
        this.type = type;
        this.uploadDate = uploadDate;
        this.data = data;
    }
}
