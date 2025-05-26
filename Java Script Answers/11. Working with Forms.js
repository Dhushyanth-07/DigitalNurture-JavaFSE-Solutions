// HTML structure needed:
/*
<form id="registration-form">
    <input type="text" name="name" placeholder="Your Name" required>
    <input type="email" name="email" placeholder="Email" required>
    <select name="event" required>
        <option value="">Select an event</option>
        <!-- Events will be populated here -->
    </select>
    <button type="submit">Register</button>
</form>
<div id="form-errors"></div>
*/

// Form submission handler
document.querySelector('#registration-form').addEventListener('submit', function(e) {
    e.preventDefault();
    
    const form = e.target;
    const formData = {
        name: form.elements.name.value,
        email: form.elements.email.value,
        event: form.elements.event.value
    };
    
    // Validate
    const errors = validateForm(formData);
    if (errors.length > 0) {
        displayFormErrors(errors);
        return;
    }
    
    // Process registration
    if (eventManager.registerUser(formData.event)) {
        alert(`Registration successful for ${formData.event}!`);
        form.reset();
    } else {
        displayFormErrors(["Sorry, this event is no longer available."]);
    }
});

function validateForm({name, email, event}) {
    const errors = [];
    if (!name.trim()) errors.push("Name is required");
    if (!email.includes('@')) errors.push("Valid email is required");
    if (!event) errors.push("Please select an event");
    return errors;
}

function displayFormErrors(errors) {
    const errorContainer = document.querySelector('#form-errors');
    errorContainer.innerHTML = errors.map(error => 
        `<div class="error">${error}</div>`
    ).join('');
}