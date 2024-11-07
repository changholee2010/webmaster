function number_format(amount) {
  return new Intl.NumberFormat('ko-KR', {
    style: 'currency',
    currency: 'KRW'
  }).format(amount);
}

// 숫자 3자리 콤마찍기
Number.prototype.formatNumber = function () {
  if (this == 0)
    return 0;
  let regex = /(^[+-]?\d+)(\d{3})/;
  let nstr = (this + '');
  while (regex.test(nstr)) {
    nstr = nstr.replace(regex, '$1' + ',' + '$2');
  }
  return nstr;
};

// 1,000,000 => 1000000
console.log('1,000,000'.replace(/,/g, ''))

// localStorage 사용.
// 초기화.
let json = `[
              {"prodCode": "P001", "prodName": "좋은상품01", "price": 2000, "qty": 1, "image": "P001.jpg"},
              {"prodCode": "P002", "prodName": "좋은상품02", "price": 3000, "qty": 1, "image": "P002.jpg"},
              {"prodCode": "P003", "prodName": "좋은상품03", "price": 4000, "qty": 1, "image": "P003.jpg"},
              {"prodCode": "P004", "prodName": "좋은상품04", "price": 5000, "qty": 1, "image": "P004.jpg"}
            ]`;
localStorage.setItem('originData', json);

// localStorage의 정보를 처리하는 객체.
let svc = {
  select() {
    let items = JSON.parse(localStorage.getItem('originData'));
    return items;
  },
  insert(item = {}) {
    let items = JSON.parse(localStorage.getItem('originData'));
    items.push(item);

    this.save(items);
  },
  update(item = {}) {
    let targetAry = this.select();
    let modifyAry = targetAry.map(prod => {
      if (prod.prodCode === item.prodCode) {
        prod.prodName = item.prodName;
        prod.price = item.price;
        prod.qty = item.qty;
        prod.image = item.image;
      }
      return prod;
    })
    this.save(modifyAry);
  },
  delete(prodCode = 'P999') {
    let targetAry = this.select();
    let modifyAry = targetAry.filter(item => {
      if (item.prodCode === prodCode) {
        return null;
      }
      return item;
    })
    this.save(modifyAry);
  },
  save(items = []) {
    localStorage.setItem('originData', JSON.stringify(items));
  }
}

let choice = 'select';

if (choice === 'select') {
  console.log(svc.select());
} else if (choice === 'delete') {
  svc.delete('P001');
  console.log(svc.select());
} else if (choice === 'update') {
  svc.update({
    prodCode: 'P001',
    prodName: 'Good Item 01',
    price: 4000,
    qty: 4,
    image: 'P008.jpg'
  })
  console.log(svc.select());
} else if (choice === 'insert') {
  svc.insert({
    prodCode: 'P005',
    prodName: 'Good Item 05',
    price: 5000,
    qty: 5,
    image: 'P005.jpg'
  })
  console.log(svc.select());
}

