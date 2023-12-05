package christmas;

import java.util.List;

public class Order {
    Date date;
    private List<Menu.dishInfo> orderMenu;
    private List<Integer> dishAmount;
    static private double totalPrice;

    static boolean isPossible = false;
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
    public void checkPossibility(){
        int drinkCount = 0;
        for (int i = 0; i < orderMenu.size(); i++) {
            if (orderMenu.get(i).getType() == Menu.Category.DRINK)
                drinkCount += 1;
        }
        if(drinkCount == orderMenu.size())  //  음료만 주문했을 경우
            isPossible = false;

        if (countOrder() > 20)  //  주문 개수가 20개 초과일 경우
            isPossible = false;
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
}
