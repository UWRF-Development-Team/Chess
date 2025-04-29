package org.falcon.model.user.picture;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.falcon.model.user.User;

@Getter
@Setter
public class ProfilePicture {
    private byte[] fileData;
    private String fileName;
    private PictureExtension extension;
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
