package com.zjp.hm.domain;

/**
 * @author ZhuJinPeng
 * @version 1.0
 */
public class Bill {
//    id int PRIMARY key auto_increment,
    private Integer id;
//    billId VARCHAR(50) NOT null DEFAULT '',
    private String billId;
//    menuId int not null default 0,
    private Integer menuId;
//    nums int not null default 0,
    private Integer nums;
//    money DOUBLE NOT null DEFAULT 0.0,
    private Double money;
//    diningTableId int not null default 0,
    private Integer diningTableId;
//    billDate DATETIME not null,
    private String billDate;
//    state VARCHAR(50) NOT null DEFAULT ''
    private String state;

    public Bill() {
    }

    public Bill(Integer id, String billId, Integer menuId, Integer nums, Double money, Integer diningTableId, String billDate, String state) {
        this.id = id;
        this.billId = billId;
        this.menuId = menuId;
        this.nums = nums;
        this.money = money;
        this.diningTableId = diningTableId;
        this.billDate = billDate;
        this.state = state;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "id=" + id +
                ", billId='" + billId + '\'' +
                ", menuId=" + menuId +
                ", nums=" + nums +
                ", money=" + money +
                ", diningTableId=" + diningTableId +
                ", billDate='" + billDate + '\'' +
                ", state='" + state + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBillId() {
        return billId;
    }

    public void setBillId(String billId) {
        this.billId = billId;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public Integer getNums() {
        return nums;
    }

    public void setNums(Integer nums) {
        this.nums = nums;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Integer getDiningTableId() {
        return diningTableId;
    }

    public void setDiningTableId(Integer diningTableId) {
        this.diningTableId = diningTableId;
    }

    public String getBillDate() {
        return billDate;
    }

    public void setBillDate(String billDate) {
        this.billDate = billDate;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
