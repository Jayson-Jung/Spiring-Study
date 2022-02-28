package hello.SpiringStudy;

import hello.SpiringStudy.repository.JdbcMemberRepository;
import hello.SpiringStudy.repository.JdbcTemplateMemberRepository;
import hello.SpiringStudy.repository.MemberRepository;
import hello.SpiringStudy.repository.MemoryMemberRepository;
import hello.SpiringStudy.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import javax.swing.*;

@Configuration
public class SpringConfig {

    private DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        // return new MemoryMemberRepository();
        //return new JdbcMemberRepository(dataSource);
        return new JdbcTemplateMemberRepository(dataSource);
    }
}
