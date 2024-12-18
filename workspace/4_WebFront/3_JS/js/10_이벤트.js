// 인라인 이벤트 모델 확인하기

// 버튼의 배경색, 글자색 변경
function test1(button) {
    button.style.backgroundColor = "lightblue";
    button.style.color = "white";
}


// 고전 이벤트 모델 확인하기

// 고전 / 표준 이벤트 모델은 렌더링된 HTML 요소에 
// 이벤트 관련 동작을 부여하는 코드

// -> 랜더링 되지 않은 요소에는 이벤트 관련 동작을 추가할 수 없다!! 
//    (문제 원인 : HTML 코드 해석 순서 (위 -> 아래))

// --> 해결 방법 : HTML 요소가 먼저 랜더링된 후 JS 코드 수행
document.getElementById("test2-1").onclick = function () {
    // 익명 함수(이벤트 핸들러에 많이 사용)
    alert("고전 이벤트 모델 확인창");
}


// 이벤트 제거
document.getElementById("test2-2").onclick = function () {

    // test2-1 이벤트 제거
    document.getElementById("test2-1").onclick = null;
    alert("test2=1의 이벤트를 제거함");
}

// 고전 이벤트 모델 단점
// -> 한 요소의 동일한 이벤트 리스터(onclick)에 대한 
//    다수의 이벤트 핸들러(배경색 변경, 폰트 변경)를 작성할 수 없다. 
//    (작성 시 마지막으로 해석된 이벤트 핸들러만 적용됨)
document.getElementById("test2-3").onclick = function (even) {

    // 버튼 색 바꾸기
    // 방법 1) 요소를 문서에서 찾아서 선택  
    // document.getElementById("text2-3").style.backgroundColor = "red";

    // 방법 2) 매개변수 e 또는 event활용하기
    // -> 이벤트 핸들러에 e 도는 event를 작성하는 경우
    //    해당 이벤트와 관련된 모든 정보가 담긴 입벤트 객체가 반환됨
    // console.log(event);

    // event.target : 이벤트가 발생한 요소
    event.target.style.backgroundColor = "skyBlue";

    // 방법 3) this 활용하기 
    console.log(this)
    this.style.backgroundColor = "green";

}

// document.getElementById("test2-3").onclick = function(){

//     document.getElementById("text2-3").style.fontSize = "30px";
// }


// 표준 이벤트 모델
document.getElementById("test3").addEventListener("click", function () {

    // this : 이벤트가 발생한 요소
    console.log(this.clientWidth); // 현재 요소의 너비(테두리 제외)

    // 현재 요소의 너비를 300px로 변경
    // this.style.width = '300px'

    this.style.width = this.clientWidth + 20 + 'px';


})

// test3에 이미 click 이벤트에 대한 동작이 존재하는데 중복해서 적용
document.getElementById("test3").addEventListener("click", function () {

    this.style.height = this.clientHeight + 20 + 'px';
})


/* 복습 문제 */
// document.getElementById("changeBtn1").addEventListener("click", function () {

//     const div1 = document.getElementById("div1");
//     const input1 = document.getElementById('input1');

//     const bgColor = input1.value;
//     div1.style.backgroundColor = bgColor;

// })

/* input1에 값이 변경되었을 때 입력된 값으로 배경색 변경 후
   작성된 값 초기화 */

document.getElementById("input1").addEventListener("change", function () {

    // change 이벤트
    // - text 관련 input 태그는
    //   입력된 값이 변할 때 change라고 하지 않고
    //   입력이 완료된 후 포커스를 잃거나, 엔터를 입력하는 경우에
    //   입력된 값이 이전과 다를 경우 change 이벤트가 발생한 것으로 인식함

    const div1 = document.getElementById("div1");

    div1.style.backgroundColor = this.value;

    this.value = '';

})


document.getElementById("moveNaver").addEventListener("click", function (e) {
    // 매개변수 e 또는 event = 이벤트 발생 객체
    //                        (이벤트와 관련된 정보가 담겨있는 객체)

    e.preventDefault(); // HTML 요소가 가지고 있는 기본 이벤트를 막음(제거)
})

// form 태그 기본 이벤트 제거
// 방법 1. submit 버튼 사용 안하는 방법
document.getElementById("testBtn1").addEventListener("click", function (e) {

    // #in1에 입력된 값 얻어오기
    const in1 = document.getElementById("in1").value;

    // #in1에 작성된 값이 "제출"일 경우 testForm1을 submit
    if (in1 == "제출") {
        // ** form 태그에 name 속성이 있을 경우 직접 선택 가능
        // document.[form태그의 name 속성 값]
        document.testForm1.submit();

        // ** form요소.submit() : form 요소 제출 함수
    }
})

// 방법2. onsubmit을 이용해서 form 태그 제출 막기
function checkIn2() {

    // #in2에 "제출"이 입력된 경우에만 submit(return true)
    const in2 = document.getElementById("in2").value;

    if (in2 == "제출") {
        return true;
    } else {
        return false;
    }
}