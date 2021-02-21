package com.hogwarts.blog;

/**
 * @author Jiayi Leng
 * @Description
 * @date 2021/1/5
 */
public class StringTest {
    String str = new String("good");
    char [] ch = { 't', 'e', 's', 't'};
    public void change(String str , char ch []){
    str = "test";
    ch [0] = 'b';
}
    public static void main(String[] args){
    StringTest ex = new StringTest();
        ex.change(ex.str,ex.ch);
        System.out.println(ex.str + "and"); ;
        System.out.println(ex.ch);
        }
}
