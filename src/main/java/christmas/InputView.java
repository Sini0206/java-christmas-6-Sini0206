package christmas;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputView {

    public static String[] readOrder(){
        System.out.println("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)");
        String [] input = Console.readLine().trim().split(","); // input:["해산물파스타-2","레드와인-1","초코케이크-1"]

        return input;
    }
}
