package com.basic.myspringboot.config.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@Getter
@ToString
public class CustomerVO {
    private Long id;
    private String mode;
}