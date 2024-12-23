// 태그 선택자

// ready() 함수 : 문서가 로딩 된 후 마지막에 수행하는 함수
$(document).ready(function () {
    $("h5").css("color", "green");

    // 자바스크립트로 했을 경우
    // document.getElementsByTagName('p').style.color = 'red' // 에러 발생 
    // -> 배열에 스타일 적용 불가

    const arr = document.getElementsByTagName("p");
    for (let item of arr) {
        item.style.color = 'yellow';
    }

    // -> 배열에 요소를 하나씩 꺼내서 적용하는건 가능하나 불편

    // h5, p 두 태그의 배경색을 동시에 blue로 지정하기
    // jQuery 선택자는 css 선택자와 같다. 
    $("h5, p").css("backgroundColor", "blue");

})


// 클래스 선택자
$(function () { // ready() 함수
    // 클래스가 item인 요소의 글자색을 orange로 변경
    $(".item").css("color", "orange");

    // 클래스가 select인 요소의 배경색을 green으로 변경
    $('.select').css('backgroundColor', 'green');

    // 클래스가 item, select를 동시에 가지고 있는 요소만
    // 글자 크기를 50ox 로 변경

    $('.item.select').css('fontSize', '50px');

})

const regExp = /^[a-z][a-zA-Z0-9]{7,19}$/;

$('#input1').on('input', function () {
    // on() == addEventListener()
    // -> 특정 이벤트 박생 시 동작(이벤트 핸들러) 지정

    // input 이벤트 : 입력과 관련된 모든 행위

    // 1) 작성된 값이 정규 표현식에 맞는 형식인지 검사
    if (regExp.test($("input").val())) {
        // 2) 정규표현식에 맞는 경우
        $("#span1").text("유효한 문자열 형식입니다.");
        $("#span1").css("color", "green");
    } else {
        $('#span1').text("유효하지 않은 문자열 형식입니다.").css('color', 'red');
    }
    // method-chaining : 하나의 대상에 대하여 여러 메소드를 연달아 작성하는 기술

})
// 자식, 후손 선택자
$(() => {
    // 클래스가 area인 요소의 자식 중 h4 글자색 red
    $(".area > h4").css('color', 'red')
})

// 클래스가 area인 요소의 후손 중에 ul 후손 중에
// 클래스가 qqq인 요소 배경색 원하는 걸로 바꾸기


// 클래스가 area인 요소의 후손 중
// 클래스가 qqq인 요소의 폰트 크기를 30px로 변경

$(".area > ul > .qqq").css("backgroundColor", 'green');

$(".area .qqq").css("fontSize", '30px');


// 내용이 "사과"인 요소를 선택해서
// 배경 빨강색, 글자는 흰색으로 변경
$(".area li > h4").css("backgroundColor", 'red').css("color", 'white')

// 속성 선택자
$("#check").on("click", function () {

    // name 속성값이 gender인 요소 선택
    // console.log($('input[name = "gender"]'));

    // name 속성 값이 gender인 요소 중 check된 요소 선택
    const gender = $('input[name = "gender"]:checked')

    console.log(gender.length);
    // 아무것도 check 안한 경우 : 0
    // check 한 경우 : 1

    if (gender.length == 0) {
        alert("성별을 선택해주세요.")
    } else {

        // 1) 체크된 요소를 얻어왔으므로 
        //    gender 변수에서 value만 얻어오기 (순수 JS)
        console.log(gender[0].value);

        // 2) 체크된 요소를 모두 얻어와도
        //    radio는 1개만 체크되기 때문에
        //    변수 한 개랑 같다고 해석하여
        //    자동으로 0번 인덱스에 있는 요소의 value를 얻어옴(JS + jQuery)
        console.log(gender.val())

        // 3) 순수 jQuery
        console.log($(gender).val())
        // $(gender) : 체크된 요소만 담긴 배열 + 요소를 선택
        // --> 체크된 radio 버튼을 선택하는 jQuery 선택자


    }
})

// prop() 메소드
$("#btn1").on("click", function () {

    const arr = $('input[name="hobby"]');

    let str = ''; // 체크된 요소의 value 값을 누적해서 저장할 변수

    console.log(arr.prop("checked"));
    // 배열명으로만 적을 경우 0번 인덱스만 확인 가능함

    for (let i = 0; i < arr.length; i++) {

        // 각 인덱스에 저장된 checkbox 요소가
        // 체크되어 있는 상태인지 확인
        console.log(i + " : " + $(arr[i]).prop("checked"))

        if ($(arr[i]).prop("checked")) {
            str += $(arr[i]).val() + " ";
            // 체크된 요소의 value 값을 얻어와 str에 누적
        }
    }

    alert(str);

    $(arr[0]).prop("checked", true);

})