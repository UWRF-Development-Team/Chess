package org.falcon.model.player;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Timer {
    private int time_remaining;

    public Timer(int setTime){
        time_remaining =   setTime;
    }

    public void Countdown (int time_remaining) throws InterruptedException {
        while (time_remaining > 0) {
            wait(1000);
            this.time_remaining--;
        }
        System.out.println("times up!!!");
    }

}
