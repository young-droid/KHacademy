document.getElementById("add").addEventListener("click", function () {

    // div 요소 생성
    const div = document.createElement("div");

    // div에 row 클래스 추가
    div.classList.add("row");

    // input 요소 생성
    const input = document.createElement("input");

    // input에 in 클래스 추가
    input.classList.add("in");

    // input에 "type" 속성, "number" 속성값 추가(type="number")
    input.setAttribute("type", "number");

    // span 요소 생성
    const span = document.createElement("span");

    // span 요소의 내용으로 X 추가
    span.innerText = "X";

    // span 에 remove 클래스 추가
    span.classList.add("remove");

    // span이 클릭 되었을 때에 대한 이벤트 동작 추가
    span.addEventListener("click", function () {
        // 마지막 자식 요소인 div 제거
        // div.remove();
        // div가 어떤 요소를 선택하고 있는지 명확하지 않기 때문에, 
        // -> 사용 지양

        // 요소.parentElement : 부모 요소
        // 요소.remove() : 요소 제거

        span.parentElement.remove();


    })


    //-------------------------------------------------------------

    // div 내부에(자식으로) input, span 순서대로 추가
    div.append(input);
    div.append(span);

    // div.parentNode.append(div);
    document.getElementById("container").append(div);

})



// 계산 버튼 클릭 시 이벤트 동작
document.getElementById("calc").addEventListener("click", function () {
    const arr = document.getElementsByClassName("in");

    // 합계 저장용 변수
    let sum = 0;
    // -> sum 에 0 으로 초기화 해줘서, int 자료형 sum 이라는것으로 인식시켜주기

    for (let input of arr) {
        // input에 작성된 값은 모두 string -> 형변환 필요
        sum += Number(input.value);

    }

    alert(sum);

})
