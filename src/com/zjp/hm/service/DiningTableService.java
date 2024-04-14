package com.zjp.hm.service;

import com.zjp.hm.dao.DiningTableDao;
import com.zjp.hm.domain.DiningTable;

import java.util.List;

/**
 * @author ZhuJinPeng
 * @version 1.0
 */
public class DiningTableService {
    private DiningTableDao dao = new DiningTableDao();

    public List<DiningTable> getTables()
    {
        return dao.queryMulti("select id , state from dining_table",DiningTable.class);
    }

    public DiningTable getTable(String id)
    {
        return  dao.querySingle("select * from dining_table where id = ?",DiningTable.class,id);
    }

    public int update(String id,String state,String orderName,String orderTel)
    {
        return dao.update("update dining_table set state = ?, order_Name = ?, order_Tel = ? where id = ?",state,orderName,orderTel,id);
    }

    public boolean updateTableState(int id, String state)
    {
        int update = dao.update("update dining_table set state = ? where id = ?", state, id);
        if(update > 0)
            return true;
        else
            return false;
    }
}
