package com.exam.entity;

/**
 * Created by JW.
 * User: JW
 * Date: Nov 4, 2016 
 * Time: 5:22:45 PM
 *
 * com.exam.entity.QuestionType
 */
public class QuestionType extends BaseEntity {
	private String name;
	private String fkAccountId;
	private Integer status;
	private Integer autoJudgeFlag;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFkAccountId() {
		return fkAccountId;
	}

	public void setFkAccountId(String fkAccountId) {
		this.fkAccountId = fkAccountId;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getAutoJudgeFlag() {
		return autoJudgeFlag;
	}

	public void setAutoJudgeFlag(Integer autoJudgeFlag) {
		this.autoJudgeFlag = autoJudgeFlag;
	}

}
