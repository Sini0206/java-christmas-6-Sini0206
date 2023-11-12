package christmas;

import java.util.ArrayList;
import java.util.List;

public class Event {
    static boolean isEventPossible = false;
    static boolean presentChampagne = false;
    boolean isDecemberEvent = false;
    boolean isDDayEvent = false;
    Date date;
    List<eventCategory> event;
    Order order;
    double discount = 0;
    double payment = 0;

    Event(Order order) {
        this.order = order;
    }

    private void checkEventPossible(Order order) {
        if (order.getTotalPrice() >= 10000)
            isEventPossible = true;
    }

    private void presentEvent() {
        if (order.getTotalPrice() > 120000)
            presentChampagne = true;
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
        WEEKDAY_EVENT, WEEKEND_EVENT, SPECIAL_EVENT, DDAY_EVENT
    }

    private void classifyEvents() {
        checkEventPeriod();

        if (isDecemberEvent) {
            if (date.type == Date.dayType.WEEKDAY)  {event.add(eventCategory.WEEKDAY_EVENT);}
            if (date.type == Date.dayType.SATURDAY) {event.add(eventCategory.WEEKEND_EVENT);}
            if (date.type == Date.dayType.HOLIDAY)  {event.add(eventCategory.SPECIAL_EVENT);}
            if (date.type == Date.dayType.SUNDAY)   {
                event.add(eventCategory.WEEKEND_EVENT);
                event.add(eventCategory.SPECIAL_EVENT);
            }
        }
        if(isDDayEvent){event.add(eventCategory.DDAY_EVENT);}
    }

    public void applyEvent() {
        presentEvent();
        classifyEvents();

        if(event.contains(eventCategory.WEEKDAY_EVENT))
            discount(Menu.Category.DESSERT);
        if(event.contains(eventCategory.WEEKEND_EVENT))
            discount(Menu.Category.MAIN_DISH);
        if(event.contains(eventCategory.SPECIAL_EVENT))
            discount(1000);
        if(event.contains(eventCategory.DDAY_EVENT)){
         discount = 1000 + (date.day - 1) * 100;
         payment = Order.getTotalPrice() - discount;
        }
    }
    public void discount(Menu.Category category){
        for (int i = 0; i < order.getOrderMenu().size(); i++) {
            Menu.dishInfo menu = order.getOrderMenu().get(i);
            int number = order.getDishAmount().get(i);

            if (menu.getType() == category) {
                discount += 2023 * number;
                payment = Order.getTotalPrice() - discount;
            }
        }
    }
    public void discount(int money){
        discount = money;
        payment = Order.getTotalPrice() - discount;
    }
}

