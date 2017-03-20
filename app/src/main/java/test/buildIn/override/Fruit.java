package test.buildIn.override;


//Orange 类编译不会有任何问题，Peach 类在编译的时候会提示相应的错误；@Override注解只能用于方法，不能用于其他程序元素。
public class Fruit{
    public void displayName(){
        System.out.println("水果的名字是：*****");
    }
}

class Orange extends Fruit {
    @Override
    public void displayName(){
        System.out.println("水果的名字是：桔子");
    }
}

//class Peach extends Fruit{
//    @Override
//    public void displayname(){
//        System.out.println("水果的名字是：桃子");
//    }
//}