(function(){
    var $doneList = $("#doneList");
    var $newTodoList = $("#newTodoList");
    // input框回车事件
    var $input = $("#inputText");


    var data = [
        {title:"学习node.js", done:false},
        {title:"给经理发邮件", done:false},
        {title:"发送销售合同", done:false},
        {title:"给女朋友买礼物", done:false},
        {title:"发送进货合同", done:true},
        {title:"学习javascript", done:true}
    ];

    for(var i = 0; i < data.length; i++) {
        var todo = data[i];
        createTodoElement(todo);
    }

    // 动态创建li标签，放到ul标签下边
    function createTodoElement(todo) {
        var li = '<li><a href="javascript:;"><span class="checkbox"></span></a><span class="text">' + todo.title + '</span></li>';
        if(todo.done) {
            // 已完成 放到doneList 列表中
            $doneList.append(li);
        } else {
            // 未完成 放到newTodoList 列表中
            $newTodoList.append(li);
        }

    }

    $input.keyup(function(event){
        if(event.keyCode == 13) {
            // 1. 将输入的内容转化成li标签，放入ul
            var inputValue = $(this).val();
            if(inputValue.trim()) {
                var todo = {title: inputValue, done:false};
                createTodoElement(todo);
            }
            
            // 2. 清空input框
            $input.val("");
        }
    });

    // 委托机制
    $(document).delegate(".checkbox","click",function(){
        // console.log($(this));
        var $li = $(this).parents("li");
        var $ul = $li.parent();

        if($ul.hasClass("done")) {
            $li.appendTo($newTodoList);
        } else {
            $li.appendTo($doneList);
        }

    }); 
  
})();