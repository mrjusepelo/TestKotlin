var Menu = new Object();
Menu.items = [
    {'name':'Item 1', 'description':'DESC 1 Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua'},
    {'name':'Item 2', 'description':'DESC 2 Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua'},
    {'name':'Item 3', 'description':'DESC 3 Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua'},
    {'name':'Item 4', 'description':'DESC 4 Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua'},
    {'name':'Item 5', 'description':'DESC 5 Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua'},
    {'name':'Item 6', 'description':'DESC 6 Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua'}
  ]

Menu.build_items = function () {
  for ( var i = 0; i < Menu.items.length; i++ ) {
    var p = "params";
    // .toDOM()
    var li = '<li data-item='+i+' onclick="Menu.details(this)" >'+Menu.items[i].name+'</li>';
    document.getElementById('wrapper_menu').insertAdjacentHTML('beforeend', li);
  }
}

Menu.details = function (element) {
  alert(Menu.items[element.dataset.item].name+"|"+Menu.items[element.dataset.item].description+"|"+element.dataset.item);
}

Menu.show_details = function (i) {
    var name = '<h3 >'+Menu.items[i].name+'</h3>';
    var desc = '<p >'+Menu.items[i].description+'</p>';
    document.getElementById('description').insertAdjacentHTML('beforeend',name);
    document.getElementById('description').insertAdjacentHTML('beforeend',desc);

}
