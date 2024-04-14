package com.zjp.hm.service;

import com.zjp.hm.dao.MenuDao;
import com.zjp.hm.domain.Menu;

import java.util.List;

/**
 * @author ZhuJinPeng
 * @version 1.0
 */
public class MenuService {
    MenuDao dao = new MenuDao();


    public List<Menu> getMenuList()
    {
        return dao.queryMulti("select * from menu",Menu.class);
    }

    public Double getPrice(int id)
    {
        return (Double) dao.queryScalar("select price from menu where id = ?",id);
    }
    public Menu getMenu(int id)
    {
        return dao.querySingle("select * from menu where id = ?", Menu.class,id);
    }
}
