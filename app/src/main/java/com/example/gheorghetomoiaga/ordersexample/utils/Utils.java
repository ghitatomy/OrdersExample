package com.example.gheorghetomoiaga.ordersexample.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class Utils {
    public static Bitmap getBitmapByEncodedString(String base64String) {
        String imageDataBytes = base64String.substring(base64String.indexOf(",")+1);
        InputStream stream = new ByteArrayInputStream(Base64.decode(imageDataBytes.getBytes(), Base64.DEFAULT));
        return BitmapFactory.decodeStream(stream);
    }
}
