package christmas;

import java.text.DecimalFormat;

public class OutputView {
    static public void print(Order order){
        System.out.println("\n<주문 메뉴>");
        for (int i = 0; i < order.getOrderMenu().size(); i++) {
            System.out.println(order.getOrderMenu().get(i).name()+" "+ order.getDishAmount().get(i) +"개");
        }
    }

    static public void printTotalPrice(){ 
        DecimalFormat formatter = new DecimalFormat("###,###");
        System.out.println("\n<할인 전 총주문 금액>");
        System.out.println(formatter.format(Order.getTotalPrice())+"원");
    }

    static public void printPresent(){
        System.out.println("\n<증정 메뉴>");
        if(Event.presentChampagne == true)
            System.out.println("샴페인 1개");
        if(Event.presentChampagne == false)
            System.out.println("없음");
    }
}
