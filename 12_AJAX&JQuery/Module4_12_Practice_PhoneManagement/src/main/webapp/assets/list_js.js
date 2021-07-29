function addNewSmartPhone() {
    let _producer=$("#producer").val();
    let _model=$("#model").val();
    let _price=$("#price").val();
    let newSmartPhone={
        producer:_producer,
        model:_model,
        price:_price
    };
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type:"POST",
        data:JSON.stringify(newSmartPhone),
        url:"/smartphones",
        success:successHandler
    });
    event.preventDefault();
}

function successHandler() {
    $.ajax({
        type: "GET",
        url: "/smartphones/",
        success: function (data){
            let content=`    <tr>
                        <td>Producer</td>
                       <td>Model</td>
                      <td>Price</td>
                       <td>Delete</td>
                       <td>View</td>
                    </tr>`;
            for (let i=0;i<data.length;i++){
                content+=getSmartphone(data[i]);
            }
            document.getElementById("smartphoneList").innerHTML=content;
        }
    })
}

function getSmartphone(smartphone){
    return `<tr>
              <td>${smartphone.producer}</td>
              <td>${smartphone.model}</td>
              <td>${smartphone.price}</td>
              <td><a class="deleteSmartphone" href="${smartphone.id}">Delete</a></td>
              <td><a class="viewSmartphone" href="${smartphone.id}">View</a></td>
              </tr>`

}

$(function (){
    $(".deleteSmartphone").click(function (event){
        let a=$(this);
        let smartphoneId=a.attr("href");
        $.ajax({
            type:"DELETE",
            url:`/smartphones/${smartphoneId}`,
            success:function (data){
                a.parent().parent().remove();
            }
        })
        event.preventDefault();
    })
})

