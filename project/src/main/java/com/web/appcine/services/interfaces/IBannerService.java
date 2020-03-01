package com.web.appcine.services.interfaces;

import com.web.appcine.model.Banner;

import java.util.List;

public interface IBannerService {

    void insert (Banner banner);
    List<Banner> searchAll();
    List<Banner> searchActives();
    void delete(int idBanner);
    Banner searchById(int idBanner);
}
