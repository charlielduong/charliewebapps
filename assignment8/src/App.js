import React from "react";
import "./assignment3.css";
import "./default.css";

// WORKS JUST WITHOUT JAVASCRIPT

function generateButton() {
  return true;
}
function checkInputs() {
  return true;
}
function resetButton() {
  return true;
}
// function generateButton() {
//   resetButton();
//   let table = document.getElementById("form");
//   let input = document.getElementById("totalInputs").value;

//   // checks for positive numbers
//   if (input < 1) {
//     alert("Total inputs should be a number greater than 0.");
//     document.getElementById("totalInputs").value = "";
//     document.getElementById("totalInputs").focus();
//     return false;
//   }

//   // checks for integer typea
//   if (!document.getElementById("totalInputs").checkValidity()) {
//     alert("Please enter an integer. i.e. 1 or 2");
//     document.getElementById("totalInputs").value = "";
//     document.getElementById("totalInputs").focus();
//     return false;
//   }

//   let i;
//   for (i = parseInt(input); i > 0; i--) {
//     let row = table.insertRow(1);
//     row.id = "inputRow";
//     // row.classList.add("inputRow"); // class used for input checking on submit

//     let label = row.insertCell(0);
//     let input = row.insertCell(1);
//     let child = document.createElement("input");

//     label.innerHTML = "Positive Input #" + i + ":";

//     input.id = "Value";
//     document.getElementById("Value").colSpan = 2;

//     child.type = "number";
//     child.name = "blocks"; // used in form checker script
//     child.classList.add("userInput");
//     // preset values
//     child.min = 1;
//     child.placeHolder = "1";
//     child.step = "1";

//     input.appendChild(child);
//     child.focus();
//   }
// }
// function resetButton() {
//   let row = document.getElementById("inputRow");

//   while (row !== undefined) {
//     row.parentNode.removeChild(row);
//     row = document.getElementById("inputRow");
//   }
// }
// function checkInputs() {
//   let inputs = document.getElementsByClassName("userInput");

//   // checking that input table has been created first
//   if (inputs.length === 0) {
//     if (!document.getElementById("totalInputs").checkValidity()) {
//       return false;
//     } else {
//       // redirect enter keypress to generatebutton instead
//       //event.preventDefault();
//       generateButton();
//       return false;
//     }
//   }

// traverse through our inputs and check if any are unfilled or nonpositive.
// prevent "enter" keypress from submitting the form
//   for (let i = 0; i < inputs.length; i++) {
//     if (inputs[i].value === undefined) {
//       alert("Please fill out Input #" + (i + 1));
//       inputs[i].focus();
//       //event.preventDefault();
//       return false;
//     } else if (inputs[i].value < 1) {
//       alert("Input #" + (i + 1) + " must be a number greater than 0.");
//       inputs[i].focus();
//       //event.preventDefault();
//       return false;
//     }
//   }

//   return true;
// }

function Banner() {
  return (
    <div style={{ textAlign: "center" }}>
      <h1 style={{ marginBottom: "0px", paddingTop: "5%" }}>
        SWE 432-001 ASSIGNMENT #8
      </h1>
      <h2>
        Charlie Duong &nbsp; | &nbsp; Khai Nguyen &nbsp; | &nbsp; Jesse Tran
      </h2>
      <br />
      <h3>Characteristics and their blocks</h3>
    </div>
  );
}

function InputBox() {
  return (
    <div
      style={{
        backgroundColor: "white",
        borderRadius: "5px",
        width: "50%",
        margin: "auto",
        padding: "1em",
      }}
    >
      <form method="post" action="Assignment4">
        <table
          id="form"
          style={{
            textAlign: "right",
            margin: "auto",
            marginTop: "5%",
            width: "100% !important",
          }}
        >
          <tr>
            <td>Enter a positive number of characteristics: </td>
            <td>
              <input
                style={{
                  width: "100%",
                  type: "number",
                  min: "1",
                  id: "totalInputs",
                  placeHolder: "1",
                  autofocus: "required",
                }}
              />
            </td>
            <td>
              <input
                id="gen"
                type="button"
                class="primary"
                value="Generate"
                style={{
                  width: "100%",
                }}
                onclick={generateButton()}
              />
            </td>
          </tr>
          <tr>
            <td />
            <td />
            <td style={{ textAlign: "right" }}>
              <input
                type="reset"
                class="secondary"
                value="Reset"
                style={{ width: "fit-content", width: "100%" }}
                onclick={resetButton()}
              />
              <input
                type="submit"
                class="primary"
                value="Submit"
                style={{ width: "fit-content", width: "100%" }}
                onclick={checkInputs()}
              />
            </td>
          </tr>
        </table>
      </form>
    </div>
  );
}

function App() {
  return (
    <>
      <Banner />
      <InputBox />
    </>
  );
}

export default App;
