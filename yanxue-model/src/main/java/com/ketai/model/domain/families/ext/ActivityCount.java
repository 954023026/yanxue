package com.ketai.model.domain.families.ext;

import lombok.Data;

/**
 * 描述:
 *  统计数量
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
    /**
     * 学生数量
     */
    private Integer allStuNumber;
    /**
     * 老师数量
     */
    private Integer allTchNumber;
    /**
     * 研学人数
     */
    private Integer allPeopleNumber;
    /**
     * 基地数
     */
    private Integer allBaseNumber;
    /**
     * 承办机构数量
     */
    private Integer allUndertakeOrgNumber;
    /**
     * 待审核
     */
    private Integer authNumber;
    private Integer audit2Number;
    private Integer audit4Number;

}
