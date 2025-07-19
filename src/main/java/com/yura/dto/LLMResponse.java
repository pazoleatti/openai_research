package com.yura.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class LLMResponse {
    private String id;
    private String object;
    private long createdAt;
    private String status;
    private Object error; // Use Object if the type can vary, or a specific class if known
    private Object incompleteDetails; // Use Object if the type can vary
    private Object instructions; // Use Object if the type can vary
    private Object maxOutputTokens; // Use Object if the type can vary
    private String model;
    private List<Output> output;
    private boolean parallelToolCalls;
    private Object previousResponseId; // Use Object if the type can vary
    private Reasoning reasoning;
    private boolean store;
    private double temperature;
    private Text text;
    private String toolChoice;
    private Object[] tools; // Use Object if the type can vary, or a specific class if known
    private double topP;
    private String truncation;
    private Usage usage;
    private Object user; // Use Object if the type can vary
    private Metadata metadata;
}
