package exam01;

public class Grade {
	
	private String name; //과목명
	private double score; //점수, 0~100까지의 정수
	private char rank; //등급, A~F까지의 등급
	private char[] rankArr = 
			new char[] {'F','F','F','F','F','E','D','C','B','A','A'};
	
	public Grade(String name) {
		this.name = name;
	}
	
	public Grade(String name, double score) {
		this.name = name;
		
		this.setScore(score);
		
		//21,22번 줄을 18번 한줄 코드로 만듦.
		//this.score = score;
		//this._setRank(score);
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public double getScore() {
		return score; //(this.)score; this 생략함
	}
	
	public void setScore(double score) {
		this.score = score;
		this._setRank(score);
	}
	
	public char getRank() {
		return rank;
	}
	
	private void _setRank(double score) {
		this.rank = this.rankArr[(int)(this.score / 10)];
		
//		switch((int)(this.score / 10)) {
//			case 10: case 9:
//				this.rank = 'A';	break;
//			case 8:
//				this.rank = 'B';	break;
//			case 7:
//				this.rank = 'C';	break;
//			case 6:
//				this.rank = 'D';	break;
//			case 5:
//				this.rank = 'E';	break;
//			case 4: case 3: case 2: case 1: case 0:
//				this.rank = 'F';
//		}
		
//		if(this.score <= 100 && this.score >= 90) {
//			this.rank = 'A';
//		} else if(this.score < 90 && this.score >= 80) {
//			this.rank = 'B';
//		} else if(this.score < 80 && this.score >= 70) {
//			this.rank = 'C';
//		} else if(this.score < 70 && this.score >= 60) {
//			this.rank = 'D';
//		} else if(this.score < 60 && this.score >= 40) {
//			this.rank = 'E';
//		} else if(this.score < 40) {
//			this.rank = 'F';
//		}
	}

}
