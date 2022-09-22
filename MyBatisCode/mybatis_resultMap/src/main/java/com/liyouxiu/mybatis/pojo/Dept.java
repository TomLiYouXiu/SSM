package com.liyouxiu.mybatis.pojo;

/**
 * @author liyouxiu
 * @date 2022/9/22 20:37
 */
public class Dept {

    private Integer deprId;

    private String deptName;

    public Dept() {
    }

    public Dept(Integer deprId, String deptName) {
        this.deprId = deprId;
        this.deptName = deptName;
    }

    public Integer getDeprId() {
        return deprId;
    }

    public void setDeprId(Integer deprId) {
        this.deprId = deprId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "deprId=" + deprId +
                ", deptName='" + deptName + '\'' +
                '}';
    }
}
