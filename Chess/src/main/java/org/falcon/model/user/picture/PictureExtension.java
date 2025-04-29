package org.falcon.model.user.picture;

public enum PictureExtension {
    PNG("png"),
    JPG("jpg"),
    JPEG("jpeg"),
    SVG("xml+svg"),
    WEBP("webp");
    final String extension;
    PictureExtension(String extension) {
        this.extension = extension;
    }
}
