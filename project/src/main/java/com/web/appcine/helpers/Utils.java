package com.web.appcine.helpers;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

    public class Utils {

        /**
         * Metodo que regresa una Lista de Strings con las fechas siguientes, segun el parametro count
         * @param count
         * @return
         */
        public static List<String> getNextDays(int count) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            // Today's Date
            Date start = new Date();
            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.DAY_OF_MONTH, count); // Next N days from now
            Date endDate = cal.getTime();

            GregorianCalendar gcal = new GregorianCalendar();
            gcal.setTime(start);
            List<String> nextDays = new ArrayList<String>();
            while (!gcal.getTime().after(endDate)) {
                Date d = gcal.getTime();
                gcal.add(Calendar.DATE, 1);
                nextDays.add(sdf.format(d));
            }
            return nextDays;
        }

        public static String saveImage(MultipartFile multipartFile, HttpServletRequest request) {
            String nombreOriginal = multipartFile.getOriginalFilename().replace(" ", "-");
            String rutaFinal = request.getServletContext().getRealPath("/resources/images/movies/");
            System.out.println(rutaFinal);
            try {
                File imageFile = new File(rutaFinal + nombreOriginal);
                multipartFile.transferTo(imageFile);
                return nombreOriginal;
            } catch (IOException e) {
                System.out.println("Error " + e.getMessage());
                return null;
            }
        }
    }

