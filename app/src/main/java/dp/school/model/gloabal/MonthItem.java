package dp.school.model.gloabal;

/**
 * Created by PC on 09/01/2018.
 */

public class MonthItem {
   private String month;
   private int id;

   public MonthItem(String month){
       this.month=month;
   }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getMonth() {
        return month;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
