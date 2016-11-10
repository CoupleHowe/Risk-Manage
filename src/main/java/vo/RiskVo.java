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
		
		String _possibility = null;
		String _effectLevel = null;
		String _state = null;
		String _description = null;
		
		if(this.possibility.equals("high"))
			_possibility = "高";
		else if(this.possibility.equals("middle"))
			_possibility = "中";
		else if(this.possibility.equals("low"))
			_possibility = "低";
		
		if(this.effectLevel.equals("high"))
			_effectLevel = "高";
		else if(this.effectLevel.equals("middle"))
			_effectLevel = "中";
		else if(this.effectLevel.equals("low"))
			_effectLevel = "低";
		
		if(this.state.equals("not found"))
			_state = "未发现";
		else
			_state = this.state;
		
		if(this.description.equals("null"))
			_description = "无";
		else
			_description = this.description;
			
		return "<tr><td>" + this.riskContent + "</td><td>" + _possibility + "</td><td>" + _effectLevel + "</td><td>"
					+ this.thresholdValue + "</td><td>" + this.submitter + "</td><td>" + this.tracker + "</td><td>" + _state + "</td><td>" + _description + "</td></tr>"; 
	}
}
