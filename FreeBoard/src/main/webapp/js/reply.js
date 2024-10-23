/**
 * reply.js
 * replyService 생성했던 메소드 활용.
 */

let page = 1; // 댓글페이지 변수.

// 댓글등록 버튼.
document.querySelector('#addReply').addEventListener('click', addReplyHandlerFnc);

// 댓글이벤트핸들러.
function addReplyHandlerFnc(e) {
	let reply = document.querySelector('#reply').value; // 추가할 댓글내용.
	if (!reply || !logId) {
		alert('필수값이 없습니다.')
		return;
	}
	// 게시글번호:bno, 댓글내용: reply, 댓글작성: logId
	svc.addReply({ bno, reply, replyer: logId },
		result => {
			// OK:화면에 한줄추가. FAIL: "에러발생"
			if (result.retCode == 'OK') {
				//let template = makeLi(result.retVal);
				//document.querySelector(".reply ul li").after(template);
				page = 1;
				svc.getReplyCount(bno, createPageList, err => console.log(err));

			} else if (result.retCode == 'FAIL') {
				alert('등록중 오류 발생');
			}
		},
		err => {
			console.log(err);
		}
	)
} // end of addReplyHandlerFnc(e).

// 댓글삭제하는 함수.
function deleteRow(e) {
	let rno = e.target.parentElement.parentElement.firstElementChild.innerText;
	// 삭제기능 호출.
	svc.removeReply(rno, // 삭제할 댓글번호.
		result => {
			if (result.retCode == 'OK') {
				alert('정상 처리');
				// e.target.parentElement.parentElement.remove();
				svc.getReplyCount(bno, createPageList, err => console.log(err));

			} else if (result.retCode == 'FAIL') {
				alert('처리중 예외');
			} else {
				alert('알수 없는 코드');
			}
		},  // 정상처리 실행함수.
		err => console.log(err) // 예외발생 실행함수.
	)
}

// .pagination a 클릭이벤트.
function linkMove() {
	document.querySelectorAll('nav ul.pagination a').forEach(function(aTag) {
		aTag.addEventListener('click', function(e) {
			e.preventDefault(); // 이동 차단.

			page = aTag.dataset.page; // <a data-page="2">2</a>
			svc.getReplyCount(bno, createPageList, err => console.log(err)); // 페이징목록보여주고.
		})
	})
}

// 페이지목록을 출력하는 함수.
svc.getReplyCount(bno, createPageList, err => console.log(err));
//createPageList();
function createPageList(result) { // page = 2

	let totalCnt = result.totalCount;
	let startPage, endPage, realEnd;
	let prev, next;

	endPage = Math.ceil(page / 5) * 5; // 5page.
	startPage = endPage - 4; // 1page.
	realEnd = Math.ceil(totalCnt / 5); // 7page.
	page = page > realEnd ? realEnd : page;
	endPage = endPage > realEnd ? realEnd : endPage;

	prev = startPage > 1;  // false
	next = endPage < realEnd; // true

	// 페이지리스트 출력.
	let list = '';
	list += '<li class="page-item">';
	if (prev) // 이전페이지 출력.
		list += '  <a class="page-link" href="#" aria-label="Previous" data-page="' + (startPage - 1) + '">&laquo;</a>';
	else
		list += '  <span class="page-link disabled" aria-hidden="true">&laquo;</span>';
	list += '    </li>';

	// <li class="page-item"><a class="page-link" href="#">1</a></li>
	for (let p = startPage; p <= endPage; p++) {
		list += '<li class="page-item"><a class="page-link" href="#" data-page="' + p + '">' + p + '</a></li>';
	}

	list += '<li class="page-item">';
	if (next) // 이후페이지 출력.
		list += '  <a class="page-link" href="#" aria-label="Next" data-page="' + (endPage + 1) + '">&raquo;</a>';
	else
		list += '  <span class="page-link disabled" aria-hidden="true">&raquo;</span>';
	list += '    </a></li>';

	document.querySelector('nav ul.pagination').innerHTML = list;
	linkMove();
	showList();
}

// 댓글목록 출력하는 함수.
showList();
function showList() {
	console.log('showList', page);
	// 출력목록을 화면에서 지우고..
	document.querySelectorAll('div.reply div.content li').forEach((li, idx) => {
		if (idx > 0)
			li.remove();
	})
	// 목록출력.
	svc.rlist({ bno, page } // bno
		,// successFnc
		function(result) {
			for (let i = 0; i < result.length; i++) {
				let template = makeLi(result[i]);
				document.querySelector(".reply ul").appendChild(template);
			}
		}
		,// errorFnc
		function(err) {
			console.log('요기', err);
		}
	);
} // end of showList()

// 댓글정보 한건있으면 <li>....</li> 함수생성.
function makeLi(rvo = { replyNo, reply, replyer }) {
	let template = document.querySelector(".reply ul li").cloneNode(true);

	template.querySelector('span').innerText = rvo.replyNo;
	template.querySelector('span:nth-of-type(2)').innerText = rvo.reply;
	template.querySelector('span:nth-of-type(3)').innerText = rvo.replyer;
	template.querySelector('span:nth-of-type(4)').innerHTML = '<button onclick="deleteRow(event)">삭제</button>';

	return template;
}

//////////////////////////////////////////////////////////////////////////
// 아래쪽으로는 사용안함.
function makeList(result) {
	console.log(result);
	// 작성.
	for (let i = 0; i < result.length; i++) {
		let tr = makeRow(result[i]);
		document.querySelector('#replyList tbody').appendChild(tr);
	}
}

function makeRow(obj = {}) {
	let fields = ['replyNo', 'reply', 'replyer'];
	let tr = document.createElement('tr');
	tr.setAttribute('data-id', obj.memberId);
	// td*4 생성.
	for (let j = 0; j < fields.length; j++) {
		let td = document.createElement('td');
		td.innerText = obj[fields[j]]; // obj.name, obj['name']
		tr.appendChild(td);
	}

	return tr;
}