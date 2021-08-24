var lap = document.getElementsByClassName("for");
var sum = 0;

for (let i = 0; i < lap.length; i++) {
    const elements = document.getElementsByName(i);
    const idItem = elements[0].getAttribute('id');
    const quantity = 'quantity' + idItem;
    const price = "price" + idItem;
    const totalPrice = "totalPrice" + idItem;

    $("#" + quantity).change(function() {
        const newQuantity = $("#" + quantity).val();
        const newPrice = $("#" + price).val();
        var newAmount = parseFloat(newQuantity) * parseFloat(newPrice);
        $("#" + totalPrice).val(newAmount);
        var sum = 0;
        $(".totalPrice").each(function() {
            sum += parseFloat($(this).val());
        });
        $(".billPrice").val(sum);

    });

}