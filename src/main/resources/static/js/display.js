var lap = document.getElementsByClassName("for");

for (let i = 0; i < lap.length; i++) {
    const price = lap[i].querySelector(".price");
    const quantity = lap[i].querySelector(".quantity");
    const amount = lap[i].querySelector(".amount");
    console.log(lap[i]);
    quantity.addEventListener("change", (e) => {
        const value = parseFloat(e.target.value) * parseFloat(price.innerText);
        amount.value = value;
    });
}

const priceBill = document.getElementById("priceBill");


var sum = 0;
for (let i = 0; i < lap.length; i++) {
    const amount = lap[i].querySelector(".amount");
    const discount = lap[i].querySelector(".discount");
    const totalPrice = lap[i].querySelector(".totalPrice");

    let value;
    discount.addEventListener("change", (f) => {
        value = parseFloat(amount.value) - (parseFloat(amount.value) * parseFloat(f.target.value) / 100);
        totalPrice.innerText = value;
        sum += value;
        console.log(sum);
        priceBill.value = sum;

    });
}

const discountBill = document.getElementById("discountBill");
const totalBill = document.getElementById("totalBill");


discountBill.addEventListener("change", (g) => {
    const value = parseFloat(priceBill.value) - (parseFloat(priceBill.value) * parseFloat(g.target.value) / 100);
    totalBill.value = value;
});





// quantity.addEventListener("change", (e) => { console.log(e.target.value) });