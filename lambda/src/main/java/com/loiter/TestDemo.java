package com.loiter;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * @Fun Description //TODO
 * @Date 2020/9/1 09:52 01
 * @Author chenhj(brenda)
 * site: https://www.ant-loiter.com
 **/
public class TestDemo {

   static class Order {
        private String name;
        private String address;
        private String eMail;
        private Integer id;
        private LocalDateTime date;
        private Product product;

        public String getName() {
            return name;
        }

       public Product getProduct() {
           return product;
       }

       public void setProduct(Product product) {
           this.product = product;
       }

       public void setName(String name) {
            this.name = name;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public LocalDateTime getDate() {
            return date;
        }

        public void setDate(LocalDateTime date) {
            this.date = date;
        }

        public Order() {
        }

       public String getAddress() {
           return address;
       }

       public void setAddress(String address) {
           this.address = address;
       }

       public String geteMail() {
           return eMail;
       }

       public void seteMail(String eMail) {
           this.eMail = eMail;
       }
   }

   static  class Product {
       private String productName;
       private String info;

       public String getProductName() {
           return productName;
       }

       public void setProductName(String productName) {
           this.productName = productName;
       }

       public String getInfo() {
           return info;
       }

       public void setInfo(String info) {
           this.info = info;
       }
   }

    public static void main(String[] args) {
        System.out.println("Hello, World");

        Order order = new Order();
        order.setDate(LocalDateTime.now());
        order.setName("Order Demo");
        order.setAddress("Beijing");
        order.seteMail("asdf@af.com");
        Product product = new Product();
        product.setInfo("info");
        product.setProductName("produtname");
        order.setProduct(product);

        Stream.of(demo(order)).forEach(System.out::println);

    }

    public static String[] demo(Order order) {
      return Optional.ofNullable(order)
               .map(id -> id.getProduct())
               .map( oi -> new String[]{oi.getInfo(), oi.getProductName()})
               .orElse(null);



    }
}
