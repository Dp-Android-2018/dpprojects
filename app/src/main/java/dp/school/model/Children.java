package dp.school.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by DELL on 22/01/2018.
 */

public class Children implements Parcelable{
    private String childrenTitle;
    private boolean isChecked;
    public Children(String childrenTitle,boolean isChecked) {
        this.childrenTitle = childrenTitle;
        this.isChecked=isChecked;
    }


    public String getChildrenTitle() {
        return childrenTitle;
    }

    public void setChildrenTitle(String childrenTitle) {
        this.childrenTitle = childrenTitle;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Children)) return false;

        Children artist = (Children) o;

        if (isChecked() != artist.isChecked()) return false;
        return getChildrenTitle() != null ? getChildrenTitle().equals(artist.getChildrenTitle()) : artist.getChildrenTitle() == null;

    }

    @Override
    public int hashCode() {
        int result = getChildrenTitle() != null ? getChildrenTitle().hashCode() : 0;
        result = 31 * result + (isChecked() ? 1 : 0);
        return result;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(childrenTitle);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Children> CREATOR = new Creator<Children>() {
        @Override
        public Children createFromParcel(Parcel in) {
            return new Children(in);
        }

        @Override
        public Children[] newArray(int size) {
            return new Children[size];
        }
    };

    protected Children(Parcel in) {
        childrenTitle = in.readString();
    }
}
