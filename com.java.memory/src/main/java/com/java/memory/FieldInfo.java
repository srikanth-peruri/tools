package com.java.memory;

import java.util.Map;

public class FieldInfo {
	private int fieldIndex;
	private String fieldLabel;
	private String fieldApiName;
	private String displayType;
	private boolean fieldUdateable;
	private boolean nameField;
	private boolean hidden;
	private boolean accessible;
	private String referenceObject;
	private Map<String, String> currentRecordMap;

	public FieldInfo() {
		// Default Constructor
	}

	public FieldInfo(String argFieldLabel, String argFieldApiName, String argDisplayType, boolean argFieldUdateable,
			boolean argNameField) {
		super();
		this.fieldLabel = argFieldLabel;
		this.fieldApiName = argFieldApiName;
		this.displayType = argDisplayType;
		this.fieldUdateable = argFieldUdateable;
		this.nameField = argNameField;
	}

	public String getFieldLabel() {
		return this.fieldLabel;
	}

	public void setFieldLabel(String argFieldLabel) {
		this.fieldLabel = argFieldLabel;
	}

	public String getFieldApiName() {
		return this.fieldApiName;
	}

	public void setFieldApiName(String argFieldApiName) {
		this.fieldApiName = argFieldApiName;
	}

	public String getDisplayType() {
		return this.displayType;
	}

	public void setDisplayType(String argDisplayType) {
		this.displayType = argDisplayType;
	}

	public boolean isFieldUdateable() {
		return this.fieldUdateable;
	}

	public void setFieldUdateable(boolean argFieldUdateable) {
		this.fieldUdateable = argFieldUdateable;
	}

	public boolean isNameField() {
		return this.nameField;
	}

	public void setNameField(boolean argNameField) {
		this.nameField = argNameField;
	}

	public boolean isHidden() {
		return this.hidden;
	}

	public void setHidden(boolean argAlreadyExists) {
		this.hidden = argAlreadyExists;
	}

	@Override
	public String toString() {
		String toString = null;
		if (this.fieldApiName != null) {
			StringBuilder sb = new StringBuilder();
			sb.append("=====");
			sb.append("Field API Name : ").append(this.fieldApiName).append(",");
			sb.append("Label : ").append(this.fieldLabel).append(",");
			sb.append("Type : ").append(this.displayType).append(",");
			sb.append("Is Name Field : ").append(this.nameField).append(",");
			sb.append("Is Updateable : ").append(this.fieldUdateable).append(",");
			sb.append("Is Hidden : ").append(this.hidden).append(",");
			sb.append("=====");
			toString = sb.toString();
		}
		return toString;
	}

	public Map<String, String> getCurrentRecordMap() {
		return this.currentRecordMap;
	}

	public void setCurrentRecordMap(Map<String, String> argCurrentRecordMap) {
		this.currentRecordMap = argCurrentRecordMap;
	}

	public String getReferenceObject() {
		return this.referenceObject;
	}

	public void setReferenceObject(String argReferenceObject) {
		this.referenceObject = argReferenceObject;
	}

	public boolean isAccessible() {
		return this.accessible;
	}

	public void setAccessible(boolean argAccessible) {
		this.accessible = argAccessible;
	}

	public int getFieldIndex() {
		return fieldIndex;
	}

	public void setFieldIndex(int fieldIndex) {
		this.fieldIndex = fieldIndex;
	}

}
