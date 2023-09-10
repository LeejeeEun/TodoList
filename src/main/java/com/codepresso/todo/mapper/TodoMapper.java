package com.codepresso.todo.mapper;

import com.codepresso.todo.vo.Todo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TodoMapper {
    void save(@Param("todo") Todo todo);
}
