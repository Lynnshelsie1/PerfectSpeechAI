/* where i handle the UI interactions like clcking a button*/
document.addEventListener("DOMContentLoaded", function () {
    const recordBtn = document.getElementById("recordBtn");

    if (recordBtn) {
        recordBtn.addEventListener("click", function () {
            alert("Recording started... (This feature is coming soon!)");
        });
    } else {
        console.error("Error: Button with ID 'recordBtn' not found.");
    }
});

