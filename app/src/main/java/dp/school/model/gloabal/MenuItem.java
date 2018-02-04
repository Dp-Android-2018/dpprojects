package dp.school.model.gloabal;

/**
 * Created by PC on 09/01/2018.
 */

public class MenuItem {
   private String title;
   private int resourceId;


    public MenuItem(String title,int resourceId){
        this.title=title;
        this.resourceId=resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getResourceId() {
        return resourceId;
    }

    public String getTitle() {
        return title;
    }
}
