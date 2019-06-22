package type;

public enum MovieGenreType {
	COMEDY("코메디"), ADVENTURE("모험"), ACTION("액션"), DRAMA("드라마"), THRILLER("스릴러"), 
	HORROR("호러"), MUSICAL("뮤지컬"), ROMANCE("로맨스"), DOCUMENTARY("다큐멘터리");
	
	private String name;
	
	private MovieGenreType(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}
