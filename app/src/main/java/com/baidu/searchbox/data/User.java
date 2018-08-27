package com.baidu.searchbox.data;

import android.os.Parcel;
import android.os.Parcelable;

import java.text.Format;
import java.util.Locale;

public class User implements Parcelable {

    private String name;

    private int age;
    /** sex = 0/1 */
    private int sex;

    public User () {

    }

    protected User(String name, int age, int sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    /**
     *  将对象序列化成parcel对象
     *
     * */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(age);
        dest.writeInt(sex);

    }

    /**
     * 从parcel中取出序列化的对象
     * */
    public static final Parcelable.Creator<User> CREATOR = new Parcelable.Creator<User>() {
        @Override
        public User createFromParcel(Parcel source) {
            return new User(source);
        }

        @Override
        public User[] newArray(int size) {
            return new User[0];
        }
    };

    private User (Parcel parcel) {
        name = parcel.readString();
        age = parcel.readInt();
        sex = parcel.readInt();
        parcel.readParcelable(Thread.currentThread().getContextClassLoader());
    }

    @Override
    public String toString() {
        super.toString();
        return String.format(Locale.ENGLISH, "User[%s, %d, %s]", name, age, sex);
    }

}
