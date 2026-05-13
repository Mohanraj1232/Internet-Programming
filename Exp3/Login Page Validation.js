function validateLogin() {
  let email = document.getElementById("loginEmail").value.trim();
  let password = document.getElementById("loginPassword").value;

  if (email === "" || password === "") {
    alert("All fields are required");
    return false;
  }

  return true;
}