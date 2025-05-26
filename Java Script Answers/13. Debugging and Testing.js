// Adding debug logging
function registerUser(eventName) {
    console.log('Attempting registration for:', eventName);
    
    const event = events.find(e => e.name === eventName);
    console.log('Event found:', event);
    
    if (!event) {
        console.error('Event not found');
        return false;
    }
    
    if (event.seats <= 0) {
        console.warn('No seats available');
        return false;
    }
    
    event.seats--;
    console.log('Registration successful. Seats left:', event.seats);
    return true;
}

// Example of using breakpoints
// Add this line where you want to inspect:
// debugger;