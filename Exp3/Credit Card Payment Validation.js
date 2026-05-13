function validatePayment() {
  let cardNumber = document.getElementById("cardNumber").value.replace(/\s/g, '');
  let cvv = document.getElementById("cvv").value;
  let expiry = document.getElementById("expiry").value.trim;

  // Card number (16 digits)
  let cardPattern = /^[0-9]{16}$/;
  if (!cardNumber.match(cardPattern)) {
    alert("Invalid card number");
    return false;
  }

  // CVV (3 digits)
  let cvvPattern = /^[0-9]{3}$/;
  if (!cvv.match(cvvPattern)) {
    alert("Invalid CVV");
    return false;
  }

  // Expiry date (MM/YY)
  if (expiry.length != 5) {
    alert("Invalid expiry date");
    return false;
  }

  return true;
}