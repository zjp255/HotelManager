package com.zjp.hm.service;

import com.zjp.hm.dao.BillDao;
import com.zjp.hm.domain.Bill;

import java.util.List;
import java.util.UUID;

/**
 * @author ZhuJinPeng
 * @version 1.0
 */
public class BillService {
    BillDao dao = new BillDao();
    MenuService menuService = new MenuService();

    DiningTableService diningTableService = new DiningTableService();
    public List<Bill> getBillList()
    {
        return dao.queryMulti("select * from bill",Bill.class);
    }

    public boolean orderMenu(int menuId, int nums ,int diningTableId)
    {
        String billId = UUID.randomUUID().toString();
        int update = dao.update("insert into bill values(null,?,?,?,?,?, now() , '未结账')"
                , billId, menuId, nums, menuService.getPrice(menuId) * nums, diningTableId);
        if(update <= 0)
        {
            return false;
        }
        else {
            return diningTableService.updateTableState(diningTableId,"就餐中");
        }
    }



    public boolean payBill(int diningTableId, String payType)
    {

        int update = dao.update("update bill set state = ? where diningTableId = ? and state = '未结账'", payType, diningTableId);
        if(update > 0)
        {
            return diningTableService.updateTableState(diningTableId,"空");
        }else {
            return false;
        }
    }
}
