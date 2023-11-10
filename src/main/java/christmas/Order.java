package christmas;

public class Order {
    Date date;
    Menu.menuGroup orderMenu;
    int orderAmount;
    int totalPrice;
    Order(Date date, Menu.menuGroup order, int amount){
        this.date = date;
        this.orderMenu = order;
        this.orderAmount = amount;
        this.totalPrice = orderMenu.getPrice() * amount;
    }

    public void checkOrderPossibility(){

    }
}
