package com.auth.securityplayground.models;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.time.Instant;

@Entity
@Table(name = "notice_details")
@Data
public class Notice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "notice_id", columnDefinition = "serial")
    private Integer noticeId;

    @Column(name = "notice_summary")
    private String noticeSummary;

    @Column(name = "notice_details")
    private String noticeDetails;

    @Column(name = "notice_beg_dt")
    private Instant noticeBegDt;

    @Column(name = "notice_end_dt")
    private Instant noticeEndDt;

    @Column(name = "create_dt")
    private Instant createDt;

    @Column(name = "update_dt")
    private Instant updateDt;
}
