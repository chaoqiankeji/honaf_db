package test.repeatable;


import java.lang.annotation.Repeatable;

@Repeatable(Authorities.class)
public @interface Authority {
    String role();
}
