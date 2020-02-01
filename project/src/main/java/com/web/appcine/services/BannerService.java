package com.web.appcine.services;

import com.web.appcine.model.Banner;
import com.web.appcine.services.interfaces.IBannerService;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

@Service
public class BannerService implements IBannerService {

    private List<Banner> banners;

    public BannerService() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        banners = new LinkedList<>();
        try {
            banners.add(new Banner(1,"Banner1",formatter.parse("20-06-2020"),"slide6.jpg","Activo"));
            banners.add(new Banner(2,"Banner2",formatter.parse("12-05-2020"),"slide2.jpg","Activo"));
            banners.add(new Banner(3,"Banner3",formatter.parse("18-06-2019"),"slide3.jpg","Activo"));
            banners.add(new Banner(4,"Banner4",formatter.parse("02-10-2020"),"slide4.jpg","Inactivo"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insert(Banner banner) {
        banners.add(banner);
    }

    @Override
    public List<Banner> searchAll() {
        return banners;
    }
}
