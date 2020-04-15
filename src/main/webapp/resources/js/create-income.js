$(function () {
    console.log("ready");
    $("#create-income").on('submit', (event) => onsubmit(event));
})


async function onsubmit(event) {
    event.preventDefault();
    console.log("click registration form");

    let transaction = objectifyForm($("#create-income").serializeArray());
    console.log(JSON.stringify(transaction));
    let response = await fetch("/transactions", {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(transaction)
    });

    console.log(response.text());

}

function objectifyForm(formArray) {//serialize data function
    let result = {};
    for (var i = 0; i < formArray.length; i++) {
        result[formArray[i]['name']] = formArray[i]['value'];
    }
    return result;
}