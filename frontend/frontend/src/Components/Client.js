export function reqListener () {
    console.log("Client is refreshed");
    return "test"
}
  
  
  var oReq = new XMLHttpRequest();
  oReq.addEventListener("load", reqListener);
  oReq.open("GET", "http://localhost:8080/all");
  oReq.send();

  window.addEventListener('load', (event) => {
    console.log('Page is fully loaded from Client.js');
  });
export default reqListener;