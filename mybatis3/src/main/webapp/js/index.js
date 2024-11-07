document.write('<div class="container">');
let age = 10;
let str = `age => ${age}`;
console.log(str);

document.write('<table class="table">');
for (let i = 0; i <= 9; i++) {
  // document.write(`<h3>${i}단</h3>`);
  document.write('<tr>')
  for (let j = 2; j <= 9; j++) {
    if (i === 0) {
      document.write(`<td align="center"> ${j}단 </td>`)
      continue;
    }
    document.write(`<td align="center">${j} * ${i} = ${i*j}</td>`)
  }
  document.write('</tr>')
}
document.write('</table>');

// 2단부터 9단까지 출력.
let num = 2;
for (let i = 1; true; i++) {
  if (i == 80) {
    break;
  }
  let num9 = i % 10;
  if (num9 === 0) {
    num++;
    continue;
  }
  //document.write(`<p>${num} * ${num9} = ${num * num9}</p>`);
}
console.log('end')
document.write('</div>');