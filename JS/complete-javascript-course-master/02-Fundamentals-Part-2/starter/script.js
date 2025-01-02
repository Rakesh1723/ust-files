 'use strict';

// let hasDriversLicense = false;
// const passTest = true;

// if (passTest) hasDriversLicense = true;
// if (hasDriversLicense) console.log('I can drive :D');

// const interface = 'Audio';
// const private = 534;

// function logger(val) {
//     let v=va;
//     console.log('My name is Jonas');
//   }
  
//   // calling / running / invoking function
//   logger(89,77);
//   logger();
//   logger();


// const arr=['1','2','3'];
// console.log(arr);

const years=new Array(1991,1984,2008,2020);
// console.log(arr[0])
// console.log(arr[2])
// console.log(arr[3])
// console.log(arr.length)

// Push,unshift,pop,shift,indexof,includes.
// console.log(years)
// let v1=years.push(2021)
// console.log(v1)
// let v2=years.pop(2020)
// console.log(v2)
// years.pop()
// years.shift()
// console.log(years)


const bills=[22,295,176,440,37,105,10,1100,86,52];
const tips=[];
const totals=[];

for(let i=0;i<bills.length;i++)
{ tips.push(calcTip(bills[i]));
   totals.push(tips[i]+bills[i]);
}

let sum=0;
function calcAverage(arr){
  for(let i=0;i<arr.length;i++)
    sum+=arr[i];
}
 let average=sum/arr.length;
 calcAverage(totals)