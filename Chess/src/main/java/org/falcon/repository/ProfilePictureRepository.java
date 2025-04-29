package org.falcon.repository;

import org.falcon.model.user.User;
import org.falcon.model.user.picture.ProfilePicture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfilePictureRepository extends JpaRepository<ProfilePicture, Long> {
    ProfilePicture getProfilePictureByUser(User user);
}
