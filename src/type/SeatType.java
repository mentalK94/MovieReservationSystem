package type;

public enum SeatType {
	S("S석"), A("A석"), B("B석"), NONEMPTY("■"), EMPTY("□");
	
	private String name;
	
	private SeatType(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}
