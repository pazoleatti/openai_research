package com.yura.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class Output {
    private String type;
    private String id;
    private String status;
    private String role;
    private List<Content> content;
}
