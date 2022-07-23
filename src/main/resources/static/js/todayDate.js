const days = ["일", "월", "화", "수", "목", "금", "토"];
const today = new Date();

var date = today.getDate();
var month = today.getMonth() + 1;
var day = days[today.getDay()];
var year = today.getFullYear();

const todayDate = document.querySelector(".todayDate");

var p = document.createElement("p");
p.setAttribute("class", "gottenDate");
p.innerHTML = `${year}. ${month}. ${date}. ${day}`;
todayDate.appendChild(p);
