package com.yura.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Content {
    private String type;
    private String text;
    private Object[] annotations; // Use Object if the type can vary
}
