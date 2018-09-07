package com.anthony.trans.producer.mapper;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * Created by BG343891 on 2018/9/4.
 */
public interface CommonMapper<T> extends Mapper<T>, MySqlMapper<T> {
}
