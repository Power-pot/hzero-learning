package org.fff.learning;

import io.choerodon.resource.annoation.EnableChoerodonResourceServer;
import org.hzero.autoconfigure.oauth.EnableHZeroOauth;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableHZeroOauth
@EnableDiscoveryClient
@SpringBootApplication
@EnableChoerodonResourceServer
public class AuthServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(AuthServerApplication.class, args);
    }
}
