$(function (){
    $(".viewSmartphone").click(function (event){
        let a=$(this);
        let smartphoneId=a.attr("href");
        $.ajax({
            type:"GET",
            url:`/smartphones/${smartphoneId}`,
            success:function (data){
                $("#id_info").val(data.id);
                $("#producer_info").val(data.producer);
                $("#model_info").val(data.model);
                $("#price_info").val(data.price);
            }
        })
        event.preventDefault();
    })
})

function edit() {
    let smartphoneId=$("#id_info").val();
    let producer=$("#producer_info").val();
    let model=$("#model_info").val();
    let price=$("#price_info").val();
    let newSmartphone={
        producer:producer,
        model:model,
        price:price
    };
    console.log(newSmartphone)
    $.ajax({
        type: "PUT",
        contentType:"application/json",
        url: `/smartphones/${smartphoneId}`,
        data:JSON.stringify(newSmartphone),
        success:successHandler,

        error: function (e){
            console.log(e)
        }

    })
    event.preventDefault();
    
}
