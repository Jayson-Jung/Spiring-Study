package hello.SpiringStudy.service;

import hello.SpiringStudy.domain.Member;
import hello.SpiringStudy.repository.MemberRepository;
import hello.SpiringStudy.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public class MemberService {
    //서비스는 기획쪽과 가깝게 설계한다. (바로바로 기획자와 찾기 쉽게)

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**
     *  회원 가입
     */
    public Long join(Member member) {
        //같은 이름이 있는 중복 회원은 안된다.
        validateDuplicateMember(member);    //중복회원검증
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    /**
     * 전체회원조회
     */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
