document.getElementById("btn1").addEventListener("click", function () {

    // #test의 자식 노드를 모두 얻어오기
    // - 요소.childNodes : 요소의 자식 노드를 모두 반환
    const nodeList = document.getElementById("test").childNodes;

    console.log(nodeList);

    // 노드 탐색

    // 1) 부모 노드 탐색 : parentNode
    const li1 = document.getElementById("li1");
    console.log(li1.parentNode); // ul#test

    // 부모 노드의 배경색 변경
    li1.parentNode.style.backgroundColor = 'lightblue';

    // 부모 노드 마지막에 새로운 노드 추가
    // (append : (마지막에)덧붙이다)
    li1.parentNode.append("ABCDE");

    // 2) 첫 번째 자식 노드 탐색 : firstChild
    const ul = document.getElementById("test");
    console.log(ul.firstChild);

    // 3) 마지막 자식 노드 탐색 : lastChild
    console.log(ul.lastChild);

    // 4) 중간에 존재하는 자식 노드 탐색 : 부모요소.childNodes[인덱스]
    console.log(nodeList[11]);
    nodeList[11].append("12345");

    // 5) 이전 형제 노드 탐색 : previousSibling
    //    다음 형제 노드 탐색 : nextSibling

    console.log("nodeList[8].previousSibling" + nodeList[8].previousSibling)
    console.log("nodeList[8]" + nodeList[8])
    console.log("nodeList[8].nextSibling" + nodeList[8].nextSibling)

    // 노드 탐색을 위한 구문은 연달아서 사용 가능
    console.log(nodeList[8].previousSibling.previousSibling.previousSibling)
})

// Element 탐색 확인하기
document.getElementById("btn2").addEventListener("click", function () {

    // #test의 모든 자식 요소 반환
    const list = document.getElementById("test").children;
    console.log(list);

    // #test의 첫번째 자식 요소
    document.getElementById("test").firstElementChild.style.backgroundColor = "orange";

    // #test의 마지막 자식 요소
    document.getElementById("test").lastElementChild.style.backgroundColor = "tomato";

    // #test의 자식 중(list) 2번 인덱스의 이전/다음 형제 요소
    list[2].previousElementSibling.addEventListener("click", function () {
        alert("2번 인덱스의 이전 형제 요소 클릭")
    }).addEventListener
    list[2].previousElementSibling.addEventListener("click", function () {
        alert("2번 인덱스의 이전 형제 요소 클릭")
    })

    console.log(prevEl(list[1]));
    console.log(prevEl(prevEl(list[1])));

})

// 이전 형제 요소 선택 함수
function prevEl(el) {
    return el.previousElementSibling;
}

// 다음 형제 요소 선택 함수
function prevEl(el) {
    return el.previousElementSibling;
}


let count1 = 1;
// innerHTML 버튼 클릭 시
document.getElementById("btn3-1").addEventListener("click", function () {

    const div = document.getElementById("div3-1");

    if (count1 <= 10) {

        div.innerHTML += "<div>" + count1++ + "</div>";
    }

})

let count2 = 1;
// createElement 버튼 클릭 시
document.getElementById("btn3-2").addEventListener("click", function () {

    const div = document.getElementById("div3-2");

    // createElement를 이용해서 div 요소 생성

    // document.createElement("태그명") : 해당 태그 요소를 생성해서 반환

    const child = document.createElement("div"); // div 생성은 됨. 하지만 화면 배치 X

    if (count2 <= 10) {
        // #div3-2의 마지막 자식 요소로 추가(append)
        div.append(child);

        // 만들어진 div(child)에 내용 추가
        child.innerText = count2++;
    }

})
