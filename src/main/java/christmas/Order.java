package christmas;

import java.util.List;

public class Order {
    Date date;
    List<Menu.menuInfo> orderMenu;
    List<Integer> orderAmount;
    int totalPrice;

    static boolean isOrderPossible = false;
    Order(Date date, List<Menu.menuInfo> order, List<Integer> amount){
        this.date = date;
        this.orderMenu = order;
        this.orderAmount = amount;
        this.totalPrice = totalPriceCalculator();
    }

    private int totalPriceCalculator(){
        for (int i = 0; i < orderMenu.size(); i++) {
            totalPrice += orderMenu.get(i).getPrice() * orderAmount.get(i);
        }
        return totalPrice;
    }
    public boolean checkOrderPossibility(){
        int drinkCount = 0;
        for (int i = 0; i < orderMenu.size(); i++) {
            if (orderMenu.get(i).getType() == Menu.menuType.DRINK)
                drinkCount += 1;
        }
        if(drinkCount == orderMenu.size())
            isOrderPossible = false;

        return isOrderPossible;
    }

    public int getTotalPrice() {
        System.out.println(totalPrice);
        return totalPrice;
    }

    public int countOrder(){
        int count = 0;
        for (int i = 0; i < orderAmount.size(); i++) {
            count += orderAmount.get(i);
        }
        return count;
    }

    public boolean checkOrderAmount(){
        if (countOrder() > 20)
            isOrderPossible = false;
        return isOrderPossible;
    }
}
