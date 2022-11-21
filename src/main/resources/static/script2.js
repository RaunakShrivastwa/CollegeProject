const hallo=document.getElementById('hallo');
console.log('hallo');


let home=document.getElementById('home');
document.getElementById("home").style.cursor = "pointer";
home.addEventListener('click',function(){
    window.location.href="/page";
    console.log('i was presed')
})