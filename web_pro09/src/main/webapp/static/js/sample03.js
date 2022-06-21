/**
 * 
 */
var std = {
    name: "홍길동",
    age: 23,
    gender: "M"
};
/* 
 - 객체는 키 값을 사용하여 속성(멤버 변수) 식별
 - 속성에 모든 자료형이 올 수 있고 그 중 함수 자료형 요소를 메소드라고 함
 - 중괄호를 사용하여 객체를 생성하고 [ ] 또는 .으로 요소 값에 접근
 - 객체 내에서 자신의 속성을 호출할 때 반드시 this키워드를 사용
 - 객체의 모든 속성을 출력하려면 단순 for문이나 while문으로는 
   출력이 불가하니 for in문을 사용해야 함 (for...of 는 에러)
*/

function f1() {
	var res1 = document.getElementById("res1");
	res1.innerHTML += "var std = {" + "<br>";
	res1.innerHTML += "    name: '홍길동'," + "<br>";
	res1.innerHTML += "    age: 23," + "<br>";
	res1.innerHTML += "    gender: 'M'" + "<br>";
	res1.innerHTML += "}" + "<br>";
	console.log(res1);
}

function f2() {
	var res2 = document.getElementById("res2");
	res2.innerHTML += "std.name -> " + std.name + "<br>";
	res2.innerHTML += "std['name'] -> " + std['name'] + "<br>";
}
/* 
- 객체의 속성(filed)에 접근 하는 방법은 두가지. 
  1. 객체명.속성명/요소명/키 값
  2. 객체명['속성명/요소명/키 값']
*/


function f3() {
	var res3 = document.getElementById("res3");
	for(let key in std) {
    	res3.innerHTML += "std['" + key + "'] -> " + std[key] + "<br>";
	};
}
//std.key 도 가능하다.

function f4() {
	// 사용자 입력값을 추출하여 genStudent 에 전달한다.
	// 사용자 입력값이 없는 경우 res4 에 값을 입력하라는 메시지를 출력한다.
	var name = document.getElementById("id_input1_name");
	var age = document.getElementById("id_input1_age");
	var gender = document.getElementById("id_input1_gender");
	var res4 = document.getElementById("res4");
	var n, a, g;

	if(!name.value) {
		res4.innerHTML = "이름을 입력하세요.";
		name.focus();
		return;
	}

	n = name.value;

	if(!age.value) {
		res4.innerHTML = "나이를 입력하세요.";
		age.focus();
		return;
	}
	a = parseInt(age.value);
	
	if(gender.selectedIndex == 0) { // 0은 false
		res4.innerHTML = "성별을 선택하세요.";
		gender.focus();
		return;
	}
	g = gender.value;
	
	var student = genStudent(n, a, g);
	//student의 타입은 object
	
	res4.innerHTML = "";
	for(let key in student) {
    	res4.innerHTML += "student['" + key + "'] -> " + student[key] + "<br>";
	};
}

/*
 [object HTMLInputElement] : 자바스크립트에서 input 텍스트에 있는 값을 가져올 때 발생하는 오류
 							 문자열이나 객체가 아닌 실제값(actual value)을 가져와야 한다.
 사용자가 input값을 입력하지 않았을 때 :	document.getElementById("id_input1_name").value; -> ''
 사용자가 input값을 입력했을 때 : document.getElementById("id_input1_name").value; -> '홍길동'
 */


function f5() {
	var res4 = document.getElementById("res4");
	var res5 = document.getElementById("res5");
	
	if(!res4.innerHTML) {
		res5.innerHTML = "함수로 객체 만들기를 먼저 진행하세요.";
		return;
	}
	
	var name = document.getElementById("id_input1_name");
	var age = document.getElementById("id_input1_age");
	var gender = document.getElementById("id_input1_gender");
	var n, a, g;
	
	n = name.value;
	a = parseInt(age.value);
	g = gender.value;
	
	var student = genStudent(n, a, g);
	
	student.getGender = function() {
		if(this.gender === "M") {
			return "남자";
		} else {
			return "여자";
		}
	};
	//객체에 getGender 라는 속성을 추가한 것. 
	//만약 이미 존재하는 속성이라면 기존 속성 값이 변경된다.
	
	name = document.getElementById("id_input2_name");
	age = document.getElementById("id_input2_age");
	gender = document.getElementById("id_input2_gender");
	
	name.value = student.name;
	age.value = student.age;
	gender.value = student.getGender();
}


