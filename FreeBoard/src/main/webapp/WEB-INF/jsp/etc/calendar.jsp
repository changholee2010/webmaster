<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
  <meta charset='utf-8' />
  <!-- bootstrap 스타일과 자바스크립트  -->
  <link href="css/styles.css" rel="stylesheet" />

  <script src='./dist/index.global.js'></script>
  <script>
    document.addEventListener('DOMContentLoaded', async function () {

      var calendarEl = document.getElementById('calendar');

      // Ajax 호출.
      // new Promise(function(){}, function(){})
      // 프라미스객체가 반환될 때 await 수행코드. -> 그 다음 코드 실행.
      var eventData = [];
      let resolve = await fetch('eventList.do?job=list') // fetch('eventList.do')
      let result = await resolve.json(); //  .then(resolve => resolve.json())
      eventData = result; //  .then(result => {
      //    eventData = result;
      //})
      //  .catch(err => console.log(err));
      var calendar = new FullCalendar.Calendar(calendarEl, {
        headerToolbar: {
          left: 'prev,next today',
          center: 'title',
          right: 'dayGridMonth,timeGridWeek,timeGridDay'
        },
        initialDate: '2024-10-24',
        navLinks: true, // can click day/week names to navigate views
        selectable: true,
        selectMirror: true,
        select: function (arg) {
          var title = prompt('Event Title:');
          if (title) {
            console.log(arg); // start, end
            fetch('addEvent.do?job=add&title=' + title + '&start=' + arg.startStr + '&end=' + arg.endStr)
              .then(resolve => resolve.json())
              .then(result => {
                console.log(result);
                if (result.retCode == 'OK') {
                  // 화면에 출력.
                  calendar.addEvent({
                    title: title,
                    start: arg.start,
                    end: arg.end,
                    allDay: arg.allDay
                  }) // 화면출력.
                } else if (result.retCode == 'FAIL') {
                  alert('등록 에러.')
                }
              })
              .catch(err => console.log(err));

            // title, start, end 값.
          }
          calendar.unselect()
        },
        eventClick: function (arg) {
          if (confirm('Are you sure you want to delete this event?')) {
            arg.event.remove()
          }
        },
        editable: true,
        dayMaxEvents: true, // allow "more" link when too many events
        events: eventData // [{},{},{}...{}] 배열데이터를 담을 변수
      });

      calendar.render(); // 화면출력.

    });
  </script>
  <style>
    body {
      margin: 40px 10px;
      padding: 0;
      font-family: Arial, Helvetica Neue, Helvetica, sans-serif;
      font-size: 14px;
    }

    #calendar {
      max-width: 1100px;
      margin: 0 auto;
    }
  </style>
</head>

<body>

  <div id='calendar'></div>

  <!-- bootstrap 스타일과 자바스크립트  -->
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
  <!-- Core theme JS-->
  <script src="js/scripts.js"></script>
</body>

</html>