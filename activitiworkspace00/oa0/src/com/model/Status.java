package com.model;

public enum Status {
	NOT_START(0L, "Not Start"), START(1L, "Start"), AUDIT_ING(2L, "Auditing"), SUCCESSFUL(
			3L, "Successful"), FAIL(4L, "Fail");
	private Long id;
	private String name;

	private Status(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public static Status getStatusById(Long id) {
		for (Status temp : Status.values()) {
			if (temp.getId().longValue() == id.longValue()) {
				return temp;
			}
		}
		return NOT_START;
	}
}
