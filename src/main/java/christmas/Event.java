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
    Event(Order order){
        this.order = order;
    }

    public void checkEventPossible(Order order){
        if(order.getTotalPrice() >= 10000)
            isEventPossible = true;
    }

    public void presentEvent(){
        if(order.getTotalPrice() > 120000)
            presentChampagne = true;
    }

    public void checkEventPeriod(){
        checkEventPossible(order);

        if(isEventPossible){
            if(date.day >= 1 && date.day <= 31)
                isDecemberEvent = true;
            if(date.day >= 1 && date.day <= 25)
                isDDayEvent = true;
        }
    }
    enum eventCategory{
        WEEKDAY_EVENT, WEEKEND_EVENT, SPECIAL_EVENT, DDAY_EVENT
    }
    public void applyEvent() {
        checkEventPeriod();

        if(isDecemberEvent) {
            if (date.type == Date.dayType.WEEKDAY)
                event.add(eventCategory.WEEKDAY_EVENT);
            if (date.type == Date.dayType.SATURDAY)
                event.add(eventCategory.WEEKEND_EVENT);
            if (date.type == Date.dayType.HOLIDAY)
                event.add(eventCategory.SPECIAL_EVENT);
            if (date.type == Date.dayType.SUNDAY) {
                event.add(eventCategory.WEEKEND_EVENT);
                event.add(eventCategory.SPECIAL_EVENT);
            }
        }
        if(isDDayEvent)
            event.add(eventCategory.DDAY_EVENT);
    }
}
