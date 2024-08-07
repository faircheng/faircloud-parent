package com.faircloud.platform.common.module;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Data;

/**
 * 游标分页查询对象
 *
 * @author Felix Cheng
 */
@Data
@Schema(description = "游标分页查询对象")
public class PageCursorQuery extends Query {

    @Schema(description = "当请求的返回结果被截断时，可以使用Marker获取从当前截断位置之后的内容")
    private Long marker = 0L;

    @Min(value = 1)
    @Max(value = 1000)
    @Schema(description = "返回结果的条数，当返回结果达到 MaxItems 限制被截断时，返回参数IsTruncated将等于true。取值范围：1~1000。默认值：100", defaultValue = "100")
    private Integer maxItems = 100;
}
