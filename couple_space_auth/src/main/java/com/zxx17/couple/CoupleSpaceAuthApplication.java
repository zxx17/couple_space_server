package com.zxx17.couple;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * .
 *
 * @author Xinxuan Zhuo
 * @version 1.0.0
 * @since 2024/10/23
 */
@MapperScan("com.zxx17.couple.mapper")
@SpringBootApplication
public class CoupleSpaceAuthApplication {
    public static void main(String[] args) {
        SpringApplication.run(CoupleSpaceAuthApplication.class, args);
    }
}
