/** 
 *
 .getAttribute() : 선택한 요소(element)의 특정 속성(attribute)의 값을 가져옵니다.
  ex) element.getAttribute( 'attributename' )
  var jb = document.getElementById( 'xyz' ).getAttribute( 'title' );
  는 id의 값이 xyz인 요소의 title 속성 값을 변수 jb에 저장합니다.
 
 .setAttribute() : 선택한 요소(element)의 속성(attribute) 값을 정합니다.
  ex) element.setAttribute( '속성 이름', '속성값' )
  document.getElementById( 'xyz' ).setAttribute( 'title', 'This is title' )
  id 값이 xyz인 요소의 title 속성을 This is title로 정합니다. 
  만약 이미 속성값이 존재한다면 그 값을 지우고 새 값을 적용합니다.
  
  .removeAttribute() : 요소의 속성을 제거하는 메서드입니다.
  ex) element.removeAttribute( attributename )
  document.getElementsByTagName( 'h1' )[0].removeAttribute( 'class' );
  는 문서의 첫번째 h1 요소의 class 속성을 제거합니다.
  (동적배열이므로 [0]을 지워준다.)
  
 */
 
$(function() {
	createOptionMonth();
	$(".allchk").bind("click", function(e) {
		toggleAll(this);
	});
});
 
/*
$(function() {
	createOptionMonth();
});
*/
 
/* 
window.onload = function() {
	createOptionMonth();
}
*/

 function createOptionMonth() {
	var selects = document.querySelectorAll("select[data-calendar='month']");
	//querySelectorAll 메서드는 요소들이 배열형태로 정적 NodeList에 담겨 반환된다.
	console.log(selects);
	for(let select of selects){
		for(let month = 1; month < 13; month++) {
			let option = document.createElement("option");
			option.setAttribute("value", month);
			option.innerText = `${month} 월`;
			select.append(option);
		}
		//append는 appendChild와 다르게 노드 객체 or Text 를 사용할 수 있다. return값 없음.
		//appendChild는 노드 객체만 받을 수있다. return값 있음.
		
		var calendarId = select.getAttribute("data-calendar-id");
		if(calendarId) {
			let dateSelect = document.querySelector(`[data-calendar='date']` + 
			`[data-calendar-id='${calendarId}']`);
			select.addEventListener("change",function(e) {
				createOptionDate(this, dateSelect);
			});
		}
	}
}

function createOptionDate(month, element) {
	var date = new Date();
	date.setMonth(month.value, 0);
	
	var count = element.childElementCount;
	
	if(count > 1) {
		for(let idx = 1; idx < count; idx++) {
			element.removeChild(element.children[1]);
		}
	}
	
	for(let num = 1; num <= date.getDate(); num++) {
		let option = document.createElement("option");
		option.setAttribute("value",num);
		option.innerHTML = `${num} 일`;
		element.append(option);
	}
}

function toggleAll(element) {
	var name = element.getAttribute("name");
	console.log(name);
	//name 속성의 값(chk1)을 가져온다.
	var checkboxs = document.getElementsByName(name);
	console.log(checkboxs);
	//name=chk1 즉 Name 중에 chk1을 가진 요소를 NodeList에 배열로 담는다.
	
	if(element.getAttribute("checked") === null) {
		for(checkbox of checkboxs) {
			checkbox.setAttribute("checked","");
			checkbox.checked = true;
		}
	} else {
		for(checkbox of checkboxs) {
			checkbox.removeAttribute("checked");
			checkbox.checked = false;
		}
	}
}

/*
function toggleAll(element) {
	console.log(element);
	var name = element.getAttribute("name");
	console.log(name);
	var checkboxs = document.getElementsByName(name);
	console.log(checkboxs);
	
	var c = element.getAttribute("checked");
	console.log(c);
	
	if(c === null) {
		for(checkbox of checkboxs) {
			checkbox.setAttribute("checked","");
			checkbox.checked = true;
		}
	} else {
		for(checkbox of checkboxs) {
			checkbox.removeAttribute("checked");
			checkbox.checked = false;
		}
	}
	
}
*/


