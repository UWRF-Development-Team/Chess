package org.falcon.model.user;

public enum SkillLevel {
    // AJ add here
    NOVICE("Novice"),
    AVERAGE("Average"),
    INTERMEDIATE("Intermediate"),
    CLUB_PLAYER("Club Player");


    public final String levelName;
    SkillLevel(String levelName) {
        this.levelName = levelName;
    }
}
