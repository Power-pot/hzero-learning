package org.fff.learning;

import io.choerodon.core.iam.ResourceLevel;
import io.choerodon.resource.annoation.EnableChoerodonResourceServer;
import io.choerodon.swagger.annotation.Permission;
import org.hzero.autoconfigure.oauth.EnableHZeroOauth;
import org.hzero.core.util.EncryptionUtils;
import org.hzero.core.util.Pair;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableHZeroOauth
@EnableDiscoveryClient
@SpringBootApplication
@EnableChoerodonResourceServer
@RestController
public class AuthServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(AuthServerApplication.class, args);
    }


    @Permission(level = ResourceLevel.SITE, permissionPublic = true)
    @GetMapping("/hello")
    public void test() {
//        Pair<String, String> key = EncryptionUtils.RSA.generateKeyPair();
//        String privateKey = key.getFirst();
//        String publicKey = key.getSecond();
//
//        System.out.println("PrivateKey >>>\n" + privateKey + "\n");
//        System.out.println("PublicKey >>>\n" + publicKey + "\n");

        String publicKey = "MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAKXSnUpigf1Ule+BxND7rGktVXiO3Cog9xDO2UP6sJqywWeNTG6m+2rLkelPiej5M3ptS3QVXvHFydLHX/G+eGsCAwEAAQ==";
        String privateKey = "MIIBVgIBADANBgkqhkiG9w0BAQEFAASCAUAwggE8AgEAAkEApdKdSmKB/VSV74HE0PusaS1VeI7cKiD3EM7ZQ/qwmrLBZ41Mbqb7asuR6U+J6Pkzem1LdBVe8cXJ0sdf8b54awIDAQABAkEAotHAu+8pr/NEHZ4QARt9WPC4gd3UdFFWBtz0HHmkut/BxgNIXI8znc82GLg/ZVK4XoWMYJcOVt/JBW+I/HofgQIhAM7GGh5Tejm8rNjqC5m0TcN0IT8hFFhbaoGJ63b/2BSLAiEAzUy7pXQ/3AEQJ5m9PhHT59ACoUsCjsFD8kcvmkFVR6ECIQC771Zh5eGbhJ9dcCwnAbgERBLLvBcvz7bYEjEPsa4FzQIgXGLPfqFVq3d/AZMZqjjzlznwNQ1AVWV7YifOsCf+bIECIQCReTJ+JMTNsWV5xVnL0s9XudgyYVA6aezfZXNTzUfPgg==";
        System.out.println("PrivateKey >>>\n" + privateKey + "\n");
        System.out.println("PublicKey >>>\n" + publicKey + "\n");

        
        String content = "123456";
        System.out.println("Content >>>\n" + content + "\n");

        // 使用公钥加密
        String encrypt = EncryptionUtils.RSA.encrypt(content, publicKey);
        // 使用私钥解密
        String decrypt = EncryptionUtils.RSA.decrypt(encrypt, privateKey);
        System.out.println("Encrypt >>>\n" + encrypt + "\n");
        System.out.println("Decrypt >>>\n" + decrypt);
    }
}
