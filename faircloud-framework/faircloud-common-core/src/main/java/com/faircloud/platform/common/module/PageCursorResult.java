package com.faircloud.platform.common.module;

import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 游标分页返回参数
 *
 * @author Felix Cheng
 */
@Data
@Schema(description = "游标分页返回参数")
public class PageCursorResult<T extends DTO> extends DTO {

    @Schema(description = "当请求的返回结果被截断时，可以使用Marker获取从当前截断位置之后的内容")
    private String marker;

    @Schema(description = "返回结果的条数，当返回结果达到 MaxItems 限制被截断时，返回参数IsTruncated将等于true。取值范围：1~1000。默认值：100", defaultValue = "100")
    private Integer maxItems;

    @Schema(description = "请求返回结果是否被截断")
    private Boolean isTruncated;

    @Schema(description = "返回对象")
    private List<T> data;
}
