package org.falcon.model.user.picture;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.falcon.model.Identifiable;
import org.falcon.model.user.User;

@Getter
@Setter
@Entity
@Table(name = "profile_pictures")
public class ProfilePicture extends Identifiable {
    @Lob
    private byte[] fileData;
    @Column(name = "file_name")
    private String fileName;
    @Enumerated(EnumType.STRING)
    @Column(name = "extension")
    private PictureExtension extension;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
    public ProfilePicture() {
        this.fileData = new byte[0];
        this.fileName = "";
        this.extension = PictureExtension.JPEG;
        this.user = new User();
    }
    public ProfilePicture(final byte[] fileData,
                          final String fileName,
                          final PictureExtension extension,
                          final User user) {
        this.fileData = fileData;
        this.fileName = fileName;
        this.extension = extension;
        this.user = user;
    }
}
