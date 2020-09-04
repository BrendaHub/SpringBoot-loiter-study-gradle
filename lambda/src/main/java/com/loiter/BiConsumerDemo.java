package com.loiter;

import lombok.Data;

import java.util.function.BiConsumer;

/**
 * @Fun Description //TODO
 * @Date 2020/9/1 16:00 01
 * @Author chenhj(brenda)
 * site: https://www.ant-loiter.com
 **/
public class BiConsumerDemo  {

    @Data
    static class Tpm{
        int a ;
        int b;
        int total;

        public Tpm a(int a) {
            this.a = a;
            return this;
        }
        public Tpm b(int b){
            this.b = b;
            return this;
        }

        public  Tpm total() {
            this.total = this.a + this.b;
            return this;
        }

        public int getA() {
            return a;
        }

        public int getB() {
            return b;
        }

        public int getTotal() {
            return total;
        }
    }


    public static void main(String[] args) {
        BiConsumer<Integer, Integer> addTwo = (x, y ) -> System.out.println(x + y );

        BiConsumer<Integer, Tpm> bitTwo = (x, y ) -> System.out.println(y.total + x);

        addTwo.accept(1,2);

        Tpm a =  new Tpm();
        a.a(12).b(34).total();
        System.out.println(a.getA());
        System.out.println(a.getB());

        bitTwo.accept(30000, a);
    }

}
