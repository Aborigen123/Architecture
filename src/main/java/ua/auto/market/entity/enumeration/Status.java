package ua.auto.market.entity.enumeration;

public enum Status {


	accepted("accepted"),
	expectation("expectation"),
	rejected("rejected");

	
private String status;

public String getStatus() {
	return status;
}

public void setStatus(String status) {
	this.status = status;
}

private Status(String status) {
	this.status = status;
}
	
	
}
