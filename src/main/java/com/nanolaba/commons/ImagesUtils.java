package com.nanolaba.commons;


import org.apache.commons.io.IOUtils;

import javax.swing.*;
import java.awt.*;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ImagesUtils {

    public static Dimension getJPEGDimension(InputStream in) throws IOException {

        byte[] bytes = IOUtils.toByteArray(in);

        Dimension d = null;

        try (InputStream fis = new ByteArrayInputStream(bytes)) {
            // check for SOI marker
            if (fis.read() != 255 || fis.read() != 216)
                throw new RuntimeException("SOI (Start Of Image) marker 0xff 0xd8 missing");


            while (fis.read() == 255) {
                int marker = fis.read();
                int len = fis.read() << 8 | fis.read();

//            if (marker == 192) {
                if (marker >= 192 && marker <= 207 && marker != 196 && marker != 200 && marker != 204) {
                    fis.skip(1);

                    int height = fis.read() << 8 | fis.read();
                    int width = fis.read() << 8 | fis.read();

                    d = new Dimension(width, height);
                    break;
                }

                fis.skip(len - 2);
            }

        }

        if (d == null) {
            ImageIcon imageIcon = new ImageIcon(bytes);
            int height = imageIcon.getIconHeight();
            int width = imageIcon.getIconWidth();
            d = new Dimension(width, height);
        }

        return d;
    }
}
