export function reqListener () {
    console.log("test");
    return "test"
}
  
  
  var oReq = new XMLHttpRequest();
  oReq.addEventListener("load", reqListener);
  oReq.open("GET", "http://localhost:8080/all");
  oReq.send();

  window.addEventListener('load', (event) => {
    console.log('page is fully loaded');
  });
export default reqListener;