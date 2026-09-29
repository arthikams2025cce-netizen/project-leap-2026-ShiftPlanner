const API_URL = "/api/rosters";

async function loadRosters() {

    ```
try {

    const response = await fetch(API_URL);

    if (!response.ok) {
        throw new Error("Failed to load rosters");
    }

    const rosters = await response.json();

    const table = document.getElementById("rosterTable");

    table.innerHTML = "";

    if (rosters.length === 0) {
        table.innerHTML =
            `<tr>
    <td colspan="4">No roster records found</td>
</tr>`;
        return;
    }

    rosters.forEach(roster => {

        const row = document.createElement("tr");

        row.innerHTML = `
    <td>${roster.id}</td>
    <td>${roster.employeeId}</td>
    <td>${roster.shiftId}</td>
    <td>Approved</td>
        `;

        table.appendChild(row);
    });

} catch (error) {

    console.error(error);

    document.getElementById("rosterTable").innerHTML =
        `<tr>
    <td colspan="4">Unable to connect to Spring Boot</td>
</tr>`;
}
```

}

async function addRoster() {

    ```
const employeeId =
    document.getElementById("employeeId").value;

const shiftId =
    document.getElementById("shiftId").value;

if (!employeeId || !shiftId) {
    alert("Please enter Employee ID and Shift ID");
    return;
}

const roster = {
    employeeId: Number(employeeId),
    shiftId: Number(shiftId)
};

try {

    const response = await fetch(API_URL, {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(roster)
    });

    if (!response.ok) {
        throw new Error("Failed to add roster");
    }

    alert("Roster added successfully!");

    document.getElementById("employeeId").value = "";
    document.getElementById("shiftId").value = "";

    loadRosters();

} catch (error) {

    console.error(error);

    alert("Error connecting to Spring Boot");
}
```

}
