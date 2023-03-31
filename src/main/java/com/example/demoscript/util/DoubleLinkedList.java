package com.example.demoscript.util;

class DoubleLinkedList{
    //初始化头节点
    private HeroNode2 head = new HeroNode2(0,"","");
 
    //返回头节点
    public HeroNode2 getHead(){
        return head;
    }
 
    /**
     * 双向链表节点的遍历
     *
     */
    public void list(){
        if(head.next == null){
            System.out.println("链表为空");
            return;
        }
 
        HeroNode2 temp = head.next;
        while(true){
            if(temp == null){
                break;
            }
            //输出节点信息
            System.out.println(temp);
            temp = temp.next;
        }
    }
 
    /**
     * 双向链表节点的添加
     *
     * @param heroNode
     */
    public void add(HeroNode2 heroNode){
        HeroNode2 temp = head;
        while(true){
            if(temp.next == null){
                break;
            }
            temp = temp.next;
        }
        //形成双向链表
        temp.next = heroNode;
        heroNode.pre = temp;
    }
 
    public void addByOrder(HeroNode2 heroNode){
        HeroNode2 temp = head;
        boolean flag = false;
        while(true){
            if(temp.next == null){
                break;
            }
            if(temp.next.no == heroNode.no){
                flag = true;
                break;
            }
            if(temp.next.no > heroNode.no){
                break;
            }
            temp = temp.next;
        }
 
        if(flag){
            System.out.println("要添加的节点编号已经存在");
        }else{
            if (temp.next != null) {
                temp.next.pre = heroNode;
                heroNode.next = temp.next;
            }
            temp.next = heroNode;
            heroNode.pre = temp;
            }
        }
 
 
 
 
    /**
     * 双向链表节点的修改
     *
     * @param newHeroNode
     */
    public void update(HeroNode2 newHeroNode){
        if(head.next == null){
            System.out.println("链表为空");
            return;
        }
        HeroNode2 temp = head.next;
        boolean flag = false;
        while(true){
            if(temp == null){
                break;
            }
            if(temp.no == newHeroNode.no){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if(flag){
            temp.name = newHeroNode.name;
            temp.nickname = newHeroNode.nickname;
        }else {
            System.out.println("没有找到编号为" + newHeroNode.no + "的节点");
        }
    }
 
    /**
     * 双向链表中节点的删除
     *
     * @param no
     */
    public void delete(int no){
 
        //这里 与单链表不同的是，直接从head后第一个节点开始找就可以，辅助指针直接指向第一个有效节点
        if(head.next == null){
            System.out.println("链表为空");
            return;
        }
        HeroNode2 temp = head.next;
        boolean flag = false;
        while(true){
            if(temp.next == null){
                break;
            }
            if(temp.next.no == no){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if(flag){
            //找到待删除的节点位置
            temp.pre.next = temp.next;
            //注意，如果是最后一个节点，就不需要执行下面这段话
            if(temp.next != null) {
                temp.next.pre = temp.pre;
            }
        }else {
            System.out.println("要删除的编号为" + no + "节点不存在");
        }
    }
 
 
}
 
 