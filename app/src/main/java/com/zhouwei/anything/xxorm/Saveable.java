package com.zhouwei.anything.xxorm;

import android.content.ContentValues;

import java.lang.reflect.Field;


/**
 * Created by zhouwei on 2017/12/22.
 */

public class Saveable {
    public void save(ContentValues values) {
        Field[] fields = getClass().getDeclaredFields();
        if (null != fields) {
            for (int i = 0; i < fields.length; i++) {
                try {
                    Field field = fields[i];
                    field.setAccessible(true);
                    String fieldName = field.getName();
                    String value = String.valueOf(field.get(this));
                    values.put(fieldName, value);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
