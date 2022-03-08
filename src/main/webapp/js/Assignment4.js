
function generateButton() {
    resetButton();
    let table = document.getElementById("form");
    let input = document.getElementById("totalInputs").value;

    // checks for positive numbers
    if (input < 1) {
        alert("Total inputs should be a number greater than 0.");
        document.getElementById("totalInputs").value = "";
        document.getElementById("totalInputs").focus();
        return false;
    }

    // checks for integer type
    if (!document.getElementById("totalInputs").checkValidity()) {
        alert("Please enter an integer. i.e. 1 or 2");
        document.getElementById("totalInputs").value = "";
        document.getElementById("totalInputs").focus();
        return false;
    }

    let i;
    for (i = parseInt(input); i > 0; i--) {
        let row = table.insertRow(1);
        row.id = "inputRow";
        // row.classList.add("inputRow"); // class used for input checking on submit

        let label = row.insertCell(0);
        let input = row.insertCell(1);
        let child = document.createElement("input");

        label.innerHTML = "Positive Input #" + i + ":";

        input.id = "Value";
        document.getElementById("Value").colSpan = 2;

        child.type = "number";
        child.name = "Input #" + i;   // used in form checker script
        child.classList.add("userInput");
        // preset values
        child.min = 1;
        child.placeHolder = "1";
        child.step = "1";

        input.appendChild(child);
        child.focus();
    }
}

// removes the rows containing input fields
function resetButton() {
    let row = document.getElementById("inputRow");

    while (row != undefined) {
        row.parentNode.removeChild(row);
        row = document.getElementById("inputRow");
    }
}

function checkInputs() {
    let inputs = document.getElementsByClassName("userInput");

    // checking that input table has been created first
    if (inputs.length == 0) {
        if (!document.getElementById("totalInputs").checkValidity()) {
            return false;
        } else {
            // redirect enter keypress to generatebutton instead
            event.preventDefault();
            generateButton();
            return false;
        }
    }

    // traverse through our inputs and check if any are unfilled or nonpositive.
    // prevent "enter" keypress from submitting the form
    for (let i = 0; i < inputs.length; i++) {
        if (inputs[i].value == undefined) {
            alert("Please fill out Input #" + (i + 1));
            inputs[i].focus();
            event.preventDefault();
            return false;
        } else if (inputs[i].value < 1) {
            alert("Input #" + (i + 1) + " must be a number greater than 0.");
            inputs[i].focus();
            event.preventDefault();
            return false;
        }
    }

    return true;

}