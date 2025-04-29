package org.falcon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/game-rules")
public class GameRulesController {
    @RequestMapping("")
    public String gameRules() {
        return "game-rules";
    }
}
