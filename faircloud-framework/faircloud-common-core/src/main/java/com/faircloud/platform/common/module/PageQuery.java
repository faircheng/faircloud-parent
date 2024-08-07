package com.faircloud.platform.common.module;

import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 分页查询对象
 *
 * @author Felix Cheng
 */
@Data
@Schema(description = "分页查询对象")
public class PageQuery extends Query {

    @Schema(description = "当前页")
    private Long pageNumber;

    @Schema(description = "每页显示条数")
    private Long pageSize;

    @Schema(description = "排序方式")
    private List<OrderItem> orders;
}
