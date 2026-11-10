package AnnotationDemo;

public @interface MyBook {
    public String name();
    int age() default 18;
    String[] address();
}
