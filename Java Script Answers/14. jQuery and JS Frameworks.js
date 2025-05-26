// Using jQuery for DOM manipulation
$(document).ready(function() {
    // Handle register button click
    $('#registerBtn').click(function() {
        const eventName = $(this).data('event');
        if (eventManager.registerUser(eventName)) {
            $('.message').text('Registration successful!').fadeIn().delay(2000).fadeOut();
        }
    });
    
    // Fade in event cards
    $('.event-card').hide().fadeIn(1000);
    
    // Benefit of React/Vue:
    // Component-based architecture makes UI more maintainable and reusable,
    // with efficient DOM updates through virtual DOM.
});