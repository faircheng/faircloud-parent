package com.faircloud.platform.common.module;

import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 分页返回参数
 *
 * @author Felix Cheng
 */
@Data
@Schema(description = "分页返回参数")
public class PageResult<T extends DTO> extends DTO {

    @Schema(description = "当前页")
    private Long pageNumber;

    @Schema(description = "每页显示条数")
    private Long pageSize;

    @Schema(description = "总数")
    private Long totalCount;

    @Schema(description = "查询数据列表")
    private List<T> data;
}
