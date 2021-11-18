package com.myblog.domain;

import lombok.Getter;

@Getter
public class MemoSaveRequestDto {
    private String title;
    private String author;
    private String contents;
}
