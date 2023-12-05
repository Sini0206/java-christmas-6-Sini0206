package christmas;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Application {

    static Date date;
    static Order order;
    static Event event;
    static List<Menu.dishInfo> MenuNames = new ArrayList<>();    //  나중에 Order orderMenu로 전달
    static List<Integer> dishCount = new ArrayList<>();    //  나중에 Order(amount)로 전달
    static boolean validateOrder = true;

    public static void storeMenuNames(ArrayList<String[]> input) throws NoSuchElementException {
        for (int i = 0; i < input.size(); i++) {
            String menuName = input.get(i)[0];    //  "해산물파스타"
            MenuNames.add(Menu.dishInfo.valueOf(menuName));    //  "해산물파스타" -> 해산물파스타
        }
    }

    public static void storeAmount(List<String[]> input) throws IllegalArgumentException {
        for (int i = 0; i < input.size(); i++) {
            int number = Integer.parseInt(input.get(i)[1]); //  "2" -> 2

            if (number < 1) {    // 메뉴의 개수가 1 미만의 숫자일 경우
                throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해주세요.");
                //validateOrder = false;
            }
            dishCount.add(number);
        }
    }

    public static void orderGenerator() {
        ArrayList<String[]> input = InputView.readOrder();
        storeMenuNames(input);
        storeAmount(input);
        order = new Order(date, MenuNames, dishCount);
    }

    public static void checkValidateOrder() {
        try {
            orderGenerator();
        } catch (NoSuchElementException e) {    //  없는 메뉴 검색한 경우
            throw new IllegalArgumentException();
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 유효하지 않은 주문입니다. 다시 입력해주세요.");
            validateOrder = false;
        }

        if (!validateOrder)
            orderGenerator();
    }

    public static void dateGenerator() {
        date = new Date(InputView.readDate());
    }

    public static void eventGenerator() {
        event = new Event(order, date);
    }

    public static void printOrderResult() {
        OutputView.print(order);
        OutputView.printTotalPrice();
        OutputView.printPresent();
        OutputView.printBenefit();
        OutputView.printTotalBenefit();
        OutputView.printPayment();
        OutputView.printBadge();
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");

        dateGenerator();

        checkValidateOrder();
        order.checkOrderPossibility();

        eventGenerator();
        event.applyEvent();
        event.giveBadge();

        printOrderResult();
    }
}