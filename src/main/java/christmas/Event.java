package christmas;

import java.util.ArrayList;
import java.util.List;

public class Event {
    static boolean isEventPossible = false;
    static boolean presentChampagne = false;
    Date date;
    static public void checkEventPossible(Order order){
        if(order.getTotalPrice() >= 10000)
            isEventPossible = true;
    }

    public void presentEvent(Order order){
        if(order.getTotalPrice() > 120000)
            presentChampagne = true;
    }
}
