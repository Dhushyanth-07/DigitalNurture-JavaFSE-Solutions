// Submit registration to server
async function submitRegistration(formData) {
    try {
        document.querySelector('#loading-spinner').style.display = 'block';
        
        const response = await fetch('https://mockapi.io/api/v1/registrations', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(formData)
        });
        
        if (!response.ok) throw new Error('Registration failed');
        
        const result = await response.json();
        showMessage('Registration successful!', 'success');
    } catch (error) {
        console.error('Registration error:', error);
        showMessage('Registration failed. Please try again.', 'error');
    } finally {
        document.querySelector('#loading-spinner').style.display = 'none';
    }
}

// Simulate delayed response
function submitRegistrationWithDelay(formData) {
    showMessage('Processing your registration...', 'info');
    
    setTimeout(async () => {
        await submitRegistration(formData);
    }, 2000);
}

function showMessage(message, type) {
    const messageDiv = document.querySelector('#message');
    messageDiv.textContent = message;
    messageDiv.className = `message ${type}`;
    messageDiv.style.display = 'block';
    
    setTimeout(() => {
        messageDiv.style.display = 'none';
    }, 5000);
}