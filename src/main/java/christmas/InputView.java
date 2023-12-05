package christmas;

import camp.nextstep.edu.missionutils.Console;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class InputView {
    public static int readDate() {
        System.out.println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");
        int inputDate = 0;

        try {
            String input = Console.readLine();

            if (validateDate(input)){
                inputDate = Integer.parseInt(input);
            }
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            inputDate = readDate();
        }
        return inputDate;
    }
    public static ArrayList<String[]> readOrder(){
        System.out.println("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)");
        String [] inputOrder = Console.readLine().trim().split(","); //   ["해산물파스타-2","레드와인-1","초코케이크-1"]

        ArrayList<String[]> orderList = new ArrayList<>();
        for (int i = 0; i < inputOrder.length; i++) {
            orderList.add(inputOrder[i].trim().split("-")); //  orderList.get(i): [["해산물파스타"],["2"]]
        }
        return orderList;
    }

    private static boolean validateDate(String input) {
        try{    //  방문 날짜가 1에서 31 사이의 숫자가 아닌 경우
            if(Integer.parseInt(input) > 31 || Integer.parseInt(input) < 1) {
                throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
            }
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
        return true;
    }
}