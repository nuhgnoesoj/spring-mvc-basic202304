package com.spring.mvc.chap04.repository;

import com.spring.mvc.chap04.dto.ScoreRequestDTO;
import com.spring.mvc.chap04.entity.Score;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class StudentRepositoryTest {

    @Autowired
   ScoreRepository repository;

    @Test
    @DisplayName("학생의 이름,점수,평균,총점,등급를 DB student table에 잘 삽입해야 한다.")
    void saveTest() {
        ScoreRequestDTO dto = new ScoreRequestDTO();
        dto.setName("홍길동");
        dto.setKor(50);
        dto.setEng(70);
        dto.setMath(80);
        Score s = new Score(dto);

        repository.save(s);
    }
}