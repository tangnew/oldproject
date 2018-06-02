package com.model.tuser;

import java.io.Serializable;

public class TUser implements Serializable {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = -2300438244319587273L;

	private Long id;

    private String name;

    private String position;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position == null ? null : position.trim();
    }
}