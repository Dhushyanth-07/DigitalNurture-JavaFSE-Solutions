// Using destructuring
function displayEventDetails({name, date, seats}) {
    console.log(`Event: ${name}, Date: ${date}, Seats: ${seats}`);
}

// Using default parameters
function createEvent(name, date, seats = 20, category = 'General') {
    return { name, date, seats, category };
}

// Using spread operator
function cloneEventList() {
    return [...events]; // Creates a shallow copy
}

// Example usage
const newEvent = createEvent("Tech Talk", "2023-12-10");
displayEventDetails(newEvent);

const eventCopy = cloneEventList();
console.log("Original and copy are different:", events !== eventCopy);