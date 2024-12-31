console.log("book.js loaded")

const bookTitleList = document.querySelectorAll(".book-title");
// bookTitleList == 배열
// -> 요소를 하나씩 꺼낸 경우 == 제목 td 요소
const bookPriceList = document.querySelectorAll(".book-price")

// 향상된 for문
for(let title of bookTitleList){
	title.addEventListener("click", (e) => {
		
		// 제목
		const t = e.target.innerText;
		
		console.log(t);
		
		// 가격
		// const p = e.target.nextElementSibling.nextElementSibling.innerText;		
		
		// data-price 속성 값 얻어오기
		const p = e.target.getAttribute("data-price");
		
		// alert("[" + t + "]는(은) "+p+"원 입니다.");
		
		// `${백틱}`
		alert(`${t}은/는 ${p}원 입니다.`)
		
	})
}


/*
for(let i=0; i<bookTitleList.length; i++){
	let title = bookTitleList[i];
	let price = bookPriceList[i];
	title.addEventListener("click",function(){
		
		alert(title.innerText+" 은(는) "+price.innerText+"원 입니다.");
	})
}
*/