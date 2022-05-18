function generateButton() {
    resetButton();
    let table = document.getElementById("form");
    let numCharacteristics = document.getElementById("totalInputs").value;

    // checks for positive numbers
    if (numCharacteristics < 1) {
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

    // characteristic instructions and descriptions
    instructions = table.insertRow(1).insertCell(0);
    instructions.colSpan = "3";
    instructions.style.textAlign = "center";
    instructions.innerHTML = "Please enter the characteristic names and their values below:"

    description = table.insertRow(2);
    charDescription = description.insertCell(0);
    charDescription.innerHTML = "Characteristic Name";
    charDescription.style.textAlign = "center";
    charValueDescription = description.insertCell(1);
    charValueDescription.innerHTML = "Characteristic Value (Positive Integer)";
    charValueDescription.style.textAlign = "center";
    charValueDescription.colSpan = "2";

    // characteristic input boxes
    let i;
    for(i = 0; i < numCharacteristics; i++) {
        let row = table.insertRow(i+3);
        row.id = "inputRow";
        // row.classList.add("inputRow"); // class used for input checking on submit

        // We want to create input fields for both block name and block value:
        let characteristic = row.insertCell(0);
        let characteristicName = document.createElement("input");
        let value = row.insertCell(1);
        let child = document.createElement("input");

        characteristic.id = "Characteristic";
        characteristicName.type = "text";
        characteristicName.name = "characteristicName";

        value.id = "Value";
        value.colSpan = "2";
        child.type = "number";
        child.classList.add("userInput"); // used for input checking function
        
        // preset values
        child.min = 1;
        child.placeHolder = "1";
        child.step = "1";
        child.name = "blocks";   // used to retrieve value in doPost


        value.appendChild(child);
        characteristic.appendChild(characteristicName);

        if(i == 0) { // focus first input only
            // child.focus();
            characteristicName.focus();
        }
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