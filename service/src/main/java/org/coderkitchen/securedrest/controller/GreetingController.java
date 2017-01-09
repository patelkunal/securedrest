package org.coderkitchen.securedrest.controller;

import com.google.common.collect.ImmutableBiMap;
import org.coderkitchen.securedrest.common.CommonAuthServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by kunal_patel on 12/30/16.
 */
@RestController
public class GreetingController extends CommonAuthServices {

    private static final Logger LOGGER = LoggerFactory.getLogger(GreetingController.class);

    @RequestMapping(value = "greet")
    protected ResponseEntity<?> greet() {
        String username = super.getUsernameFromSession();
        LOGGER.trace("Greetting {}", username);
        String message = String.format("hello %s !!", username != null ? username : "there");
        return ResponseEntity.ok(ImmutableBiMap.of("message", message));
    }

}
