function a() {
  console.log('a: start');
  b();
  console.log('a: end');
}

function b() {
  console.log('b: start');
  c();
  console.log('b: end');
}

function c() {
  console.log('c: running');
}

a();


// a: start    // a pushed
// b: start    // b pushed
// c: running  // c pushed
// b: end     // c popped -> back to b
// a: end     // b popped -> back to a -> then a popped
