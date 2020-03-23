package com.youfan.dao;

import com.youfan.viewResult.Cartcarstatistics;
import com.youfan.viewResult.Syletypestatistics;

import java.util.List;

public interface LiuLiangDao {
    public List<Syletypestatistics> syletypestatistics();

    public List<Syletypestatistics> syletypedaystatistics();

    public List<Syletypestatistics> syletypemonthstatistics();


    public List<Cartcarstatistics> cartcarstatistics();


    public List<Cartcarstatistics> cartcardaystatistics();


    public List<Cartcarstatistics> cartcarmonthstatistics();
}
