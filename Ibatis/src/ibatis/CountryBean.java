package ibatis;

import java.io.Serializable;

public class CountryBean implements Serializable{
	private String countryId;
	private String countryName;
	private String regionId;
	private String editField;
	
	private String frmFork;
	
	public String getFrmFork() {
		return frmFork;
	}
	public void setFrmFork(String frmFork) {
		this.frmFork = frmFork;
	}
	public String getEdit() {
		return editField;
	}
	public void setEdit(String edit) {
		this.editField = edit;
	}
	public String getCountryId() {
		return countryId;
	}
	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public String getRegionId() {
		return regionId;
	}
	public void setRegionId(String regionId) {
		this.regionId = regionId;
	}
}
