// 0.3초마다 0~9까지 출력하는 span 태그 만들기


let count = 0;

let interval; // setInterval 함수를 저장할 변수

$(() => {
    $('#start').on('click', function () {
        interval = setInterval(function () {
            if (count < 10) {
                const span = '<span class="text1">' + count++ + '</span>';
                $('.area').append(span);
            } else {
                $('.area').empty();
                count = 0;
            }
        }, 300)

    })

    // HTML 문서의 로딩이 완료된 후
    // 아이디가 stop인 요소가 클릭 되었을 때 멈추기
    $('#stop').on('click', function () {
        clearInterval(interval);
    })

    // 클래스가 text1인 요소를 클릭했을 때
    // 콘솔에 요소의 내용 출력
    // $('.text1').on('click', function () {
    //     console($(this).text)
    // })
    /*
        1. HTML 문서는 위에서 아래로 해석
        2. on(), addEventListener()는
          요소에 이벤트가 발생했을 때 동작(기능)을 추가하는 메소드

        (중요) 기존에 on(), addEventListener()를 이용하여
        이벤트 동작을 추가할 대는
        이미 화면에 로딩이 완료된 상태인 요소에 추가했었다.

        지금 같은 경우는 기존 화면에 없던 요소(span)에
        이벤트 동작을 추가하려 했지만 실패

        정적 요소 : HTML 문서 로딩 전부터 이미 작성되어 있는 요소
            -> 기존 방법 on(('click'), function(){}) 사용 가능

        동적 요소 : 자바스크립트 또는 제이쿼리에 의해서
                   HTML 문서 로딩 이후 추가되는 요소
            -> 기존 방법 사용 불가
            -> $(document).on('이벤트', '선택자', function(){})
    */

    $('#reset').on('click', function () {
        $('.area').empty();
    })

})


$(document).on('click', '.text1', function () {
    console.log($(this).text());
})

// -----------------------------------

// 아이디가 focus-blur인 요소에 초점이 맞춰진 경우
// 배경색을 pink로 바꾸는 동작 추가
// $('#focus-blur').focus(function () {
$('#focus-blur').on('focus', function () {
    $(this).css('backgroundColor', 'pink');
});

// 아이디가 focus-blur인 요소에 초점이 해제된 경우
// 배경색을 원래대로 바꾸는 동작을 추가
// $('#focus-blur').blur(function () {
$('#focus-blur').on('blur', function () {
    $(this).css('backgroundColor', 'white');
});


// on() 은 객체형으로 추가도 가능하다 :
// $('#focus-blur').on({
//     'focus': function () {
//         $(this).css('backgroundColor', 'pink');
//     }
//     ,
//     'blur': function () {
//         $(this).css('backgroundColor', 'white');
//     }
// });


// 아이디가 change1인 요소의 체크/해제 될 때마다
// 콘솔에 "checkbox 값이 변경되었습니다." 출력
$('#change1').on('change', function () {
    console.log("checkbox 값이 변경되었습니다.")
})


// 아이디가 change2인 요소의 입력값이 변한 상태로 포커스가 해제될 때마다
// 콘솔에 "입력값이 변경되었습니다." 출력
$('#change2').on('change', function () {
    console.log("입력값이 변경되었습니다.")
})

// 아이디가 select인 요소의 입력값에 블럭이 잡힌 경우
// 콘솔에 "입력값이 블럭이 잡힙." 출력
$('#select').select(function () {
    console.log("입력값에 블럭이 잡힙.")
})

// 동적으로 글자 수 세기
$('#input-content').on('input', function () {
    // 입력한 글자 수 만큼 span 태그 값 변경
    // let content = $(this).val();
    let length = $(this).val().length;
    // console.log(length);
    $('span').text(length);

    // #counter의 글자색 변경하기
    // 글자수가 0~130이면 검은색 글씨
    // 131~149는 주황색 글씨
    // 150부터는 빨간색으로 출력

    if (length > 130 && length < 150) {
        $('#counter').css('color', 'orange');
    } else if (length >= 150) {
        $('#counter').css('color', 'red');
        $(this).val($(this).val().substring(0, 150));

        $('#counter').text(150);
    } else {
        $('#counter').css('color', 'black');
    }

    // 150 부터는 입력도 안되게
    // $('#counter').css('maxlength', '150')

    // 1. textarea에 작성된 값(문자열)을 변수에 저장
    const str = $(this).val();

    // 2. substring을 이용해서 글자를 150까지만 잘라내기
    // 문자열.substring(시작인덱스, 종료인덱스[미포함])
    // str.substring(0, 150)

    // 3. 150 글자만 잘라내어 textarea의 값으로 세팅하기
    $(this).val(str.substring(0, 150));

    // 151번째 입력이 인식되면 150글자로 자름
    // 그런데 자르기 전에 글자수를 카운트해서
    // 151로 보이는 문제 발생

})