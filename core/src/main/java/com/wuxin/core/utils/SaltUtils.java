package com.wuxin.core.utils;

import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * Atothor:aa
 * data:2022/10/17
 */
@Component
public class SaltUtils {

        public String getSalt(int n) {
            char[] chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz01234567890!@#$%^&*()".toCharArray();
            StringBuilder s = new StringBuilder();
            for (int i = 0; i < n; i++) {
                char c = chars[new Random().nextInt(chars.length)];
                s.append(c);
            }
            return s.toString();
        }

}
