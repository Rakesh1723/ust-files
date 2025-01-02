'use strict';
// const paragraphs = document.querySelectorAll('p');
// paragraphs.forEach((p) => {
//     console.log(p.textContent);
// });
// console.log(document.querySelector('header P').textContent);
// document.querySelector(".message").textContent="Correct number!";
// document.querySelector(".number").textContent=15;
// document.querySelector(".guess").value=24
// console.log(document.querySelector('.guess').value);

let num=Math.trunc(Math.random()*20)+1;
let highscore=0;
let score=20;
const display=function(message){
  document.querySelector(".message").textContent=message;
}

document.querySelector('.Check').addEventListener('click', function () {
  const guess=Number(document.querySelector('.guess').value);
  console.log(guess,typeof guess);
  if(!guess)
  {
      // document.querySelector(".message").textContent="No number!";
      display("No number!");
  }else if(guess===num){
    //  document.querySelector(".message").textContent="you won!";
     display("you won!")
     document.querySelector(".number").textContent=num;
     document.querySelector("body").style.backgroundColor='#60b347';
     document.querySelector(".number").style.width='30rem'
     if(highscore<score)
     highscore=score;
     document.querySelector(".highscore").textContent=highscore;
  }else{
    //  document.querySelector(".message").textContent="too high!";
       display(guess > num ? "too high!":"too low!");
      if(score > 1)
      { score--;
        document.querySelector(".score").textContent=score;
      }else
      {
        document.querySelector(".message").textContent="you lost!";
        document.querySelector(".score").textContent=0;
      }
  }
  // else if(guess > num){
  //   document.querySelector(".message").textContent="too high!";
  //   if(score > 1)
  //   { score--;
  //     document.querySelector(".score").textContent=score;
  //   }else
  //   {
  //     document.querySelector(".message").textContent="you lost!";
  //     document.querySelector(".score").textContent=0;
  //   }
  // }else
  // {
  //   document.querySelector(".message").textContent="too low!";
  //   if(score > 1)
  //   {  score--;
  //      document.querySelector(".score").textContent=score;
  //   }else
  //   {
  //     document.querySelector(".message").textContent="you lost!";
  //     document.querySelector(".score").textContent=0;
  //   }
  // }

});

document.querySelector('.again').addEventListener('click', function () {
  score=20;
  num=Math.trunc(Math.random()*20)+1;
  // document.querySelector(".message").textContent="Start guessing...!";
  display("Start guessing...!");
  document.querySelector(".number").textContent='?';
  document.querySelector("body").style.backgroundColor='#222';
  document.querySelector(".number").style.width='15rem'
  document.querySelector(".score").textContent=score;
  document.querySelector(".guess").value='';
});


