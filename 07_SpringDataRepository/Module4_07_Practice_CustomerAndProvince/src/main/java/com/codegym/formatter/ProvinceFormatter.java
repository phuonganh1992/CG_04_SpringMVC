package com.codegym.formatter;

import com.codegym.model.Province;
import com.codegym.service.province.IProvinceService;
import org.hibernate.engine.jdbc.internal.Formatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProvinceFormatter implements Formatter<Province> {
    private IProvinceService provinceService;

    @Autowired
    public ProvinceFormatter(IProvinceService provinceService) {
        this.provinceService = provinceService;
    }

    @Override
    public String format(String source) {
        return null;
    }
}
