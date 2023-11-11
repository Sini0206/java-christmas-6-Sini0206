package christmas;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputView {

    public static int readDate(){
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.\n" +
                "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");
        return Integer.parseInt(Console.readLine());
    }
    public static String[] readOrder(){
        System.out.println("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)");
        String [] input = Console.readLine().trim().split(","); // input:["해산물파스타-2","레드와인-1","초코케이크-1"]

        return input;
    }
}
