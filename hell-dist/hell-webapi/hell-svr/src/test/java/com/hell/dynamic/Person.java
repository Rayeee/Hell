package com.hell.dynamic;

/**
 * Created by Rayee on 16/12/18.
 */
public class Person {

    public Person() {
    }

    public void learn(){
        System.out.println("person are learning...");
    }

    public void fun(Integer type){
        System.out.println("person has fun" + type);
    }

    public void speak(String words, Integer times){
        System.out.println("person speak" + words + times);
    }

    private String head;

    private Integer body;

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public Integer getBody() {
        return body;
    }

    public void setBody(Integer body) {
        this.body = body;
    }

}
