package com.ketai.activity.families.vo;

import lombok.Data;

/**
 * 描述:
 *
 * @author 愿你活的通透拎得清轻重辩得明是非
 * @create 2020-01-06 21:40
 */
@Data
public class ActivityCount {
    /**
     * 所有研学风采
     */
    private Integer allRecordNumber;
    /**
     * 研学实践学校
     */
    private Integer allSchNumber;
    /**
     * 研学实践场次
     */
    private Integer allActNumber;
    private Integer allStuNumber;
    private Integer allTchNumber;
    /**
     * 研学人数
     */
    private Integer allPeopleNumber;
    private Integer allBaseNumber;
    private Integer allUndertakeOrgNumber;
    private Integer authNumber;
    private Integer audit2Number;
    private Integer audit4Number;

}
