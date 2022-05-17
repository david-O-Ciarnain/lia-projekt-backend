package com.example.backend_cleaningsupplie.mass_mailing;

import com.example.backend_cleaningsupplie.appuser.AppUser;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

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

    private String senderName;
    private String receiverName;
    private String message;

    @ManyToOne
    @JoinColumn(name = "app_user_id")
    private AppUser appUser;

   // private String data;
  //  private Status status;

    public Messages(String senderName, String receiverName, String message) {
        this.senderName = senderName;
        this.receiverName = receiverName;
        this.message = message;
    }

    public Messages(AppUser appUser) {
        this.appUser = appUser;
    }
}
