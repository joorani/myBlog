package com.myblog.controller;

import com.myblog.domain.Memo;
import com.myblog.domain.MemoRepository;
import com.myblog.domain.MemoSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class MemoApiController {

    private final MemoRepository memoRepository;

    //전체 게시글 조회
    @GetMapping("/api/memos")
    public List<Memo> getMemo() {
        return memoRepository.findAll(Sort.by(Sort.Direction.DESC, "createdAt"));
    }

    //게시글 작성
    @PostMapping("/api/memos")
    public Memo postMemo(@RequestBody MemoSaveRequestDto saveRequestDto) {
        Memo memo = new Memo(saveRequestDto);
        return memoRepository.save(memo);
    }

    //선택 게시글 조회
    @GetMapping("/api/memos/{id}")
    public Memo getDetailMemo(@PathVariable Long id) {
        return memoRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("게시글이 존재하지 않습니다.")
        );
    }

}
