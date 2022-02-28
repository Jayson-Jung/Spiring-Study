package hello.SpiringStudy.controller;

public class MemberForm {
    private String name;    //input 의 name이 여기의 name으로 들어온다. (spring이 setName 호출)

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
