package com.dogtiger.challus.dto;

import lombok.Data;

@Data
public class SearchNoticeListReqDto {
    private String optionName;
    private String searchValue;
    private String sort;
}
