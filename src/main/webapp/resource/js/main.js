(function() {

  /**
   * Variables
   */
  var user_id = '1111';
  var user_fullname = 'John';
  var campany_name = 'Apple';
  var items = {"project progress":80,"project payment":90,"project communication":90};
  var categories = {"finance":false,"market":true,"internet":true,"movie":false};

  /**
   * Initialize major event handlers
   */
  function init() {
    // register event listeners
    document.getElementById('company_name').innerHTML = campany_name;
    document.getElementById('prog_val').innerHTML = items['project progress']+"%";
    document.getElementById('pay_val').innerHTML = items['project payment']+"%";
    document.getElementById('comm_val').innerHTML = items['project communication']+"%";

    var score = calTotalScore();
    listCategories();
    showRate(score);
    
    document.querySelector('#edit_button').addEventListener('click', editTable);
    document.querySelector('#update_button').addEventListener('click', updateTable);
    document.querySelector('#fav-btn').addEventListener('click', loadFavoriteItems);
    document.querySelector('#recommend-btn').addEventListener('click', loadRecommendedItems);
    validateSession();
    onSessionValid({"user_id":"1111","name":"John Smith","campany_name":"Apple", "status":"OK"});
  }

 /**
   * Calculate total score
   */
  function calTotalScore(){
    var sum = 0;
    var count = 0;
    for (var key in items) {
      // check if the property/key is defined in the object itself, not in parent
      if (items.hasOwnProperty(key)) {
        sum+=items[key];
        count+=1;
      }
    }
    
    var avg = Math.round(sum/count);
    if (avg >= 50){
       document.getElementById("progress_over_50").className = "column left progress-circle over50 p"+avg.toString(); 
       document.getElementById("total_score_val").innerHTML = avg.toString() +"%"; 
    }else{
       document.getElementById("progress_over_50").className = "column left progress-circle p"+avg.toString();   
       document.getElementById("total_score_val").innerHTML = avg.toString() +"%"; 
    }
    
    return avg;
  }
  

  /**
   * Edit the table
   */
  function editTable(){
    rn = window.prompt("Input the row number(1,2,3)", "1");
    content = window.prompt("Input the score");
    if (rn === "1"){
      document.getElementById("prog_val").innerHTML = content+"%";
      items["project progress"]= parseInt(content);
    }else if (rn === "2"){
      document.getElementById("pay_val").innerHTML = content+"%";
      items["project payment"]= parseInt(content);
    }else if (rn === "3"){
      document.getElementById("comm_val").innerHTML = content+"%";
      items["project communication"]= parseInt(content);
    }
    
    var score = calTotalScore();
    showRate(score);
  }
  
  
  /**
   * List the category information
   */
  
  function listCategories(){
    for (var key in categories) {
      // check if the property/key is defined in the object itself, not in parent
      if (categories.hasOwnProperty(key)) {
        document.getElementById("category_list").innerHTML += key.toString()+" ";
      }
    }
  }
  
  function showRate(score){
    
    // initial
    document.getElementById("start1").className = "fa fa-star"; 
    document.getElementById("start2").className = "fa fa-star"; 
    document.getElementById("start3").className = "fa fa-star"; 
    document.getElementById("start4").className = "fa fa-star"; 
    document.getElementById("start5").className = "fa fa-star"; 

    if (score > 0){
        document.getElementById("start1").className = "fa fa-star checked"; 
    }
    if (score > 20){
        document.getElementById("start2").className = "fa fa-star checked";       
    }
    if (score > 40){
        document.getElementById("start3").className = "fa fa-star checked";       
    }
    if (score > 60){
        document.getElementById("start4").className = "fa fa-star checked";       
    }
    if (score > 80){
        document.getElementById("start5").className = "fa fa-star checked";       
    }
  }
 
  init();

})();
