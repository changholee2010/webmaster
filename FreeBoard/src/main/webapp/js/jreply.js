/**
 * jreply.js
 */
console.log('start')

// jquery방식의 Ajax호출.
$.ajax('replyList.do?bno=' + bno + '&page=1')
	.done(function(result) {
		console.log(result); // [{}....{}]
		result.forEach((item) => {
			$('<li />').append(
				$('<span />').addClass('col-sm-2').text(item.replyNo), // 글번호
				$('<span />').addClass('col-sm-5').text(item.reply),  // 댓글내용
				$('<span />').addClass('col-sm-2').text(item.replyer),  // 작성자
				$('<span />').addClass('col-sm-2').append($('<button>삭제</button>')),  // 삭제버튼
			)
				.appendTo($('div.content ul'));
		});
	})
	.fail(function(err) {
		console.log(err);
	})

// 삭제이벤트.
$('div.content ul').on('click', 'button', function(e) {
	let rno = $(e.target).parent().parent().find('span:eq(0)').text();
	$.ajax({
		url: 'removeReply.do',
		data: { rno: rno },
		method: 'get',
		dataType: 'json' // 문자열 => 자바스크립트 객체.
	})
		.done(function(result) {
			if (result.retCode == 'OK') {
				$(e.target).closest('li').remove();
			}
		})
		.fail(function(err) {
			console.log(err);
		}); //삭제.
})

// 댓글등록 이벤트.
$('#addReply').on('click', function(e) {
	let reply = $('#reply').val();
	if (!reply || !logId) {
		alert('값을 입력.')
		return;
	}

	$.ajax({
		url: 'addReply.do',
		data: { bno: bno, reply: reply, replyer: logId },
		method: 'post',
		dataType: 'json'
	})
		.done(function(result) {
			if (result.retCode == 'OK') {
				let item = result.retVal;
				$('<li />').append(
					$('<span />').addClass('col-sm-2').text(item.replyNo), // 글번호
					$('<span />').addClass('col-sm-5').text(item.reply),  // 댓글내용
					$('<span />').addClass('col-sm-2').text(item.replyer),  // 작성자
					$('<span />').addClass('col-sm-2').append($('<button>삭제</button>'))  // 삭제버튼
				)
					.insertAfter($('div.content ul li:eq(0)'));
			}
		})
		.fail(function(err) {
			console.log(err)
		})
})