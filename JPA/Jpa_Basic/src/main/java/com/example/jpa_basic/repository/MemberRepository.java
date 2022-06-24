package com.example.jpa_basic.repository;

import com.example.jpa_basic.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

}
