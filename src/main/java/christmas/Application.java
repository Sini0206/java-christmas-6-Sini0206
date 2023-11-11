package christmas;

import java.util.ArrayList;
import java.util.List;

public class Application {

    static Date date;
    static String [] menuNameNCount = new String[2];
    static List<Menu.dishInfo> orderMenu = new ArrayList<>(); //  나중에 Order orderMenu로 전달
    static List<Integer> dishCount = new ArrayList<>();    //  나중에 Order(amount)로 전달
    static Order order;
    static Event event = new Event();

    public static void storeMenuNames(String[] input){
        List<String> menuNames = new ArrayList<>();     // 변환용(String -> Menu.dishInfo)

        for (int i = 0; i < input.length; i++) {
            menuNameNCount = input[i].trim().split("-"); //  "해산물파스타","2"
            menuNames.add(menuNameNCount[0]);    // "해산물파스타"
        }

        for (int i = 0; i < menuNames.size(); i++) {
            orderMenu.add(Menu.dishInfo.valueOf(menuNames.get(i)));
        }
    }
    public static void storeAmount(String [] input){
        for (int i = 0; i < input.length; i++) {
            menuNameNCount = input[i].trim().split("-"); //  "해산물파스타","2"
            dishCount.add(Integer.parseInt(menuNameNCount[1]));    // "2" -> 2
        }
    }

    public static void orderGenerator(){
        String [] input = InputView.readOrder();
        storeMenuNames(input);
        storeAmount(input);
        order = new Order(date,orderMenu,dishCount);
    }

    public static void dateGenerator(){
        date = new Date(InputView.readDate());
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        dateGenerator();
        orderGenerator();

        order.checkOrderPossibility();
        Event.checkEventPossible(order);
        event.presentEvent(order);

        OutputView.print(order);
        OutputView.printTotalPrice();
        OutputView.printPresent();
    }
}
