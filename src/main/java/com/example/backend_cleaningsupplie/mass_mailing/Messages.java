package com.example.backend_cleaningsupplie.mass_mailing;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
public class Messages {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

   private String title;
    private String fulltext;


   // private String data;
  //  private Status status;


    public Messages(String title, String fulltext) {
        this.title = title;
        this.fulltext = fulltext;
    }


}
