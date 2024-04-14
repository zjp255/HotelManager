package com.zjp.hm.view;

import com.zjp.hm.domain.Bill;
import com.zjp.hm.domain.DiningTable;
import com.zjp.hm.domain.Employee;
import com.zjp.hm.domain.Menu;
import com.zjp.hm.service.BillService;
import com.zjp.hm.service.DiningTableService;
import com.zjp.hm.service.EmployeeService;
import com.zjp.hm.service.MenuService;
import com.zjp.hm.utils.UserInputUtility;

import java.util.List;

/**
 * @author ZhuJinPeng
 * @version 1.0
 */
public class HMView {
    Employee employee;
    EmployeeService employeeService = new EmployeeService();
    DiningTableService diningTableService = new DiningTableService();
    MenuService menuService = new MenuService();

    BillService billService = new BillService();
    public HMView() {
        showFirstMenu();
    }

    private void showFirstMenu()
    {
        while(true) {
            System.out.println("========满汉楼========");
            System.out.println("        1.登录        ");
            System.out.println("        2.退出        ");
            System.out.println("输入你的选择:");
            String inputKey = UserInputUtility.getInputKey(1);
            switch (inputKey) {
                case "1" -> {
                    if(showLoginMenu())
                    {
                        showSecondMenu();
                    }
                }
                case "2" -> {
                    System.exit(0);
                }
                default -> {
                    System.out.println("输入错误请重新输入！");
                }
            }
        }
    }

    private  void listDiningTable()
    {
        System.out.println("餐桌编号\t餐桌状态");
        List<DiningTable> tables = diningTableService.getTables();
        for(DiningTable diningTable : tables)
        {
            System.out.println(diningTable.getId() + "\t\t" + diningTable.getState());
        }
        System.out.println("输入任意字符继续");
        UserInputUtility.getInputKey(1);
    }

    private void orderDiningTable()
    {
        boolean run = true;
        while (run) {
            System.out.println("请输入要预定的餐桌编号[-1退出]:");
            String inputKey = UserInputUtility.getInputKey(2);

            if (!inputKey.equals("-1")) {
                DiningTable table = diningTableService.getTable(inputKey);
                if(table == null || !table.getState().equals("空"))
                {
                    System.out.println("餐桌不存在或非空闲");
                }
                else {
                    System.out.println("确定是否预定[Y/N]:");
                    if(UserInputUtility.getYN())
                    {
                        System.out.println("预定人姓名");
                        String orderName = UserInputUtility.getInputKey(50);
                        System.out.println("预定人电话");
                        String orderTel = UserInputUtility.getInputKey(50);
                        int affected = diningTableService.update(table.getId().toString(), "已预定", orderName, orderTel);
                        if(affected > 0)
                        {
                            System.out.println("预定成功");
                        }else {
                            System.out.println("预定失败");
                        }
                    }
                    System.out.println("输入任意字符继续");
                    UserInputUtility.getInputKey(1);
                    run = false;
                }
            }else
            {
                run = false;
            }
        }
    }

    private void listMenuTable()
    {
        System.out.println("菜品编号\t菜品名\t\t类别\t\t价格");
        List<Menu> menuList = menuService.getMenuList();
        for(Menu menu : menuList)
        {
            System.out.println(menu.getId() + "\t\t" +
                    menu.getName() + "\t\t" +
                    menu.getType() + "\t\t" +
                    menu.getPrice());
        }
        System.out.println("输入任意字符继续");
        UserInputUtility.getInputKey(1);
    }

    private void orderMenu()
    {
        while (true) {
            System.out.println("请输入点餐餐桌编号[-1退出]:");
            String inputKey = UserInputUtility.getInputKey(2);

            if (!inputKey.equals("-1")) {
                DiningTable table = diningTableService.getTable(inputKey);
                if(table == null)
                {
                    System.out.println("餐桌不存在或非空闲");
                }
                else {
                    System.out.println("请输入点餐菜品编号[-1退出]:");
                    String inputKey2 = UserInputUtility.getInputKey(2);

                    if (!inputKey2.equals("-1")) {
                        Menu menu = menuService.getMenu(Integer.parseInt(inputKey2));
                        if(menu == null)
                        {
                            System.out.println("菜品不存在");
                        }
                        else {
                            System.out.println("请输入点餐数量编号[-1退出]:");
                            String inputKey3 = UserInputUtility.getInputKey(2);

                            if (!inputKey3.equals("-1")) {
                                int num = Integer.parseInt(inputKey3);
                                if(num < 1)
                                {
                                    System.out.println("数量错误");
                                }
                                else {
                                    System.out.println("确定是否点餐[Y/N]:");
                                    if(UserInputUtility.getYN())
                                    {
                                        if(billService.orderMenu(Integer.parseInt(inputKey2),num,Integer.parseInt(inputKey)))
                                        {
                                            System.out.println("点餐成功");
                                        }
                                        else {
                                            System.out.println("点餐失败");
                                        }
                                    }
                                    System.out.println("输入任意字符继续");
                                    UserInputUtility.getInputKey(1);
                                    break;
                                }
                            }else
                            {
                                break;
                            }
                        }
                    }else
                    {
                        break;
                    }
                }
            }else
            {
                break;
            }
        }
    }

