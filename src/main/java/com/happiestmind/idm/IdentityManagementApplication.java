package com.happiestmind.idm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Enterprise application.
 */
@SuppressWarnings("checkstyle:HideUtilityClassConstructor")
@SpringBootApplication
public class IdentityManagementApplication {
    /**
     * Application.
     *
     * @param args args.
     */
    public static void main(String[] args) {
        SpringApplication.run(IdentityManagementApplication.class, args);
    }

}
