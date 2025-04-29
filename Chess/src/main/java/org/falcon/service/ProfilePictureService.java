package org.falcon.service;

import org.falcon.model.user.User;
import org.falcon.model.user.picture.ProfilePicture;
import org.falcon.repository.ProfilePictureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfilePictureService {
    private ProfilePictureRepository profilePictureRepository;
    @Autowired
    public ProfilePictureService(ProfilePictureRepository profilePictureRepository) {
        this.profilePictureRepository = profilePictureRepository;
    }

    public ProfilePicture getByUser(User user) {
        return this.profilePictureRepository.getProfilePictureByUser(user);
    }
}
