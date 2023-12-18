package christmas;

import java.util.List;

public class Order {
    Date date;
    private List<Menu.dishInfo> orderMenu;
    private List<Integer> dishAmount;
    private double totalPrice;
    Order(Date date, List<Menu.dishInfo> orderMenu, List<Integer> dishAmount){
        this.date = date;
        this.orderMenu = orderMenu;
        this.dishAmount = dishAmount;
        totalPriceCalculator();
    }

    private void totalPriceCalculator(){
        for (int i = 0; i < orderMenu.size(); i++) {
            this.totalPrice += orderMenu.get(i).getPrice() * dishAmount.get(i);
        }
    }
    public boolean checkPossibility(){
        return !isThereOnlyDrinks() && countOrder() <= 20;
    }
    public boolean isThereOnlyDrinks(){
        for (Menu.dishInfo menu : orderMenu) {
            if (menu.getType() != Menu.Category.DRINK){ // 하나라도 음료 아닌 메뉴 주문이면 Ok
                return false;
            }
        }
        return true;
    }

    public double getTotalPrice() {
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
