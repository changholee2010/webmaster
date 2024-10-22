/**
 * members.js
 */
// JSP => req.getDispatch...("board/boardList.tiles").forward(req,resp);
// json => json데이터 활용 페이지 그리기.

// json형태의 회원목록을 출력하는 데이터.
// "등록" 버튼에 이벤트 추가.
document.querySelector('#addBtn').addEventListener('click', function(e) {
	let id = document.querySelector('#mid').value;
	let name = document.querySelector('#mname').value;
	let phone = document.querySelector('#mphone').value;

	fetch('addMemberJson.do?id=' + id + '&name=' + name + '&phone=' + phone)
		.then(resolve => resolve.json())
		.then(result => {
			console.log(result); // {retCode: 'OK'}
			if (result.retCode == 'OK') {
				let tr = makeRow({ memberId: id, memberName: name, phone: phone });
				document.querySelector('#show tbody').appendChild(tr);
			} else if (result.retCode == 'FAIL') {
				alert('처리중 에러가 발생.');
			}

		})
		.catch(err => { console.log(err) })
})

// 1.목록출력.
fetch('memberJson.do')
	.then(resolve => resolve.json())
	.then(result => {
		console.log(result);
		makeList(result);
	})
	.catch(err => console.log(err))

function makeList(obj = []) {
	// 작성.
	for (let i = 0; i < obj.length; i++) {
		let tr = makeRow(obj[i]);
		document.querySelector('#show tbody').appendChild(tr);
	}
}

function makeRow(obj = {}) {
	let fields = ['memberId', 'memberName', 'phone'];
	let tr = document.createElement('tr');
	tr.setAttribute('data-id', obj.memberId);
	// td*4 생성.
	for (let j = 0; j < fields.length; j++) {
		let td = document.createElement('td');
		td.innerText = obj[fields[j]]; // obj.name, obj['name']
		tr.appendChild(td);
	}
	let td = document.createElement('td');
	let btn = document.createElement('button');
	btn.addEventListener('click', deleteRowFnc);
	btn.innerHTML = '삭제';
	td.appendChild(btn);
	tr.appendChild(td);

	return tr;
}

function deleteRowFnc(e) {
	//console.dir(e.target.parentElement.parentElement.firstElementChild.innerText);
	console.dir(e.target.parentElement.parentElement.dataset.id);
	let id = e.target.parentElement.parentElement.dataset.id;
	fetch('removeMemberJson.do?id=' + id)
		.then(resolve => resolve.json())
		.then(result => {
			if (result.retCode == 'OK') {
				alert('성공.');
				e.target.parentElement.parentElement.remove();

			} else if (result.retCode == 'FAIL') {
				alert('처리중 에러가 발생.');

			}
		})
		.catch(err => console.log(err))

}