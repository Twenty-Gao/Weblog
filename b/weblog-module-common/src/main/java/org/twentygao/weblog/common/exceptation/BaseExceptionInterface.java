package org.twentygao.weblog.common.exceptation;

public interface BaseExceptionInterface {
    //用于获取异常码
    String getErrorCode();
//用于获取异常信息
    String getErrorMessage();
}