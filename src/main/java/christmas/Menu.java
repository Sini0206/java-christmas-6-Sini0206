package christmas;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    String menuName;
    public enum Category{
        APPETIZER, MAIN_DISH, DESSERT, DRINK;
    }

    enum dishInfo {
        양송이수프(6000,Category.APPETIZER), 타파스(5500,Category.APPETIZER),
        시저샐러드(8000,Category.APPETIZER),
        티본스테이크(55000,Category.MAIN_DISH), 바베큐립(54000,Category.MAIN_DISH),
        해산물파스타(35000,Category.MAIN_DISH), 크리스마스파스타(25000,Category.MAIN_DISH),
        초코케이크(15000,Category.DESSERT), 아이스크림(5000,Category.DESSERT),
        제로콜라(3000,Category.DRINK), 레드와인(60000,Category.DRINK), 샴페인(25000,Category.DRINK);
        private final int price;
        private Category type;
        dishInfo(int price, Category type) {
            this.price = price;
            this.type = type;
        }
        public int getPrice() {
            return this.price;
        }
        public Category getType(){
            return this.type;
        }
    }

}
