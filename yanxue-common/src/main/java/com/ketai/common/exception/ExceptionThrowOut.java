package com.ketai.common.exception;


import com.ketai.common.model.response.ResultCode;
public class ExceptionThrowOut {

    public static void cast(ResultCode resultCode){
        throw new KetaiException(resultCode);
    }
}
