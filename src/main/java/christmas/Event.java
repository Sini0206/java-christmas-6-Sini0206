package christmas;

import java.util.ArrayList;
import java.util.List;

public class Event {
    boolean isEventPossible = false;
    Order order;
    public void checkEventPossible(Order order){
        if(order.getTotalPrice() >= 10000)
            isEventPossible = true;
    }
}
