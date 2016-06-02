package com.kyy.springboot.study.service.repository;

import com.kyy.springboot.study.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by yongyeonkim on 2016. 5. 29..
 */
public interface BoardRepository extends JpaRepository<Board, Long>{
}
