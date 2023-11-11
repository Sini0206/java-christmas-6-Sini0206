package christmas;

import java.util.ArrayList;
import java.util.List;

public class Event {
    static boolean isEventPossible = false;
    static boolean presentChampagne = false;
    boolean isDecemberEvent = false;
    boolean isDDayEvent = false;
    Date date;
    static public void checkEventPossible(Order order){
        if(order.getTotalPrice() >= 10000)
            isEventPossible = true;
    }

    public void presentEvent(Order order){
        if(order.getTotalPrice() > 120000)
            presentChampagne = true;
    }
    
    public void checkEventPeriod(){
        if(isEventPossible){
            if(date.day >= 1 && date.day <= 31)
                isDecemberEvent = true;
            if(date.day >= 1 && date.day <= 25)
                isDDayEvent = true;
        }
    }

    enum decemberEvent{
        WEEKDAY_EVENT, WEEKEND_EVENT, SPECIAL_EVENT
    }
}
