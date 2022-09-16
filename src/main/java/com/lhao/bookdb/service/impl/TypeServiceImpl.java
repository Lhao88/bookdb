package com.lhao.bookdb.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lhao.bookdb.bean.Type;
import com.lhao.bookdb.service.TypeService;
import com.lhao.bookdb.mapper.TypeMapper;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class TypeServiceImpl extends ServiceImpl<TypeMapper, Type>
    implements TypeService{

}




