package vo;

public class RiskVo {
	public RiskVo(String riskContent, String possibility, String effectLevel, String thresholdValue, String submitter, String tracker, String state, String description) {
		this.riskContent = riskContent;
		this.possibility = possibility;
		this.effectLevel = effectLevel;
		this.thresholdValue = thresholdValue;
		this.submitter = submitter;
		this.tracker = tracker;
		this.state = state;
		this.description = description;
	}
	
	
	private String riskContent;
	private String possibility;
	private String effectLevel;
	private String thresholdValue;
	private String submitter;
	private String tracker;
	
	private String state;
	private String description;
	
	public String getRiskContent() {
		return riskContent;
	}
	
	public void setRiskContent(String riskContent) {
		this.riskContent = riskContent;
	}
	
	public String getPossibility() {
		return possibility;
	}
	
	public void setPossibility(String possibility) {
		this.possibility = possibility;
	}
	
	public String getEffectLevel() {
		return effectLevel;
	}
	
	public void setEffectLevel(String effectLevel) {
		this.effectLevel = effectLevel;
	}
	
	public String getThresholdValue() {
		return thresholdValue;
	}
	
	public void setThresholdValue(String thresholdValue) {
		this.thresholdValue = thresholdValue;
	}
	
	public String getSubmitter() {
		return submitter;
	}
	
	public void setSubmitter(String submitter) {
		this.submitter = submitter;
	}
	
	public String getTracker() {
		return tracker;
	}
	
	public void setTracker(String tracker) {
		this.tracker = tracker;
	}
	
	public String getState() {
		return state;
	}
	
	public void setState(String state) {
		this.state = state;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String toTable() {			
		return "<tr><td>" + this.riskContent + "</td><td>" + this.possibility + "</td><td>" + this.effectLevel + "</td><td>"
					+ this.thresholdValue + "</td><td>" + this.submitter + "</td><td>" + this.tracker + "</td><td>" + this.state + "</td><td>" + this.description + "</td></tr>"; 
	}
}
