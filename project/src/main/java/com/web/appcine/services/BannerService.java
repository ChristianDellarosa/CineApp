package com.web.appcine.services;

import com.web.appcine.model.Banner;
import com.web.appcine.repository.BannersRepository;
import com.web.appcine.services.interfaces.IBannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class BannerService implements IBannerService {

    @Autowired
    private BannersRepository bannersRepository;

    @Override
    public void insert(Banner banner) {
        bannersRepository.save(banner);
    }

    @Override
    public List<Banner> searchAll() {
        return bannersRepository.findAll();
    }

    @Override
    public List<Banner> searchActives() {
        return bannersRepository.findByStatusOrderByIdDesc("Activo");
    }

    @Override
    public void delete(int idBanner) {
        bannersRepository.deleteById(idBanner);
    }

    @Override
    public Banner searchById(int idBanner) {
        Optional<Banner> optional = bannersRepository.findById(idBanner);
        if (optional.isPresent()) {
            return optional.get();
        }
        return null;
    }
}
