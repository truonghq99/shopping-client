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

for (let i = 0; i < lap.length; i++) {
    const amount = lap[i].querySelector(".amount");
    const discount = lap[i].querySelector(".discount");
    const totalPrice = lap[i].querySelector(".totalPrice");
    const priceBill = lap[i].querySelector(".priceBill");
    const discountBill = lap[i].querySelector(".discountBill");
    const totalBill = lap[i].querySelector(".totalBill");
    console.log(lap[i]);
    discount.addEventListener("change", (f) => {
        const value = parseFloat(amount.value) - (parseFloat(amount.value) * parseFloat(f.target.value));
        totalPrice.innerText = value;
    });
}


// quantity.addEventListener("change", (e) => { console.log(e.target.value) });