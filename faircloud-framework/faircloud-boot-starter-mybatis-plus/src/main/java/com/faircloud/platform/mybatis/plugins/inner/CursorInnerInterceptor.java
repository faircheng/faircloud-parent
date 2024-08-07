package com.faircloud.platform.mybatis.plugins.inner;

import java.sql.SQLException;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.pagination.dialects.IDialect;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
/**
 * 游标分页拦截器
 *
 * @author Felix Cheng
 */
@Slf4j
@Data
@NoArgsConstructor
public class CursorInnerInterceptor extends PaginationInnerInterceptor {

    public CursorInnerInterceptor(DbType dbType) {
        super(dbType);
    }

    public CursorInnerInterceptor(IDialect dialect) {
        super(dialect);
    }

    /**
     * 这里进行count,如果count为0这返回false(就是不再执行sql了)
     */
    @Override
    public boolean willDoQuery(Executor executor, MappedStatement ms, Object parameter, RowBounds rowBounds,
        ResultHandler resultHandler, BoundSql boundSql) throws SQLException {
        // 游标分页 判断是否有下一页，设置IsTruncated，把Marker游标设置为最新的位置
        return super.willDoQuery(executor, ms, parameter, rowBounds, resultHandler, boundSql);
    }

    @Override
    public void beforeQuery(Executor executor, MappedStatement ms, Object parameter, RowBounds rowBounds,
        ResultHandler resultHandler, BoundSql boundSql) throws SQLException {
        // 游标分页 select * from iam_users where id > #{marker} limit #{maxItems}
        super.beforeQuery(executor, ms, parameter, rowBounds, resultHandler, boundSql);
    }
}
