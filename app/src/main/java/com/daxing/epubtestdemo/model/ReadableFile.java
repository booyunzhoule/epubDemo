package com.daxing.epubtestdemo.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.File;

/**
 * Created by LE on 2016/8/9.
 */
public class ReadableFile implements Parcelable{
    public static final  int FORMAT_TXT = 1;
    public static final int FORMAT_EPUB = 2;

    public long fileSize;//文件大小
    public String fileName;//文件的名称
    public String fileURL;//文件的地址
    public File file;//文件
    public int format;

    public ReadableFile() {
    }

    protected ReadableFile(Parcel in) {
        fileSize = in.readLong();
        fileName = in.readString();
        fileURL = in.readString();
        format = in.readInt();
    }

    public static final Creator<ReadableFile> CREATOR = new Creator<ReadableFile>() {
        @Override
        public ReadableFile createFromParcel(Parcel in) {
            return new ReadableFile(in);
        }

        @Override
        public ReadableFile[] newArray(int size) {
            return new ReadableFile[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(fileSize);
        dest.writeString(fileName);
        dest.writeString(fileURL);
        dest.writeInt(format);
    }
}
