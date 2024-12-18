// 글자 색 속성 클래스
// confirm
// error

/* 아이디 : 값이 변했을 때 
영어 소문자로 시작하고, 
영어 대/소문자, 숫자, - , _ 로만 이루어진 6~14 글자 사이 문자열인지 검사
아이디 정규표현식 : (각자 작성)

- 형식이 일치할 경우
입력창의 배경색을 green 으로 변경

- 형식이 일치하지 않은 경우
입력창의 배경색을 red, 글자색을 white 로 변경*/

document.getElementById("userId").addEventListener("change", function(){
    const regExp = /^[a-z][a-zA-Z0-9-_]{5,13}$/;

    if(regExp.test(this.value)){
        this.style.backgroundColor = "green";
    }else{
        this.style.backgroundColor = "red";
        this.style.color = "white";
    }

})

// ------------------------------------------------------------------

/* 비밀번호, 비밀번호 확인 : 키보드가 올라올 때 
"비밀번호" 를 미입력한 상태에서 "비밀번호 확인"을 작성할 경우
"비밀번호 확인"에 작성된 내용을 모두 삭제하고
'비밀번호를 입력해주세요' 경고창 출력 후
focus 를 "비밀번호" 입력창으로 이동
*/
document.getElementById("userPw2").addEventListener("keyup", function(){
    const userPw = document.getElementById("userPw");

    if(userPw.value === ""){ // userPw 미입력 시
        this.parentNode.nextElementSibling.innerText = "비밀번호를 입력해주세요";
        this.value = "";
        userPw.focus();  
    }
    
    // ------------------------------------------------------------------
    
    /*
    - 비밀번호가 일치할 경우
    "비밀번호" 입력창 오른쪽에 "비밀번호 일치" 글자를 초록색으로 출력.
    
    - 비밀번호가 일치하지 않을 경우
    "비밀번호" 입력창 오른쪽에 "비밀번호가 불일치" 글자를 빨간색으로 출력
    
    - 비밀번호가 작성되지 않은경우 오른쪽에 출력되는 문구 삭제
    
    */
    
    else{ // userPw 입력 시
        if(userPw.value === this.value){
            // - 비밀번호가 일치할 경우
            // "비밀번호" 입력창 오른쪽에 "비밀번호 일치" 글자를 초록색으로 출력.
            userPw.parentNode.nextElementSibling.classList.add("confirm");
            userPw.parentNode.nextElementSibling.innerText = "비밀번호 일치";
        }
    }
    
/*        
아래에서  userPw.nextElementSibling 해도 바로 아래 <td> 태그를 잡지 못하는 이유? 
<tr>
    <td>비밀번호</td>
    <td><input type="password" id="userPw" /></td>
    <td></td>
</tr> 

html 위 코드가 안돼서 아래로도 시도해봄:
<tr>
    <td>비밀번호</td>
    <td><input type="password" id="userPw" /><span></span></td>
</tr> 
          
          */





})

// -------------------------------------------------------------

/* 이름 : 값이 변화했을 때 
한글 2~5 글자 사이 문자열인지 검사.
- 형식이 일치할 경우
"이름" 입력창 오른쪽에 "정상입력" 글자를 초록색으로 출력.
- 형식이 일치할 경우
"이름" 입력창 오른쪽에 "한글만 입력하세요" 글자를 빨간색으로 출력.
*/
document.getElementById("userName").addEventListener("change", function(){

    // 한글 2~5글자 정규 표현식(정규식)
    const regExp = /^[가-힣]{2,5}$/; // 한글(단일 자음, 모음 제외)

    if (regExp.test(this.value)) {
        this.parentNode.nextElementSibling.classList.add("confirm");
        this.parentNode.nextElementSibling.classList.remove("error");
        this.parentNode.nextElementSibling.innerText = "정상입력"
    } else {
        this.parentNode.nextElementSibling.classList.add("error");
        this.parentNode.nextElementSibling.classList.remove("confirm");
        this.parentNode.nextElementSibling.innerText = "한글만 입력하세요"
    }

    // 빈칸이라면 span 작성된 내용 초기화 (삭제)
    if (this.value === '') {
        this.parentNode.nextElementSibling.innerText = "";
    }
})

// -----------------------------------------------------------

/* 회원가입 버튼 클릭 시 : validate() 함수를 호출하여 
성별이 선택 되었는지, 전화번호가 형식에 알맞게 작성되었는지 검사 */

// document.getElementById("signUp").addEventListener("click", function validate(){})
function validate(){

    /*- 성별이 선택되지 않은 경우 
    "성별을 선택해주세요." 경고창(==대화상자) 출력 후
    submit 기본 이벤트를 제거하여 회원가입이 진행되지 않게 함.*/
    const gender = document.getElementById("gender");
    console.log(gender);
    const inputGender = document.querySelector('input[name="gender"]:checked');

    if(!inputGender){
        alert("성별을 선택해주세요.");
        console.log("성별을 선택해주세요");
        return false;
    }
    
    /*
    - 전화번호 형식이 올바르지 않을 경우 
    "전화번호의 형식이 올바르지 않습니다" 경고창(==대화상자) 출력 후
    submit 기본 이벤트를 제거하여 회원가입이 진행되지 않게 함.
    */
   const phone = document.getElementById("phone");
   const regExp = /^\d{3}-\d{4}-\d{4}$/;
   
   if(!regExp.test(phone.value)){
    alert("전화번호의 형식이 올바르지 않습니다.");
    return false;
   }
   return true;

}


/*
document.getElementById("phone").addEventListener("keyup", function () {
    const regExp = /^\d{3}-\d{4}-\d{4}$/
    const result = document.querySelector("#phone")

    if (regExp.test(this.value)) {

    }

})
*/