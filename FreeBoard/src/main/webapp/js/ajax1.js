/**
 * ajax1.js
 * Asynchronous Javascript And Xml.
 */

let xhtp = new XMLHttpRequest(); // 비동기방식처리(Ajax).
xhtp.open('get', 'memberJson.do');
xhtp.send(); // 서버상 resource 요청.

let data = [];
xhtp.onload = function() {
	let obj = JSON.parse(xhtp.responseText);
	console.log(obj);
	data = obj;
	console.log('1', data);
	for (let i = 0; i < data.length; i++) {
		console.log(data[i]);
	}
}

console.log('2', data);
