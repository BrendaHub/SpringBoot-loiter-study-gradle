package com.loiter;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Fun Description //TODO
 * @Date 2020/9/4 20:22 04
 * @Author chenhj(brenda)
 * site: https://www.ant-loiter.com
 **/
public class lambdaMap {

    static class Foo{
        private String name;
        private Foo1 foo1;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Foo1 getFoo1() {
            return foo1;
        }

        public void setFoo1(Foo1 foo1) {
            this.foo1 = foo1;
        }

        public Foo(String name, Foo1 foo1) {
            this.name = name;
            this.foo1 = foo1;
        }
    }

    static class Foo1{
        private String address;
        private Foo2 foo2;

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public Foo2 getFoo2() {
            return foo2;
        }

        public void setFoo2(Foo2 foo2) {
            this.foo2 = foo2;
        }

        public Foo1(String address, Foo2 foo2) {
            this.address = address;
            this.foo2 = foo2;
        }
    }

   static class Foo2 {
        private String eMail;

        public String geteMail() {
            return eMail;
        }

        public void seteMail(String eMail) {
            this.eMail = eMail;
        }

       public Foo2(String eMail) {
           this.eMail = eMail;
       }
   }

    public static void main(String[] args) {
        List<Foo> list = List.of(new Foo("hello,lambda", new Foo1("beijing", new Foo2("adb@adb.com"))),
                new Foo("hello,lambda1", new Foo1("beijing1", new Foo2("adb1@adb.com"))));

        List<String> collect = list.stream().map(item -> item.foo1)
                .map(item -> item.foo2)
                .map(item -> item.geteMail())
                .collect(Collectors.toList());
        collect.parallelStream().forEach(System.out::println);
        Map<String, Foo> collect1 = list.parallelStream().collect(Collectors.toMap(Foo::getName, Foo -> Foo));
        collect1.entrySet().forEach(System.out::println);
    }
}
