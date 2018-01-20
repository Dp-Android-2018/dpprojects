package dp.school.base.utils;


/**
 * Created by PC on 20/12/2017.
 */
public class ImageConfigurations {

  private int width,height,quality;

  public ImageConfigurations(int width,int height,int quality){
      this.width=width;
      this.height=height;
      this.quality=quality;
  }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public int getQuality() {
        return quality;
    }

    public int getWidth() {
        return width;
    }
}