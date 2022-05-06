package com.example.backend_cleaningsupplie.upload_file.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "files")
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class FileEntity {
}
