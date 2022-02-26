package hello.SpiringStudy;

import hello.SpiringStudy.repository.MemberRepository;
import hello.SpiringStudy.repository.MemoryMemberRepository;
import hello.SpiringStudy.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
