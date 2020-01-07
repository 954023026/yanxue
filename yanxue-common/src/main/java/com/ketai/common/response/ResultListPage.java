package com.ketai.common.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * 描述:
 *      返回结果并携带分页信息
 * @author 愿你活的通透拎得清轻重辩得明是非
 * @create 2020-01-06 19:31
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultListPage<T> implements Serializable {

    private T datalist;
    private long allPage;
    private long allCount;
    private long nowPage;
    private long pageSize;

}
