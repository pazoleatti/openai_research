package com.yura.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Usage {
    private int inputTokens;
    private InputTokensDetails inputTokensDetails;
    private int outputTokens;
    private OutputTokensDetails outputTokensDetails;
    private int totalTokens;
}
