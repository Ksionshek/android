package com.example.lab4_znowu.tasks;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class TaskListContent {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<Task> ITEMS = new ArrayList<Task>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, Task> ITEM_MAP = new HashMap<String, Task>();

    private static final int COUNT = 5;

    static {
        // Add some sample items.
        for (int i = 1; i <= COUNT; i++) {
            addItem(createDummyItem(i));
        }
    }

    public static void addItem(Task item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    private static Task createDummyItem(int position) {
        return new Task(String.valueOf(position), "name " + position, "surrname" +position, "phone"+position, "birth"+position );
    }

    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about Item: ").append(position);
        for (int i = 0; i < position; i++) {
            builder.append("\nMore details information here.");
        }
        return builder.toString();
    }

    public static void removeItem(int position){
        String itemId = ITEMS.get(position).id;
        ITEMS.remove(position);
        ITEM_MAP.remove(itemId);
    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class Task implements Parcelable {
        public final String id;
        public final String name;
        public final String picPath;
        public final String surrname;
        public final String phone;
        public final String birth;


        public Task(String id, String name, String surrname, String picPath, String phone, String birth) {
            this.id = id;
            this.name = name;
            this.surrname = surrname;
            this.picPath = picPath;
            this.phone = phone;
            this.birth = birth;
        }
        public Task(String id, String name, String surrname,String phone, String birth) {
            this.id = id;
            this.name = name;
            this.surrname = surrname;
            this.picPath = "";
            this.phone=phone;
            this.birth=birth;
        }


        protected Task(Parcel in) {
            id = in.readString();
            name = in.readString();
            picPath = in.readString();
            surrname = in.readString();
            phone = in.readString();
            birth= in.readString();
        }

        public static final Creator<Task> CREATOR = new Creator<Task>() {
            @Override
            public Task createFromParcel(Parcel in) {
                return new Task(in);
            }

            @Override
            public Task[] newArray(int size) {
                return new Task[size];
            }
        };


        @Override
        public String toString() {
            return name;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(id);
            dest.writeString(name);
            dest.writeString(picPath);
            dest.writeString(surrname);
            dest.writeString(phone);
            dest.writeString(birth);
        }

    }
}
