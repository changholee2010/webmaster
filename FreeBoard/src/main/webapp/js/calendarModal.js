/**
 * calendarModal.js
 */

function modalShow(arg) {
	modalArg = arg; // 여러 함수에서 사용할 용도.
	// body 태그.
	let body = document.querySelector('body');
	body.className = '';
	body.style.overflow = 'hidden';
	body.style.paddingRight = '16px';

	let backDrop = document.createElement('div');
	backDrop.className = 'modal-backdrop fade show';
	body.appendChild(backDrop);

	// modal 태그.
	let modal = document.querySelector('#exampleModal');
	modal.classList.add('show');
	modal.setAttribute('aria-modal', true);
	modal.setAttribute('role', 'dialog');
	modal.removeAttribute('aria-hidden')
	modal.style.display = 'block';


	start.value = modalArg.startStr;
	end.value = modalArg.endStr;

}

function modalHide() {
	// body 속성.
	let body = document.querySelector('body');
	body.className = '';
	body.style.overflow = '';
	body.style.paddingRight = '';

	// div 속성.
	let modal = document.querySelector('#exampleModal');
	modal.classList.remove('show');
	modal.removeAttribute('aria-modal');
	modal.removeAttribute('role');
	modal.setAttribute('aria-hidden', true)
	modal.style.display = 'none';

	// back-drop 속성.
	document.querySelector('.modal-backdrop').remove();
}

function modalSave() {
	// title, startStr, endStr
	let title = document.querySelector('#title').value;
	let startStr = document.querySelector('#start').value;
	let endStr = document.querySelector('#end').value;

	fetch('addEvent.do?job=add&title=' + title + '&start=' + startStr + '&end=' + endStr)
		.then(resolve => resolve.json())
		.then(result => {
			console.log(result);
			if (result.retCode == 'OK') {
				// 화면에 출력.
				calendar.addEvent({
					title: title,
					start: modalArg.start,
					end: modalArg.end,
					allDay: modalArg.allDay
				}) // 화면출력.
				document.querySelector('#title').value = "";
			} else if (result.retCode == 'FAIL') {
				alert('등록 에러.')
			}
		})
		.catch(err => console.log(err));

}

function startChange(event) {
	console.log(event);
	modalArg.start = new Date(event.target.value); // 2024-20-21
}