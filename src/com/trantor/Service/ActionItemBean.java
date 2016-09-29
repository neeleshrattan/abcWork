package com.trantor.Service;

public class ActionItemBean {
	
	
	private String actionItemName;
	private String byWhen;
	private String byWhom;
	boolean valid;
	
	
	public boolean isValid() {
		return valid;
	}
	public void setValid(boolean valid) {
		this.valid = valid;
	}
	public String getActionItemName() {
		return actionItemName;
	}
	public void setActionItemName(String actionItemName) {
		this.actionItemName = actionItemName;
	}
	public String getByWhen() {
		return byWhen;
	}
	public void setByWhen(String byWhen) {
		this.byWhen = byWhen;
	}
	public String getByWhom() {
		return byWhom;
	}
	public void setByWhom(String byWhom) {
		this.byWhom = byWhom;
	}
	

}
