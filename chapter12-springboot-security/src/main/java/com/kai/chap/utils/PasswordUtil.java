package com.kai.chap.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordUtil {

    public static void main(String[] args) {
        String pwd = "123456";
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String result = passwordEncoder.encode(pwd);
        System.out.println(result);
        System.out.println(result.length());
    }

}
