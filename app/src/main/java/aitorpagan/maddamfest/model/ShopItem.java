package aitorpagan.maddamfest.model;

import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

import aitorpagan.maddamfest.R;

/**
 * Created by aitorpagan on 16/4/16.
 */
public class ShopItem implements Parcelable{
    private int photo;
    private String name;
    private String description;
    private String price;

    public ShopItem() {

    }

    public ShopItem(int photo, String name, String description, String price) {
        this.photo = photo;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    protected ShopItem(Parcel in) {
        photo = in.readInt();
        name = in.readString();
        description = in.readString();
        price = in.readString();
    }

    public static final Creator<ShopItem> CREATOR = new Creator<ShopItem>() {
        @Override
        public ShopItem createFromParcel(Parcel in) {
            return new ShopItem(in);
        }

        @Override
        public ShopItem[] newArray(int size) {
            return new ShopItem[size];
        }
    };

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(photo);
        dest.writeString(name);
        dest.writeString(description);
        dest.writeString(price);
    }

    public static ArrayList<ShopItem> getDefaultItems(){
        ShopItem si1 = new ShopItem(R.drawable.stop,"objeto 1","descr 1", "9,99€");
        ShopItem si2 = new ShopItem(R.drawable.stop,"objeto 2","descr 2", "9,99€");
        ShopItem si3 = new ShopItem(R.drawable.stop,"objeto 3","descr 3", "9,99€");
        ShopItem si4 = new ShopItem(R.drawable.stop,"objeto 4","descr 4", "9,99€");
        ShopItem si5 = new ShopItem(R.drawable.stop,"objeto 5","descr 5", "9,99€");
        ShopItem si6 = new ShopItem(R.drawable.stop,"objeto 6","descr 6", "9,99€");
        ArrayList<ShopItem> al = new ArrayList<>();
        al.add(si1);
        al.add(si2);
        al.add(si3);
        al.add(si4);
        al.add(si5);
        al.add(si6);
        return al;
    }
}
