package type;

public enum MessageType {
	ERROR("입력 오류입니다.."), INPUT("예약번호를 입력하세요 : "), SHOW("조회를 완료했습니다."), CANCEL("취소를 완료했습니다");
	
	private String message;
	
	private MessageType(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}
}
