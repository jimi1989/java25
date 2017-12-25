(function(){
    var doneList = document.querySelector("#doneList");
    var newTodoList = document.querySelector("#newTodoList");

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
        //1. 动态创建标签
        var li = document.createElement("li");  // <li></li>
        var a = document.createElement("a"); // <a></a>
        var checkSpan = document.createElement("span"); //<span></span>
        var textSpan = document.createElement("span");
        var text = document.createTextNode(todo.title);

        // 2.添加标签的class属性
        checkSpan.setAttribute("class","checkbox"); //<span class="checkbox"></span>
        textSpan.setAttribute("class","text");
        a.setAttribute("href","javascript:;"); //<a href="javascript:;"></a>

        // 3.组合
        textSpan.appendChild(text); // <span class="text">todo.title</span>
        a.appendChild(checkSpan); //<a><span class="checkbox"></span></a>
       
        li.appendChild(a);
        li.appendChild(textSpan);

        if(todo.done) {
            // 已完成 放到doneList 列表中
            doneList.appendChild(li);
        } else {
            // 未完成 放到newTodoList 列表中
            newTodoList.appendChild(li);
        }

    }

    // input框回车事件
    var input = document.querySelector("#inputText");

    // onkeydown onkeyup onkeypress
    input.onkeyup = function(event){
        console.log(event.keyCode);  // keyCode C:大写
        if(event.keyCode == 13) {
            // 1. 将输入的内容转化成li标签，放入ul
            var inputValue = input.value;
            if(inputValue.trim()) {
                var todo = {title: inputValue, done:false};
                createTodoElement(todo);
            }
            
            // 2. 清空input框
            input.value = "";
        }
    }

    //checkbox 点击事件
    document.onclick = function(event){
        // console.log(event.target);
        var ev = event.target;
        if(ev.getAttribute("class") == "checkbox") {
            // console.log("success");
            // 1.根据当前span(checkbox)对象获得li对象
            var li = ev.parentNode.parentNode;
            var ul = li.parentNode;
            if(ul.getAttribute("class") == "todoList done") {
                newTodoList.appendChild(li);
            } else {
                doneList.appendChild(li);
            }
            

        }


    }
    
    
    // var checkBoxes = document.querySelectorAll(".checkbox");

    // var fn = function(){
    //     console.log("success");
    // }

    // for(var i = 0; i < checkBoxes.length; i++) {
    //     checkBoxes[i].onclick = fn;
    // }

})();