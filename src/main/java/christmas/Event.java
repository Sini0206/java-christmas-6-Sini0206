package christmas;

import java.util.ArrayList;
import java.util.List;

public class Event {
    static boolean isEventPossible = false;
    static boolean presentChampagne = false;
    boolean isDecemberEvent = false;
    boolean isDDayEvent = false;
    Date date;
    static List<eventCategory> event = new ArrayList<>();
    static Order order;
    static private double totalDiscount = 0;
    static double weekDC, weekendDC, dDayDC;
    static final double specialDC = 1000;

    Event(Order order, Date date) {
        this.order = order;
        this.date = date;
    }

    private void checkEventPossible(Order order) {
        if (order.getTotalPrice() >= 10000)
            isEventPossible = true;
    }

    private void presentEvent() {
        if (order.getTotalPrice() > 120000){
            presentChampagne = true;
            totalDiscount += Menu.dishInfo.샴페인.getPrice();
        }
    }

    private void checkEventPeriod() {
        checkEventPossible(order);

        if (isEventPossible) {
            if (date.day >= 1 && date.day <= 31)
                isDecemberEvent = true;
            if (date.day >= 1 && date.day <= 25)
                isDDayEvent = true;
        }
    }

    enum eventCategory {
        WEEKDAY_EVENT(weekDC), WEEKEND_EVENT(weekendDC), SPECIAL_EVENT(specialDC), DDAY_EVENT(dDayDC);
        private double dcAmount;
        eventCategory(double amount){
            this.dcAmount = amount;
        }
        public double getDcAmount() {
            return this.dcAmount;
        }
    }

    private void classifyEvents() { // 날짜 - 이벤트 연관
        checkEventPeriod();

        if (isDecemberEvent) {
            if (date.type == Date.dayType.WEEKDAY) {
                event.add(eventCategory.WEEKDAY_EVENT);
            }
            if (date.type == Date.dayType.SATURDAY) {
                event.add(eventCategory.WEEKEND_EVENT);
            }
            if (date.type == Date.dayType.HOLIDAY) {
                event.add(eventCategory.SPECIAL_EVENT);
            }
            if (date.type == Date.dayType.SUNDAY) {
                event.add(eventCategory.WEEKEND_EVENT);
                event.add(eventCategory.SPECIAL_EVENT);
            }
        }
        if (isDDayEvent) {
            event.add(eventCategory.DDAY_EVENT);
        }
    }

    public void applyEvent() { //   이벤트 - 할인 연관
        presentEvent();
        classifyEvents();

        if (event.contains(eventCategory.WEEKDAY_EVENT))
            totalDiscount += discountWithMenu(Menu.Category.DESSERT,eventCategory.WEEKDAY_EVENT);
        if (event.contains(eventCategory.WEEKEND_EVENT))
            totalDiscount += discountWithMenu(Menu.Category.MAIN_DISH,eventCategory.WEEKEND_EVENT);
        if (event.contains(eventCategory.SPECIAL_EVENT))
            totalDiscount += discount(1000,eventCategory.SPECIAL_EVENT);
        if (event.contains(eventCategory.DDAY_EVENT)) {
            totalDiscount += discountWithDate(eventCategory.DDAY_EVENT);
        }
    }

    public double discountWithMenu(Menu.Category category, eventCategory event) {
        for (int i = 0; i < order.getOrderMenu().size(); i++) {
            Menu.dishInfo menu = order.getOrderMenu().get(i);
            int number = order.getDishAmount().get(i);

            if (menu.getType() == category) {
                event.dcAmount += 2023 * (double) number;
            }
        }
        return event.dcAmount;
    }

    public double discount(double money, eventCategory event){
        event.dcAmount = money;
        return event.dcAmount;
    }

    public double discountWithDate(eventCategory event){
        event.dcAmount = 1000 + (date.day - 1) * 100;
        return event.dcAmount;
    }

    static public double getTotalDiscount(){
        return totalDiscount;
    }
    static public double getPayment(){
        double payment = Order.getTotalPrice() - totalDiscount;
        if(presentChampagne)
            payment += Menu.dishInfo.샴페인.getPrice();
        return payment;
    }

}


