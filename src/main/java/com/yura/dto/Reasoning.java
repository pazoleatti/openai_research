package com.yura.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Reasoning {
    private Object effort; // Use Object if the type can vary
    private Object summary; // Use Object if the type can vary
}
