package com.zjp.hm.domain;

/**
 * @author ZhuJinPeng
 * @version 1.0
 */
public class DiningTable {
//    id int PRIMARY key auto_increment,
    private Integer id;
//    state VARCHAR(20) NOT null DEFAULT '',
    private String state;
//    order_Name VARCHAR(50) NOT null DEFAULT '',#预定人的姓名
    private String orderName;
//    order_Tel VARCHAR(50) NOT null DEFAULT ''
    private String orderTel;

    public DiningTable() {
    }

    public DiningTable(Integer id, String state, String orderName, String orderTel) {
        this.id = id;
        this.state = state;
        this.orderName = orderName;
        this.orderTel = orderTel;
    }

    @Override
    public String toString() {
        return "DiningTable{" +
                "id=" + id +
                ", state='" + state + '\'' +
                ", orderName='" + orderName + '\'' +
                ", orderTel='" + orderTel + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public String getOrderTel() {
        return orderTel;
    }

    public void setOrderTel(String orderTel) {
        this.orderTel = orderTel;
    }
}
