package christmas;

public class Date {
    int day;
    dayType type;
    Date(int inputDay){
        day = inputDay;
        //type = classifyType();
    }
    enum dayType{
        SATURDAY,SUNDAY,HOLIDAY
    }
    private dayType classifyType(){
        if (day == 25)
            type = dayType.HOLIDAY;
        for (int week = 0; week < 5 ; week++) {
            if(day == 3 + 7 * week)
                type = dayType.SUNDAY;
            if(day == 2 + 7 * week)
                type = dayType.SATURDAY;
        }

        return type;
    }

}
