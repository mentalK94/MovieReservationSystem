package type;

public enum MovieRatingType {
	ALL("전체이용가"), TWELVE("12세 이용가"), FIFEEN("15세 이용가"), NINETEEN("19세 이용가(청소년 관람불가)");
	
	private String name;
	
	private MovieRatingType(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}
