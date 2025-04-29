package org.falcon.controller;

import org.falcon.service.ProfilePictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/profile/picture")
public class ProfilePictureController {
    private ProfilePictureService profilePictureService;
    @Autowired
    public ProfilePictureController(ProfilePictureService profilePictureService) {
        this.profilePictureService = profilePictureService;
    }

    @GetMapping("/get/{userId}")
    public ResponseEntity<byte[]> getByUserId(@RequestParam int userId) {
        return null;
    }
}
