package type;

public enum MenuType {
	RESERVATION("좌석예매"), SHOWALL("전체조회"), SHOWINDIVIDUAL("개인조회"), CANCEL("예매취소"), EXIT("종료");
	
	private String name;
	
	private MenuType(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}
