function validateForm() {
    const password = document.getElementById('password').value;
    const dob = document.getElementById('dob').value;
    const contact = document.getElementById('contact').value;

    // Password must contain at least one number and one uppercase letter
    const passwordRegex = /^(?=.*[A-Z])(?=.*\d).+$/;
    if (!passwordRegex.test(password)) {
        alert('Password must contain at least one uppercase letter and one number.');
        return false;
    }

    // Date of Birth should be less than today's date
    const today = new Date().toISOString().split('T')[0];
    if (dob >= today) {
        alert('Date of Birth must be less than today\'s date.');
        return false;
    }

    // Contact Number must be exactly 10 digits (pattern in HTML handles this too)
    if (!/^\d{10}$/.test(contact)) {
        alert('Contact Number must be exactly 10 digits.');
        return false;
    }

    return true;
}

// Set max date for DOB input to today dynamically
document.addEventListener('DOMContentLoaded', () => {
    const dobInput = document.getElementById('dob');
    dobInput.max = new Date().toISOString().split('T')[0];
});