    void listBillTable(){
        System.out.println("编号\t\t菜品号\t菜品量\t金额\t\t\t桌号\t\t日期\t\t\t\t\t\t状态");
        List<Bill> billList = billService.getBillList();
        for(Bill bill : billList)
        {
            System.out.println(bill.getId() + "\t\t" +
                    bill.getMenuId() + "\t\t" +
                    bill.getNums() + "\t\t" +
                    bill.getMoney() + "\t\t" +
                    bill.getDiningTableId() + "\t\t" +
                    bill.getBillDate() + "\t\t" +
                    bill.getState()
            );
        }
        System.out.println("输入任意字符继续");
        UserInputUtility.getInputKey(1);
    }

    void payBill()
    {
        while (true) {
            System.out.println("请输入要结账的餐桌编号[-1退出]:");
            String inputKey = UserInputUtility.getInputKey(2);

            if (!inputKey.equals("-1")) {
                DiningTable table = diningTableService.getTable(inputKey);
                if(table == null || !table.getState().equals("就餐中"))
                {
                    System.out.println("餐桌不在用餐中");
                }
                else {
                    System.out.println("请输入结账方式[现金/支付宝/微信]:");
                    String inputKey1 = UserInputUtility.getInputKey(3);
                    while(!(inputKey1.equals("现金") || inputKey1.equals("支付宝") || inputKey1.equals("微信")))
                    {
                        System.out.println("输入错误");
                        System.out.println("请输入结账方式[现金/支付宝/微信]:");
                        inputKey1 = UserInputUtility.getInputKey(3);
                    }
                    System.out.println("确定是否结账[Y/N]:");
                    if(UserInputUtility.getYN())
                    {
                        if(billService.payBill(table.getId(),inputKey1))
                        {
                            System.out.println("结账成功");
                        }else {
                            System.out.println("结账失败");
                        }
                    }
                    System.out.println("输入任意字符继续");
                    UserInputUtility.getInputKey(1);
                    break;
                }
            }else
            {
               break;
            }
        }
    }

    private void showSecondMenu()
    {
        boolean run = true;
        while(run) {
            System.out.println("========满汉楼========");
            System.out.println("    1.显示餐桌状态     ");
            System.out.println("    2.预定餐桌        ");
            System.out.println("    3.显示所有菜品     ");
            System.out.println("    4.点餐服务        ");
            System.out.println("    5.查看账单        ");
            System.out.println("    6.结账           ");
            System.out.println("    7.退出系统        ");
            System.out.println("输入你的选择:");
            String inputKey = UserInputUtility.getInputKey(1);
            switch (inputKey) {
                case "1" -> {
                    listDiningTable();
                }
                case "2" -> {
                    orderDiningTable();
                }
                case "3" -> {
                    listMenuTable();
                }
                case "4" -> {
                    orderMenu();
                }
                case "5" -> {
                    listBillTable();
                }
                case "6" -> {
                    payBill();
                }
                case "7" -> {
                    run = false;
                }
                default -> {
                    System.out.println("输入错误请重新输入！");
                }
            }
        }
    }

    private boolean showLoginMenu() {
        System.out.println("========登录========");
        System.out.println("账号:");
        String account = UserInputUtility.getInputKey(50);
        System.out.println("密码:");
        String password = UserInputUtility.getInputKey(50);
        employee = employeeService.getEmployee(account,password);
        if (employee != null)
        {
            System.out.println("登录成功[" + employee.getName() + "]");
            //显示二级菜单
            return true;
        } else {
            System.out.println("登录失败");
            return false;
        }
    }
}
