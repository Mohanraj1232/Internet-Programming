function validateProfile() {
  let phone = document.getElementById("phone").value.trim();

  let phonePattern = /^[0-9]{10}$/;
  if (!phone.match(phonePattern)) {
    alert("Phone number must be 10 digits");
    return false;
  }

  return true;
}