package com.example.demoscript.util;

public class DoubleLinkedListDemo {
 
    public static void main(String[] args) {
        HeroNode2 hero1 = new HeroNode2(1,"宋江","及时雨");
        HeroNode2 hero2 = new HeroNode2(2,"卢俊义","玉麒麟");
        HeroNode2 hero3 = new HeroNode2(3,"吴用","智多星");
        HeroNode2 hero4 = new HeroNode2(4,"林冲","豹子头");
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.add(hero1);
        doubleLinkedList.add(hero2);
        doubleLinkedList.add(hero3);
        doubleLinkedList.add(hero4);
        doubleLinkedList.list();
        System.out.println("---------------------------------------------------------");
        //修改
        HeroNode2 newHeroNode = new HeroNode2(4,"冲冲","豹富");
        doubleLinkedList.update(newHeroNode);
        doubleLinkedList.list();
        System.out.println("---------------------------------------------------------");
 
        //删除
        doubleLinkedList.delete(3);
        doubleLinkedList.list();
        System.out.println("---------------------------------------------------------");
 
        //按照顺序添加
        HeroNode2 newHeroNode2 = new HeroNode2(6,"科科","小马");
        HeroNode2 newHeroNode3 = new HeroNode2(5,"菲菲","小羊");
        doubleLinkedList.addByOrder(newHeroNode2);
        doubleLinkedList.addByOrder(newHeroNode3);
        doubleLinkedList.list();
        System.out.println("---------------------------------------------------------");
 
    }
 
}