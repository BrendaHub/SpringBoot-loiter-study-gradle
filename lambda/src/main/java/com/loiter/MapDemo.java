package com.loiter;

import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
//import com.google.common.collect.Lists;

/**
 * map lambda 表达式，
 */
public class MapDemo {


    static Map<String , AA> cMap = new HashMap<>();
    static List<AA> cList = new ArrayList<>();

    private void init() {
        AA a1 = new AA();
        a1.setPrimaryKey("100000");
        a1.setTeamID("ASDF");
        a1.setAa(213);
        a1.setBb(32);
        a1.setCc(12.323f);

        AA a2 = new AA();
        a2.setPrimaryKey("100000");
        a2.setTeamID("ASEF");
        a2.setAa(32);
        a2.setBb(12);
        a2.setCc(2.323f);

        AA a3 = new AA();
        a3.setPrimaryKey("100000");
        a3.setTeamID("DFS");
        a3.setAa(34);
        a3.setBb(3);
        a3.setCc(0.323f);

        AA a4 = new AA();
        a4.setPrimaryKey("100001");
        a4.setTeamID("KKIF");
        a4.setAa(34);
        a4.setBb(3);
        a4.setCc(0.323f);

        AA a5 = new AA();
        a5.setPrimaryKey("100001");
        a5.setTeamID("KKOSA");
        a5.setAa(34);
        a5.setBb(3);
        a5.setCc(0.323f);

        cMap.put("100000", a1);
        cMap.put("100000", a2);
        cMap.put("100000", a3);
        cMap.put("100001", a4);
        cMap.put("100001", a5);

        cList = List.of(a1, a2, a3, a4, a5);

    }



    public static void main(String[] args) {
        new MapDemo().init();
       cList.stream().forEach(System.out::println);
        List<AA> barList = new ArrayList<>();
       // 分类统计
        cList
                .stream()
                .collect(Collectors.groupingBy(AA::getPrimaryKey,Collectors.toList()))
                .forEach((name,fooListByName)->{
                    AA sumObj = new AA();
                    sumObj = fooListByName
                            .stream()
                            .reduce(sumObj,(u,t)->u.sum(t),(u,t)->u);
                    System.out.println(sumObj.toString());
                    barList.add(sumObj);
                });
        System.out.println("=======================");
        barList.forEach(System.out::println);
    }
}

