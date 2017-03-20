package test.repeatable.before;


public class RepeatAnnotation {
    @Authorities({@Authority(role = "admin"), @Authority(role = "manager")})
    public void role(){
    }
}
