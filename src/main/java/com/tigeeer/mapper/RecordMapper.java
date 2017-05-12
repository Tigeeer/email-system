package com.tigeeer.mapper;

import com.tigeeer.pojo.Record;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Created by IntelliJ IDEA.
 * User: tigeeer
 * Date: 2017/5/12
 * Time: 15:58
 */
@Mapper
public interface RecordMapper {

    @Select("INSERT INTO records VALUE(#{r.address}, #{r.title}, #{r.content}, #{r.completed}, #{r.reason}, #{r.sendTime})")
    void insert(@Param("r") Record record);
}
