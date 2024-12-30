function fnAlert(){
    alert("alert 확인");

    // window는 브라우저 자체를 나타내는 객체
    // -> JS 코드는 브라우저(window) 내부에서 실행되는 코드이기 때문에 
    // 생략 가능
}

function documentWrite(){
    document.write("2교시 수업중<br>");
    document.write("<b>2교시 수업중</b><hr>");
    // 출력할 문구에 html 태그가 있을 경우 해석해서
    // 시각적인 요소로 보여줌



    let a = "<table border='1'>";
    a += "<tr>";
    a += "<td>1</td>";
    a += "<td>2</td>";
    a += "</tr></table>";

    document.write(a);
}

// innerText로 읽어오기
function getInnerText(){
    // HTML 문서 내에서 아이디가 "text1"인 요소를 얻어와
    // test1 변수에 대입
    const test1 = document.getElementById("test1");

    // test1 변수에 대입된 요소에서 내용을 얻어와 console에 출력
    console.log(test1.innerText);

}

// innerText로 변경하기
function setInnerText(){
    const test1 = document.getElementById("test1");

    // test1 변수에 새로운 내용을 작성
    test1.innerText = "innerText로 변경된 내용입니다.\n 줄바꿈";

}


// innerHTML으로 읽어오기
function getInnerHTML1(){
    // HTML 문서 내에서 아이디가 "text1"인 요소를 얻어와
    // test1 변수에 대입
    const test2 = document.getElementById("test2");

    // test1 변수에 대입된 요소에서 내용을 얻어와 console에 출력
    console.log(test2.innerHTML);

}

// innerHTML으로 변경하기
function setInnerHTML1(){
    const test2 = document.getElementById("test2");

    // test1 변수에 새로운 내용을 작성
    test2.innerHTML = "innerHTML으로 변경된 내용입니다. <br> 줄바꿈";

}


function add(){
    const area1 = document.getElementById("area1");
    area1.innerHTML += '<div class="box2"></div>';

}

function fnConfirm(){
    if(confirm("버튼 배경색을 분홍색으로 바꾸시겠습니까?")){
        document.getElementById("confirmBtn").style.backgroundColor = 'pink'; 
    } else{
       document.getElementById("confirmBtn").style.backgroundColor = 'skyblue'; 
    }
}

// prompt 확인하기
function fnPrompt1(){
    var name = prompt("이름을 입력해주세요");
    var height = prompt("키를 입력해주세요");

    console.log(name);
    console.log(height);
    
    document.getElementById("area2").innerHTML = '<b>이름 : ' + name + '</b> / 키 : ' + height ;
}


function fnPrompt2(){
    const input = prompt("이름을 입력해주세요")

    if(input != null){// 이름이 입력 되었을 때
        // 000님 환영합니다. 
        document.getElementById("area3").innerText = input + "님 환영합니다."
        
    } else {
        // 이름을 입력해주세요 
        document.getElementById("area3").innerHTML = "이름을 입력해주세요"
    }
}


// 선택한 input요소.value 확인하기
function fnInput(){
    const input1 = document.getElementById("userId");
    const input2 = document.getElementById("userPwd");

    let id = input1.value;
    let pw = input2.value;

    console.log(id);
    console.log(pw);

    document.getElementById("area4").value = id + ", " + pw;

    input1.value = "";
    input2.value = "";

}

