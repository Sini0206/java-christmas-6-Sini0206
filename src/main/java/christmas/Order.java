package christmas;

import java.util.List;

public class Order {
    Date date;
    private List<Menu.dishInfo> orderMenu;
    private List<Integer> dishAmount;
    static private double totalPrice;

    static boolean isOrderPossible = false;
    Order(Date date, List<Menu.dishInfo> orderMenu, List<Integer> dishAmount){
        this.date = date;
        this.orderMenu = orderMenu;
        this.dishAmount = dishAmount;
        this.totalPrice = totalPriceCalculator();
    }

    private double totalPriceCalculator(){
        for (int i = 0; i < orderMenu.size(); i++) {
            totalPrice += orderMenu.get(i).getPrice() * dishAmount.get(i);
        }
        return totalPrice;
    }
    public boolean checkOrderPossibility(){
        int drinkCount = 0;
        for (int i = 0; i < orderMenu.size(); i++) {
            if (orderMenu.get(i).getType() == Menu.Category.DRINK)
                drinkCount += 1;
        }
        if(drinkCount == orderMenu.size())
            isOrderPossible = false;

        return isOrderPossible;
    }

    static public double getTotalPrice() {
        return totalPrice;
    }
    public List<Menu.dishInfo> getOrderMenu(){
        return orderMenu;
    }

    public List<Integer> getDishAmount(){
        return dishAmount;
    }

    private int countOrder(){
        int count = 0;
        for (int i = 0; i < dishAmount.size(); i++) {
            count += dishAmount.get(i);
        }
        return count;
    }

    public boolean checkOrderAmount(){
        if (countOrder() > 20)
            isOrderPossible = false;
        return isOrderPossible;
    }
}
