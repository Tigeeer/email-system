package com.tigeeer.service;

import com.tigeeer.mapper.RecordMapper;
import com.tigeeer.pojo.Record;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;

/**
 * Created by IntelliJ IDEA.
 * User: tigeeer
 * Date: 2017/5/12
 * Time: 16:00
 */
@Service
public class RecordService {

    private RecordMapper recordMapper;

    public RecordService(RecordMapper recordMapper) {
        this.recordMapper = recordMapper;
    }

    public void insert(Record record) {
        record.setSendTime(Timestamp.from(Instant.now()));
        recordMapper.insert(record);
    }
}
