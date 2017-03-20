package test.repeatable;



public class RepeatableAnnotation {
    @Authority(role = "admin")
    @Authority(role = "Manager")
    public void role(){ }
}
