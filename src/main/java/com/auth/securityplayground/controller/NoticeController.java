package com.auth.securityplayground.controller;


import com.auth.securityplayground.models.Notice;
import com.auth.securityplayground.repository.NoticeRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.CacheControl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@AllArgsConstructor
public class NoticeController {

    NoticeRepository noticeRepository;
    @GetMapping("/notices")
    //@CrossOrigin(origins = "http://localhost:3000")
    //@CrossOrigin(origins = "*")
    public ResponseEntity<List<Notice>> getNotices(){
        List<Notice> notices = noticeRepository.findAllActiveNotices();
        return ResponseEntity.ok()
                .cacheControl(CacheControl.maxAge(60, TimeUnit.SECONDS))
                .body(notices);
    }


}
