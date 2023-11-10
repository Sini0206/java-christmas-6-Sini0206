package christmas;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    String menuName;
    public enum menuType{
        APPETIZER, MAIN_DISH, DESSERT, DRINK;
    }

    enum menuGroup {
        양송이수프(6000,menuType.APPETIZER), 타파스(5500,menuType.APPETIZER),
        시저샐러드(8000,menuType.APPETIZER),
        티본스테이크(55000,menuType.MAIN_DISH), 바베큐립(54000,menuType.MAIN_DISH),
        해산물파스타(35000,menuType.MAIN_DISH), 크리스마스파스타(25000,menuType.MAIN_DISH),
        초코케이크(15000,menuType.DESSERT), 아이스크림(5000,menuType.DESSERT),
        제로콜라(3000,menuType.DRINK), 레드와인(60000,menuType.DRINK), 샴페인(25000,menuType.DRINK);
        private final int price;
        private menuType type;
        menuGroup(int _price, menuType _type) {
            this.price = _price;
            this.type = _type;
        }
        public int getPrice() {
            return this.price;
        }
        public menuType getType(){
            return this.type;
        }
    }

}
