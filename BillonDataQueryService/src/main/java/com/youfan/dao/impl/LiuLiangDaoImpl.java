package com.youfan.dao.impl;

import com.youfan.dao.LiuLiangDao;
import com.youfan.mappers.LiuLiangMapper;
import com.youfan.viewResult.Cartcarstatistics;
import com.youfan.viewResult.Syletypestatistics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LiuLiangDaoImpl implements LiuLiangDao {

    @Autowired
    private LiuLiangMapper liuLiangMapper;

    @Override
    public List<Syletypestatistics> syletypestatistics() {
        return liuLiangMapper.syletypestatistics();
    }

    @Override
    public List<Syletypestatistics> syletypedaystatistics() {
        return liuLiangMapper.syletypedaystatistics();
    }

    @Override
    public List<Syletypestatistics> syletypemonthstatistics() {
        return liuLiangMapper.syletypemonthstatistics();
    }

    @Override
    public List<Cartcarstatistics> cartcarstatistics() {
        return liuLiangMapper.cartcarstatistics();
    }

    @Override
    public List<Cartcarstatistics> cartcardaystatistics() {
        return liuLiangMapper.cartcardaystatistics();
    }

    @Override
    public List<Cartcarstatistics> cartcarmonthstatistics() {
        return liuLiangMapper.cartcarmonthstatistics();
    }
}
