package com.faircloud.platform.common.contants;

/**
 * 系统所有常量定义类
 * @author Fair Cheng
 */
public class PlatformConstants {

    /**
     * 字母
     */
    public final static String LETTER = new String("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ");

    /**
     * 数字
     */
    public final static String NUMBER = new String("0123456789");

    /**
     * 能上传的最大文件大小
     */
    public final static Integer MAX_FILE_SIZE = 10;

    /**
     * 重试次数
     */
    public static final int NEED_RETRY = 3;

    /**
     * 验证码缓存key
     */
    public static final String VERIFY_CODE_CACHE = "verify_code_cache:";

    /**
     * 数据字典类型缓存
     */
    public static final String DICT_TYPE_CACHE = "sys_dict_type_cache:";

    /**
     * 数据字典数据缓存
     */
    public static final String DICT_DATA_CACHE = "sys_dict_data_cache:";
}
