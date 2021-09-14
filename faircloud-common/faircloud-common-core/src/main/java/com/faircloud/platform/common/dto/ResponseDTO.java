package com.faircloud.platform.common.dto;

import com.faircloud.platform.common.enums.HttpStatus;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 公用返回类
 * @author fair cheng
 */
@Data
@NoArgsConstructor
@ApiModel(value = "统一返回结果处理")
public class ResponseDTO<T> implements Serializable {

    /**
     * http 状态码
     */
    @ApiModelProperty(value = "状态码", example = "200")
    private Integer code;

    /**
     * 返回信息
     */
    @ApiModelProperty(value = "返回信息")
    private String msg;

    /**
     * 返回的数据
     */
    @ApiModelProperty(value = "返回的数据")
    private T data;

    public ResponseDTO(Integer code){
        this.code = code;
    }

    public ResponseDTO(Integer code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public ResponseDTO(Integer code, String msg, T data){
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static ResponseDTO success(){
        return new ResponseDTO(HttpStatus.OK.value());
    }

    public static ResponseDTO success(Object data){
        return new ResponseDTO(HttpStatus.OK.value(),"成功",data);
    }

    public static <T> ResponseDTO<T> success(String msg,final T data){
        return new ResponseDTO(HttpStatus.OK.value(),msg,data);
    }

    public static ResponseDTO fail(){
        return new ResponseDTO(HttpStatus.INTERNAL_SERVER_ERROR.value());
    }

    public static <T> ResponseDTO<T> fail(T data){
        return new ResponseDTO(HttpStatus.INTERNAL_SERVER_ERROR.value(),null,data);
    }

    public static ResponseDTO fail(String msg){
        return new ResponseDTO(HttpStatus.INTERNAL_SERVER_ERROR.value(),msg);
    }

    public static <T> ResponseDTO<T> fail(String msg,T data){
        return new ResponseDTO(HttpStatus.INTERNAL_SERVER_ERROR.value(),msg,data);
    }

    public static ResponseDTO fail(Integer code,String msg){
        return new ResponseDTO(code,msg);
    }

}
