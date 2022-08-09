package com.coffee.util;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class TokenUtil {
    private String token;
}
