package christmas;

public class OutputView {
    static public void print(Order order){
        System.out.println("<주문 메뉴>");
        for (int i = 0; i < order.getOrderMenu().size(); i++) {
            System.out.println(order.getOrderMenu().get(i).name()+" "+ order.getDishAmount().get(i) +"개");
        }
    }
}
