package game;

import java.util.Random;

public class GuessNum {
	
	private Random rd = new Random();
	private int limitCnt = 10;
	private int randomNumber;
	
	public GuessNum() {
		this.randomNumber = rd.nextInt(100)+1;
	}
	
	public GuessNum(int rangMax) {
		this.randomNumber = rd.nextInt(rangMax)+1;
	}
	
	public GuessNum(int rangMax, int count) {
		this.randomNumber = rd.nextInt(rangMax)+1;
		this.limitCnt = count;
	}
	
	public GuessNum(int rangMin, int rangMax, int count) {
		this.randomNumber = rd.nextInt(rangMax - rangMin)+ (rangMin + 1);
		this.limitCnt = count;
	}
	
	
	public Result guessing(int num) {
		Result res = new Fail();
		this.limitCnt--;
		
		if(this.limitCnt > 0) {
			if(this.randomNumber > num) {
				res = new Up();
			} else if(this.randomNumber < num) {
				res = new Down();
			} else if(this.randomNumber == num) {
				res = new Correct();
			}
		} else if(this.limitCnt == 0) {
			if(this.randomNumber == num) {
				res = new Correct();
			}
		}
		return res;
	}

}
