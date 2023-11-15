package christmas;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Application {

    static Date date;
    static Order order;
    static Event event;
    static String [] menuNameNCount = new String[2];
    static List<Menu.dishInfo> orderMenu = new ArrayList<>(); //  나중에 Order orderMenu로 전달
    static List<Integer> dishCount = new ArrayList<>();    //  나중에 Order(amount)로 전달

    public static void storeMenuNames(String[] input)throws NoSuchElementException {
        List<String> menuNames = new ArrayList<>();     // 변환용(String -> Menu.dishInfo)

        for (int i = 0; i < input.length; i++) {
            menuNameNCount = input[i].trim().split("-"); //  "해산물파스타","2"
            menuNames.add(menuNameNCount[0]);    // "해산물파스타"
        }

        for (int i = 0; i < menuNames.size(); i++) {
            orderMenu.add(Menu.dishInfo.valueOf(menuNames.get(i))); //  "해산물파스타" -> 해산물파스타
        }
    }

    public static void storeAmount(String [] input) throws IllegalArgumentException{
        for (int i = 0; i < input.length; i++) {
            if(Integer.parseInt(menuNameNCount[1]) < 1){    // 메뉴의 개수가 1 이상의 숫자일 경우
                throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해주세요.");
            }
            dishCount.add(Integer.parseInt(menuNameNCount[1]));    // "2" -> 2
        }
    }

    public static void orderGenerator(){
        boolean validateOrder = true;
        try {
            String[] input = InputView.readOrder();
            storeMenuNames(input);
            storeAmount(input);
            order = new Order(date, orderMenu, dishCount);
        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해주세요.");
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            validateOrder = false;
        }
        if(!validateOrder)
            orderGenerator();
    }

    public static void dateGenerator(){
        date = new Date(InputView.readDate());
    }
    public static void eventGenerator(){ event = new Event(order,date);}
    public static void printOrderResult(){
        OutputView.print(order);
        OutputView.printTotalPrice();
        OutputView.printPresent();
        OutputView.printBenefit();
        OutputView.printTotalBenefit();
        OutputView.printPayment();
        OutputView.printBadge();
    }
    public static void validateMenu(){

    }
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");

        dateGenerator();

        orderGenerator();
        order.checkOrderPossibility();

        eventGenerator();
        event.applyEvent();

        printOrderResult();
    }
}