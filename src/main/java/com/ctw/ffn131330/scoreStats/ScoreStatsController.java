package com.ctw.ffn131330.scoreStats;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/scoreStats")
public class ScoreStatsController {

    @Autowired
    ScoreStatsService scoreStatsService;
}
