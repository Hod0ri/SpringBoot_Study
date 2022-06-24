package com.example.jpa_basic.Controller;

import com.example.jpa_basic.domain.Member;
import com.example.jpa_basic.repository.MemberRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {
    private final MemberRepository memberRepository;

    @PostMapping("/create")
    public ResponseEntity<Member> createMember() throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = format.parse("2020-01-01");
        Member member = Member.builder()
                .name("홍길동")
                .nickname("hong")
                .age(20)
                .birthday(date)
                .build();
        Member saveMember = memberRepository.save(member);
        return new ResponseEntity<>(member, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Member> updateMember() throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = format.parse("2020-01-01");
        Member member = Member.builder()
                .id(1L)
                .name("임꺽정")
                .nickname("im")
                .age(30)
                .birthday(date)
                .build();
        Member saveMember = memberRepository.save(member);
        return new ResponseEntity<>(saveMember, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<Member>> getMembers() {
        List<Member> members = memberRepository.findAll();
        return new ResponseEntity<>(members, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Member> getMember(@PathVariable Long id) {
        Member member = memberRepository.findById(id).orElse(null);
        return new ResponseEntity<>(member, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteMember(@PathVariable Long id) {
        memberRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
