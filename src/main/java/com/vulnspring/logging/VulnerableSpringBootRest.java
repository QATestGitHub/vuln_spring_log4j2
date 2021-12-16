package com.vulnspring.logging;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class VulnerableSpringBootRest {

    private static final Logger LOG = LogManager.getLogger(VulnerableSpringBootRest.class);

    @GetMapping("/api/redir")
    @ResponseBody
    public ResponseEntity<String> getParam(@RequestParam String url, @RequestHeader("X-Api-Version") String apiVersion) {
        LOG.error("CUSTOM LOG: " + url);
        return ResponseEntity.ok().body("GET Input: " + url + "\nX-Api-Version: " + apiVersion);
    }

    @GetMapping("/api/color")
    @ResponseBody
    public ResponseEntity<String> getParam(@RequestParam String name) {
        LOG.error("CUSTOM LOG: " + name);
        return ResponseEntity.ok().body("GET Input: " + name);
    }

    @PostMapping("/api/user")
    @ResponseBody
    public ResponseEntity<?> postParam(@RequestBody String username){
        LOG.error("CUSTOM LOG: " + username);
        return ResponseEntity.ok().body("POST Input: " + username);
    }

    @GetMapping("/")
    @ResponseBody
    public ResponseEntity<String> index(@RequestHeader("X-Forwarded-For") String XFF) {
        LOG.info("CUSTOM LOG: " + XFF);
        return ResponseEntity.ok().body("Received a request from " + XFF);
    }
}
