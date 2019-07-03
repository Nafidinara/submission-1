package com.nafidinara.onesubmission;

import android.os.Parcel;
import android.os.Parcelable;

public class Item implements Parcelable {
    private int image;
    private int image_bg;
    private String name;
    private String release;
    private String overview;

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getImage_bg() {
        return image_bg;
    }

    public void setImage_bg(int image_bg) {
        this.image_bg = image_bg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRelease() {
        return release;
    }

    public void setRelease(String release) {
        this.release = release;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.image);
        dest.writeInt(this.image_bg);
        dest.writeString(this.name);
        dest.writeString(this.release);
        dest.writeString(this.overview);
    }

    public Item() {
    }

    protected Item(Parcel in) {
        this.image = in.readInt();
        this.image_bg = in.readInt();
        this.name = in.readString();
        this.release = in.readString();
        this.overview = in.readString();
    }

    public static final Parcelable.Creator<Item> CREATOR = new Parcelable.Creator<Item>() {
        @Override
        public Item createFromParcel(Parcel source) {
            return new Item(source);
        }

        @Override
        public Item[] newArray(int size) {
            return new Item[size];
        }
    };
}
