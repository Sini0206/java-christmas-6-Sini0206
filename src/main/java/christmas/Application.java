package christmas;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Application {

    static Date date;
    static Order order;
    static Event event;
    static List<Menu.dishInfo> menuNames = new ArrayList<>();    //  나중에 Order orderMenu로 전달
    static List<Integer> dishCount = new ArrayList<>();    //  나중에 Order(amount)로 전달

    public static void storeMenuNames(ArrayList<String[]> input) {
        for (int i = 0; i < input.size(); i++) {
            String menuName = input.get(i)[0];    //  "해산물파스타"
            menuNames.add(Menu.dishInfo.valueOf(menuName));    //  "해산물파스타" -> 해산물파스타
        }
    }

    public static void checkDuplicatedMenu() {
        if (menuNames.stream().distinct().count() != menuNames.size()) {
            throw new IllegalArgumentException("중복");
        }
    }

    public static void storeAmount(List<String[]> input) throws IllegalArgumentException {
        for (int i = 0; i < input.size(); i++) {
            int number = Integer.parseInt(input.get(i)[1]); //  "2" -> 2

            if (number < 1) {    // 메뉴의 개수가 1 미만의 숫자일 경우
                throw new IllegalArgumentException("1 미만");
            }
            dishCount.add(number);
        }
    }

    public static void orderGenerator() {
        ArrayList<String[]> input = InputView.readOrder();
        storeMenuNames(input);
        checkDuplicatedMenu();
        storeAmount(input);

        order = new Order(date, menuNames, dishCount);
    }

    public static void checkValidateOrder() {
        try {
            orderGenerator();
        } catch (NoSuchElementException e) {
            System.out.println();
        } catch (IllegalArgumentException e) {
            getReorder();
        }
        if(!order.checkPossibility())
            getReorder();
    }

    public static void orderInitializer() {
        menuNames.clear();
        dishCount.clear();
        System.out.println("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }

    public static void getReorder(){
        orderInitializer();
        checkValidateOrder();
    }

    public static void dateGenerator() {
        date = new Date(InputView.readDate());
    }

    public static void eventGenerator() {
        event = new Event(order, date);
    }

    public static void printOrderResult() {
        OutputView.print(order);
        OutputView.printTotalPrice(order);
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

        eventGenerator();
        event.applyEvent();
        event.calculatePayment();
        event.giveBadge();

        printOrderResult();
    }
}