package org.falcon.model.player;

import lombok.Getter;
import lombok.Setter;

/**
 * run the timer on the front end, tracked on the back end
 */
@Getter
@Setter
public class Timer {
    // Total time
    // Time remaining
    private int time_remaining;

    public Timer(int setTime){
        time_remaining =   setTime;
    }

    public void Countdown (int time_remaining) throws InterruptedException {
        while (time_remaining > 0) {

            this.time_remaining--;
        }
        // local date time - local date time idea?
        System.out.println("times up!!!");
    }

}
