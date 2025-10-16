// Display current date and time on the top right
function updateDateTime() {
  const dt = new Date();
  const formatted = dt.toLocaleString();
  document.getElementById('datetime').textContent = formatted;
}
setInterval(updateDateTime, 1000);
updateDateTime();

// Timer to alert if form filling exceeds 3 minutes
let startTime = Date.now();
function checkTimeLimit() {
  if (Date.now() - startTime > 180000) { // 3 minutes
    alert('You have taken more than 3 minutes to fill the form.');
    startTime = Date.now(); // reset timer after alert
  }
}
setInterval(checkTimeLimit, 10000); // Check every 10 seconds

// Validation function called on form submit
function validateForm() {
  checkTimeLimit();

  const firstName = document.getElementById('firstName').value.trim();
  const lastName = document.getElementById('lastName').value.trim();
  const password = document.getElementById('password').value;
  const confirmPassword = document.getElementById('confirmPassword').value;
  const genderEls = document.getElementsByName('gender');
  const mobile = document.getElementById('mobile').value.trim();
  const dob = document.getElementById('dob').value.trim();
  const email = document.getElementById('email').value.trim();

  if (!firstName.match(/^[a-zA-Z]+$/)) {
    alert('First Name must be entered and contain only letters.');
    return false;
  }
  if (!lastName.match(/^[a-zA-Z]+$/)) {
    alert('Last Name must be entered and contain only letters.');
    return false;
  }
  if (password.length < 6 || password.length > 20) {
    alert('Password must be 6 to 20 characters long.');
    return false;
  }
  if (confirmPassword !== password) {
    alert('Confirm Password must match Password.');
    return false;
  }
  let genderSelected = false;
  for (const g of genderEls) {
    if (g.checked) {
      genderSelected = true;
      break;
    }
  }
  if (!genderSelected) {
    alert('Please select your gender.');
    return false;
  }
  if (!mobile.match(/^[0-9]{10}$/)) {
    alert('Mobile number must be exactly 10 digits.');
    return false;
  }
  if (!dob.match(/^\d{4}-\d{2}-\d{2}$/)) {
    alert('Date of Birth must be in YYYY-MM-DD format.');
    return false;
  }
  if (!email.includes('@') || !email.includes('.') || email.indexOf('@') > email.lastIndexOf('.')) {
    alert('Please enter a valid email address.');
    return false;
  }
  return true;
}
