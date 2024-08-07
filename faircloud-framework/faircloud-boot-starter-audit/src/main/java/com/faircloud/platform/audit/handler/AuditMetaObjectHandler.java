package com.faircloud.platform.audit.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.faircloud.platform.audit.constants.AuditConstant;
import org.apache.ibatis.reflection.MetaObject;

import java.util.Date;

public class AuditMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        this.strictInsertFill(metaObject, AuditConstant.CREATE_TIME, Date.class, new Date());
        this.strictInsertFill(metaObject, AuditConstant.UPDATE_TIME, Date.class, new Date());
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.strictUpdateFill(metaObject, AuditConstant.UPDATE_TIME, Date.class, new Date());
    }
}
