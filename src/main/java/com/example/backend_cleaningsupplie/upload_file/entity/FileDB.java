package com.example.backend_cleaningsupplie.upload_file.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "files")
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class FileDB {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid",strategy = "uuid2")
    private String id;

    private String name;
    private String type;

    @Column(name = "date_of_upload")
    private LocalDate uploadDate;

    @Lob
   //@Type(type = "org.hibernate.type.BinaryType")
    private byte[]data;

    public FileDB(String name, String type, LocalDate uploadDate, byte[] data) {
        this.name = name;
        this.type = type;
        this.uploadDate = uploadDate;
        this.data = data;
    }
}
