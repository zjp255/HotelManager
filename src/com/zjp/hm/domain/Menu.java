package com.zjp.hm.domain;

/**
 * @author ZhuJinPeng
 * @version 1.0
 */
public class Menu {
//    id int PRIMARY key auto_increment,
    private Integer id;
//		`name` VARCHAR(50) NOT null DEFAULT '',
    private String name;
//    type VARCHAR(50) NOT null DEFAULT '',
    private String type;
//    price DOUBLE NOT null DEFAULT 0.0
    private Double price;

    public Menu() {
    }

    public Menu(Integer id, String name, String type, Double price) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", price=" + price +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
