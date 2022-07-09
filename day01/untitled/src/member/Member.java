package untitled.src.member;

public class Member {
    private String name;
    private String tel;

    public Member(String name, String tel){
        this.name = name;
        this.tel = tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getName() {
        return name;
    }

    public String getTel() {
        return tel;
    }
}
