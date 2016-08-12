package com.daxing.epubtestdemo.ui.activity;

import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.daxing.epubtestdemo.R;
import com.daxing.epubtestdemo.ui.adapter.FileChooseAdapter;
import com.daxing.epubtestdemo.model.ReadableFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileChooseActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView listView;
    private List<File> fileList;
    private List<ReadableFile> list;
    private FileChooseAdapter adapter;
    public static final String TEST_READABLE_FILE_URL = "TEST_READABLE_FILE_URL";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_choose);
        fileList = getSDCardFile(Environment.getExternalStorageDirectory());
        listView = (ListView) findViewById(R.id.listview_choose_file);
        list = new ArrayList<>();
        for (int i = 0; i < fileList.size(); i++) {
            ReadableFile readableFile = new ReadableFile();
            readableFile.fileURL = fileList.get(i).getPath();
            readableFile.fileName = fileList.get(i).getName();
            readableFile.fileSize = getFileSize(fileList.get(i));
            readableFile.file = fileList.get(i);
            readableFile.format = getFileFormat(fileList.get(i));
            list.add(readableFile);
        }
        adapter = new FileChooseAdapter(this, list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }

    /**
     * 得到文件大小
     * @param file
     * @return
     */
    private static long getFileSize(File file) {
        long size = 0;
        try {
            if (file.isFile()) {
                FileInputStream fis = null;
                fis = new FileInputStream(file);
                size = fis.available();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return size;
    }

    /**
     * 得到所有的可阅读文件，暂定为txt和epub
     * @param dir
     * @return
     */
    private List<File> getSDCardFile(File dir) {
        List<File> res = new ArrayList<>();
        if (dir.isDirectory()) {
            File[] f = dir.listFiles();
            if (f != null) {
                for (int i = 0; i < f.length; i++) {
                    if (f[i].isDirectory()) {
                        res.addAll(getSDCardFile(f[i]));
                    } else {
                        String fileName = f[i].getName().toLowerCase();
                        if (fileName.endsWith(".epub") || fileName.endsWith(".txt")) {
                            res.add(f[i]);
                        }
                    }
                }
            }
        }
        return res;
    }


    /**
     * 得到文件的格式，暂定为txt和epub
     * @param file
     * @return
     */
    private int getFileFormat(File file) {
        int i = -1;
        String fileName = file.getName().toLowerCase();
        if (fileName.endsWith(".txt")) {
            i = ReadableFile.FORMAT_TXT;
        } else if (fileName.endsWith(".epub")) {
            i = ReadableFile.FORMAT_EPUB;
        }
        return i;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Intent intent = new Intent();
//        intent.putExtra(TEST_READABLE_FILE_URL, list.get(i).file.getAbsolutePath());
       intent.putExtra("TEST_READABLE_FILE",list.get(i));
        intent.setClass(FileChooseActivity.this, ReadBookActivity.class);
        startActivity(intent);
    }

}
