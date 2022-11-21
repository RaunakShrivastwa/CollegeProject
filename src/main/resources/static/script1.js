const star1=document.querySelector("#st1");
const star2=document.querySelector("#st2");
const star3=document.querySelector("#st3");
const star4=document.querySelector("#st4");
const star5=document.querySelector("#st5");

const stvalue1=()=>{
   const ratingData=document.getElementById('rating-counter');
   ratingData.innerText='30% people';
 
}

const stvalue2=()=>{
    const ratingData=document.getElementById('rating-counter');
    ratingData.innerText='50% people';
}

const stvalue3=()=>{
    const ratingData=document.getElementById('rating-counter');
    ratingData.innerText='60% people';
}

const stvalue4=()=>{
    const ratingData=document.getElementById('rating-counter');
    ratingData.innerText='75% people';
}
const stvalue5=()=>{
    const ratingData=document.getElementById('rating-counter');
    ratingData.innerText='100% people';
}


star1.addEventListener("click",stvalue1)
star2.addEventListener("click",stvalue2)
star3.addEventListener("click",stvalue3)
star4.addEventListener("click",stvalue4)
star5.addEventListener("click",stvalue5)








