package christmas;

import java.text.DecimalFormat;

public class OutputView {

    static DecimalFormat formatter = new DecimalFormat("###,###");
    static public void print(Order order){
        System.out.println("\n<주문 메뉴>");
        for (int i = 0; i < order.getOrderMenu().size(); i++) {
            System.out.println(order.getOrderMenu().get(i).name()+" "+ order.getDishAmount().get(i) +"개");
        }
    }

    static public void printTotalPrice(){
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

    static public void printBenefit(){
        System.out.println("\n<혜택 내역>");
        if(!Event.isEventPossible)
            System.out.println("없음");
        if(Event.event.contains(Event.eventCategory.DDAY_EVENT) && Event.eventCategory.DDAY_EVENT.getDcAmount() > 0)
            System.out.println("크리스마스 디데이 할인: " + formatter.format(-Event.eventCategory.DDAY_EVENT.getDcAmount()) + "원");
        if(Event.event.contains(Event.eventCategory.WEEKDAY_EVENT) && Event.eventCategory.WEEKDAY_EVENT.getDcAmount() > 0)
            System.out.println("평일 할인: " + formatter.format(-Event.eventCategory.WEEKDAY_EVENT.getDcAmount()) + "원");
        if(Event.event.contains(Event.eventCategory.WEEKEND_EVENT) && Event.eventCategory.WEEKEND_EVENT.getDcAmount() > 0)
            System.out.println("주말 할인: " + formatter.format(-Event.eventCategory.WEEKEND_EVENT.getDcAmount()) + "원");
        if(Event.event.contains(Event.eventCategory.SPECIAL_EVENT) && Event.eventCategory.SPECIAL_EVENT.getDcAmount() > 0)
            System.out.println("특별 할인: " + formatter.format(-Event.eventCategory.SPECIAL_EVENT.getDcAmount()) + "원");
        if(Event.presentChampagne)
            System.out.println("증정 이벤트: " + formatter.format(-Menu.dishInfo.샴페인.getPrice()) +"원");
    }

    static public void printTotalBenefit(){
        System.out.println("\n<총혜택 금액>");
        if(Event.getTotalDiscount() == 0){
            System.out.println("0원");
            return;
        }
        System.out.println(formatter.format(-Event.getTotalDiscount()) + "원");
    }

    static public void printPayment(){
        System.out.println("\n<할인 후 예상 결제 금액>");
        System.out.println(formatter.format(Event.getPayment())+"원");
    }
    static public void printBadge(){
        System.out.println("\n<12월 이벤트 배지>");
        if(Event.getBadge() == null){
            System.out.println("없음");
            return;
        }
        System.out.println(Event.getBadge());
    }


}
