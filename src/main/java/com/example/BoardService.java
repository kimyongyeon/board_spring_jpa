package com.example;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by yongyeonkim on 2016. 5. 29..
 */
public interface BoardService extends JpaRepository<Board, Long>{
}
