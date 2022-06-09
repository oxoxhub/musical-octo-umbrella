/**
 * 
 */
 function f1() {
	console.log("함수가 실행되었습니다.");
}

 function f2() {
	return "리턴이 있는 함수";
}

 function f3() {
	//return;
	//one function === one thing
	//아무것도 적지 않았을 때 리턴되는 것은 undefined
}

var f4 = function() { 
	return "익명함수 입니다."
};

(function() {
	console.log("즉시 실행하는 함수 입니다.");
})();

function f5(x) {
	console.log("매개변수 x 의 값 - >" + x);
}
//자바스크립트의 함수는 매개변수의 타입 명시가 없다
//매개변수가 없을 시 undefined, 매개변수 초과시 무시
//동적타입이라 number,String 등 모두 가능

function f6(x, y=0) {
	console.log("매개변수 x, y의 값 -> " + x + "," + y);
}

function f7(x, ...args) {
	console.log("매개변수 x 의 값 -> " + x);
	console.log("가변매개변수 args의 값들 -> ");
	for(let arg of args) {
		console.log("\t" + arg);
	}
	/*
	console.log(args[0]);
	console.log(args[1]);
	console.log(args[2]);
	console.log(args[3]);
	*/
}
//가변매개변수는 배열이다.
//가변은 항상 마지막이여야한다.

function f8(x, y=0, ...args) {
	console.log("매개변수 x 의 값 - >" + x);
	console.log("매개변수 y 의 값 - >" + y);
	console.log("가변매개변수 args의 값들 -> ");
	for(let arg of args) {
		console.log("\t" + arg);
	}
}

function f9() {
	console.log(arguments);
}

/*
var f10 = () => {
	return "익명 함수";
};
*/
var f10 = () => "익명 함수";
var f11 = (x) => x + 10;
