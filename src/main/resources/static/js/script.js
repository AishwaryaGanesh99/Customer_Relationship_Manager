document.addEventListener("DOMContentLoaded", function() {
    const deleteButtons = document.querySelectorAll(".btn-danger");

    deleteButtons.forEach(button => {
        button.addEventListener("click", function(event) {
            const confirmation = confirm("Are you sure you want to delete this customer?");
            if (!confirmation) {
                event.preventDefault();
            }
        });
    });
});
