package hello.SpiringStudy.controller;

import hello.SpiringStudy.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/*컴포넌트 스캔 방식*/
@Controller // (외부요청을 받고) Spring Contatiner에서 Spring Bean (Member Controller)이 관리가 된다.
public class MemberController {

    /*new로 선언을 하면 다른 컨테이너에서도 이 서비스를 사용할 수 있다.*/
    private final MemberService memberService;

    /*Spring Container에 등록을 해줘야한다.*/

    @Autowired  //(연관관계) memberservice를 스프링 컨테이너에 있는 컨트롤러에 연결해준다. (Dependency Injection(DI))
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
