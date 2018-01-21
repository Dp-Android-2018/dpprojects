package dp.school.model;

/**
 * Created by PC on 09/01/2018.
 */

public class DayItem {
   private String day;
   private int date;


   public DayItem(String day,int date){
      this.day=day;
      this.date=date;
   }

    public void setDay(String day) {
        this.day = day;
    }

    public String getDay() {
        return day;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }


}
