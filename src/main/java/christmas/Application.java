package christmas;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Date day1 = new Date();

        List<Menu.menuInfo> orderMenus = new ArrayList<>();
        orderMenus.add(Menu.menuInfo.바베큐립);
        orderMenus.add(Menu.menuInfo.크리스마스파스타);

        List<Integer> orderAmount = new ArrayList<>();
        orderAmount.add(1);
        orderAmount.add(2);

        Order order1 = new Order(day1,orderMenus,orderAmount);
        order1.getTotalPrice();

    }
}