let basket = {
  cartCount: 0,
  cartTotal: 0,

  cartList: function () {
    //fetch, $.ajax  <= petSHop 참조
    //템플릿리터럴(``)을  이용하거나  cloneNode()로 노드를 복사해서 append
    // fetch("../cartList.do")
    //   .then(response => response.json())
    //   .then(result => this.makeList(result))
    //   .catch(err => console.log(err));

    // 화면 초기화.
    document.querySelectorAll('div[data-id]').forEach((item, idx) => {
      if (idx)
        item.remove();
    })

    let items = [];
    items = svc.select();

    items.forEach(item => {
      let basket = document.querySelector("#basket");
      let newElem = this.makeRow(item);
      basket.appendChild(newElem);

      this.reCalc();
    })

  },

  makeRow: function (item) {

    let cartTemplate = document.querySelector("#template");

    let rowDiv = cartTemplate.childNodes[1].cloneNode(true);
    rowDiv.setAttribute('data-id', item.prodCode);
    rowDiv.querySelector('div.pname span').textContent = item.prodName;
    rowDiv.querySelector('div.basketprice input[name="p_price"]').value = item.price;
    rowDiv.querySelector('div.basketprice').childNodes[2].textContent = (item.price).formatNumber() + "원";
    rowDiv.querySelector('div.num input').value = item.qty;
    rowDiv.querySelector('div.sum').textContent = (item.qty * item.price).formatNumber() + "원";
    rowDiv.querySelector('div.img img').setAttribute('src', '../img/' + item.image)
    // rowDiv.querySelector('div.basketcmd>a').href = 'javascript:void(0)';
    rowDiv.querySelector('div.num>div.updown>input:nth-of-type(1)').setAttribute('id', 'p_num' + item.prodCode);
    rowDiv.querySelector('div.num>div.updown>input:nth-of-type(1)').setAttribute('name', 'p_num' + item.prodCode);
    // rowDiv.querySelector('div.num>div.updown>input:nth-of-type(1)').setAttribute('onkeyup', 'javascript:basket.changePNum(' + item.prodCode + ')');
    // rowDiv.querySelector('div.num>div.updown>span:nth-of-type(1)').setAttribute('onclick', 'javascript:basket.changePNum(' + item.prodCode + ')');
    // rowDiv.querySelector('div.num>div.updown>span:nth-of-type(2)').setAttribute('onclick', 'javascript:basket.changePNum(' + item.prodCode + ')');

    return rowDiv;
  },

  delItem: function (e) {
    let no = e.target.parentNode.parentNode.parentNode.dataset.id;
    let url = "../cartDelete?no=" + no;
    console.log('delItem:', url);

    // fetch(url)
    //   .then(result => {
    //     console.log(result);
    //     //선택한 버튼의 상품을 삭제.. 버튼.closet(".row").remove();
    //     e.target.closest('.row').remove();
    //     this.reCalc();
    //   })
    //   .catch(err => console.log(err))
    svc.delete(no);
    e.target.closest('.row').remove();
    // console.log(svc.select());
    // this.cartList();
    this.reCalc();
  },

  reCalc: function () {
    //수량, 금액 합계 계산
    //합계 자리에 출력
    var cartTotal = 0;
    var cartCount = 0;

    document.querySelectorAll('#basket>div.data').forEach(function (item) {
      if (item.querySelector('input[type="checkbox"]').checked) {
        checkCnt = item.querySelector('div.num input[name="p_num' + item.dataset.id + '"]');
        if (checkCnt) {
          checkItem = item.querySelector('div.sum');

          var strToNum = checkItem.textContent.replace(/,/g, '');
          var strToCnt = checkCnt.value;

          cartTotal += parseInt(strToNum);
          cartCount += parseInt(strToCnt);
        }
      }
    })
    this.cartTotal = cartTotal;
    this.cartCount = cartCount;
    document.querySelector('#sum_p_num>span').textContent = (cartCount).formatNumber();
    document.querySelector('#sum_p_price>span').textContent = (cartTotal).formatNumber();

  },

  changePNum: function (e) {
    var currentElem = e.target;

    if (currentElem.getAttribute('type') == 'checkbox') {
      this.reCalc();
      return;
    }

    let currentQty = 0; // 현재수량.
    let currentPrice = 0; // 현재금액.
    let calQty = 0; // 변경된 수량.

    // 수량직접 변경하거나...
    currentPrice = currentElem.closest('div.subdiv').querySelector('input.p_price').value;

    if (currentElem.tagName == 'INPUT') {
      currentQty = currentElem.value;
      calQty = currentQty;

    } else { // 화살표 변경하거나...
      currentQty = currentElem.parentNode.parentNode.childNodes[1].value;
      if (currentElem.classList.contains('down')) {
        calQty = parseInt(currentQty) - 1;
      } else {
        calQty = parseInt(currentQty) + 1;
      }
      calQty = calQty || 1;
    }

    currentElem.parentNode.parentNode.childNodes[1].value = calQty; // 수량변경출력.
    // 수량 * 금액 => 재계산.
    var calAmount = calQty * currentPrice;
    currentElem.closest('div.subdiv').querySelector('div.sum').textContent = (calAmount).formatNumber() + "원"; // 금액변경출력.

    this.reCalc();

  },

  delCheckedItem: function () {
    document.querySelectorAll('#basket div.subdiv>div.check>input[type="checkbox"]:checked').forEach(function (item) {
      console.log(item)
      no = item.parentElement.parentElement.parentElement.dataset.id;
      let url = "../cartDelete?no=" + no;

      fetch(url)
        .then(result => {
          console.log(result.text());
          //선택한 버튼의 상품을 삭제.. 버튼.closet(".row").remove();
          // e.target.closest('.row').remove();
          item.parentElement.parentElement.parentElement.remove();
        })
        .catch(err => console.log(err))

    })
    this.reCalc();
  },

  delAllItem: function () {
    document.querySelectorAll('div.subdiv>div.check>input[type="checkbox"]').forEach(function (item) {
      item.parentElement.parentElement.parentElement.remove();
    })
    this.reCalc();
  },
};

basket.cartList();
// end of program.