function genStudent(name, age, gender) {
	var student = {
		name: name,
		age: age,
		gender: gender
	};
	return student;
} // 함수로 객체 만들기

function f6() {
	var res6 = document.getElementById("res6");
	var width = document.getElementById("id_input3_width");
	var height = document.getElementById("id_input3_height");
	var color = document.getElementById("id_input3_color");
	
	if(!width.value) {
		res6.innerHTML = "너비를 입력하세요.";
		width.focus();
		return;
	}
	
	if(!height.value) {
		res6.innerHTML = "높이를 입력하세요.";
		height.focus();
		return;
	}

	if(!color.value) {
		res6.innerHTML = "색상코드를 입력하세요.";
		color.focus();
		return;
	}
	
	var square = genSquare(width.value, height.value, color.value);
	
	var element = document.createElement("div");
	element.style.width = square.width + "px";
	element.style.height = square.height + "px";
	element.style.backgroundColor = square.color;
	element.innerText = "HTML 태그 객체 생성하여 추가";
	res6.appendChild(element);
	
	/*
	var tag = "<div style='display:inline-block;width:" + square.width + "px;";
	tag += "height:" + square.height + "px;";
	tag += "background-color:" + square.color + ";'>HTML 태그를 문자열로 만들어 innnerHTML 에 설정</div>"
	res6.innerHTML = tag;
	*/
	
	/*
	res6.innerHTML = "<div style='display:inline-block;width:200px;height:200px;background-color:#00FF00;'>"
		+ "HTML 태그를 문자열로 만들어 innnerHTML 에 설정</div>";
	*/
	
	/*
	for(let key in square) {
		if(typeof(square[key]) === "function") {
			res6.innerHTML += "square['" + key + "']() -> " + square[key]() + "<br>";
		} else {
   			res6.innerHTML += "square['" + key + "'] -> " + square[key] + "<br>";
		}
	};
	*/
}
	
function genSquare(width=1, height=1, color="#000000") {
	var square = {
		width : width,
		height : height,
		color : color,
		getArea : function() {
			return this.width * this.height;
		}
	};
	return square;
}

function f7() {
	var name = document.getElementById("student_name");
	var korean = document.getElementById("student_korean");
	var math = document.getElementById("student_math");
	var eng = document.getElementById("student_eng");
	var science = document.getElementById("student_science");
	var res7 = document.getElementById("res7");
	
	if(!name.value) {
		name.focus();
		return;
	}
	
	n = name.value;
	
	if(!korean.value) {
		korean.focus();
		return;
	}

	k = parseInt(korean.value);
	
	if(!math.value) {
		math.focus();
		return;
	}

	m = parseInt(math.value);
	
	if(!eng.value) {
		eng.focus();
		return;
	}

	e = parseInt(eng.value);

	if(!science.value) {
		science.focus();
		return;
	}

	s = parseInt(science.value);
	
	var students = new Array();
	students.push(new Student(n, k, m, e, s));
	
	for(let i in students) {
		res7.innerHTML += students[i] + '<br>';
	}
}

function Student(name, korean, math, english, science) {
	//생성자 함수
	//this = {}; 빈 객체가 암시적으로 만들어진다.
	
	//this가 꼭 필요하다. 빈 객체를 만들어 this에 할당하고
	//함수 본문 실행한 뒤 this에 새로운 프로퍼티를 추가해 this를 수정한다.
	//this를 반환한다.
	
	this.name = name;
	this.korean = korean;
	this.math = math;
	this.english = english;
	this.science = science;
	//새로운 프로퍼티를 this에 추가함.
	//return이 없다면 this.name 등이 반환되지만 return이 있다면 리턴문이 반환된다.
	
	this.getsum = function() {
		return this.korean + this.math + this.english + this.science;
	}
	
	
	this.getaverage = function() {
		return this.getsum() / 4;
	}
	
	this.toString = function() {
		//return name + ',' + this.getsum() + ',' + this.getaverage();
		return `이름 : ${name} / 총점 : ${this.getsum()} / 평균 : ${this.getaverage()}`;
	}
	//toString 함수
	
}

