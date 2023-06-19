package com.auth.securityplayground.repository;

import com.auth.securityplayground.models.Loan;
import com.auth.securityplayground.models.Notice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoticeRepository extends JpaRepository<Notice, Integer> {

    // JPQL is Java Persistence Query Language defined in JPA specification
    @Query(value = "from Notice n where current_date between n.noticeBegDt and n.noticeEndDt")
    List<Notice> findAllActiveNotices();
}
