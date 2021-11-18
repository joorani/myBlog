package com.myblog.domain;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;

import java.util.List;

public interface MemoRepository extends JpaRepository<Memo, Long> {

}
