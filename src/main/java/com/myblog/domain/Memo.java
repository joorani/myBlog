package com.myblog.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Memo extends Timestamped{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false)
    private String contents;

    public Memo(MemoSaveRequestDto saveRequestDto) {
        this.title = saveRequestDto.getTitle();
        this.author = saveRequestDto.getAuthor();
        this.contents = saveRequestDto.getContents();
    }


}
