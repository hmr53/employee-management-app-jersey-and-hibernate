var deleteModel = new bootstrap.Modal(document.getElementById('deleteModel'));
var updateModel = new bootstrap.Modal(document.getElementById('exampleModal'));

function insert_employee() {

    let name = document.getElementById('name').value;
    let position = document.getElementById('position').value;
    let department = document.getElementById('department').value;
    let hiredate = document.getElementById('hire-date').value;
    let salary = document.getElementById('salary').value;

    let form = {
        name: name,
        position: position,
        department: department,
        hire_date: hiredate,
        salary: salary,
    }

    fetch('employee-manage',
        {
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            method: "POST",
            body: JSON.stringify(form)
        })
        .then(function (res) {
            console.log(res.text())
        })
        .catch(function (res) {
            console.log(res)
        })
}

function update_employee(id) {
    getUpdateModel(id);
}

function confirm_update(id) {

    updateModel.hide();
    let name = document.getElementById('name').value;
    let position = document.getElementById('position').value;
    let department = document.getElementById('department').value;
    let hiredate = document.getElementById('hiredate').value;
    let salary = document.getElementById('salary').value;

    let form = {
        name: name,
        position: position,
        department: department,
        hire_date: hiredate,
        salary: salary,
    }


    fetch(`employee-manage/${id}`,
        {
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            method: "PUT",
            body: JSON.stringify(form),
        })
        .then(function (res) {
            console.log(res.text())
            clearTableBody();
            search_all_employees();
        })
        .catch(function (res) {
            console.log(res)
        })
}

function delete_employee(id) {
    getDeleteModel(id);
}

function confirmDelete(id) {

    deleteModel.hide();
    console.log("function working = model save")

    var rowData = document.getElementById(id);

    // let form = {
    //     id: id,
    // }
    // alert(JSON.stringify(form))

    fetch(`employee-manage/${id}`,
        {
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            method: "DELETE",
        })
        .then(function (res) {
            console.log(res.text())
            clearTableBody();
            search_all_employees();
        })
        .catch(function (res) {
            console.log(res)
        })
}

function search_employee() {

}

function search_all_employees() {
    var table = document.getElementById("table");
    var tbody = table.querySelector("tbody");

    fetch('employee-manage',
        {
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            method: "GET",
        })
        .then(async function (res) {

            let datalist = await res.text();
            const desiredOrder = ["id", "name", "position", "department", "hire_date", "salary"];
            const reOrderedObjects = [];

            JSON.parse(datalist).forEach((employee) => {
                const reOrderedSingleObject = {}
                desiredOrder.forEach(key => {
                        if (employee.hasOwnProperty(key)) {
                            if (key === "hire_date") {
                                const hireDateTimestamp = employee[key]; // Convert to milliseconds
                                const hireDate = new Date(hireDateTimestamp);

                                // Format the Date as "YYYY-MM-DD"
                                const formattedHireDate = hireDate.toISOString().split('T')[0];

                                reOrderedSingleObject[key] = formattedHireDate;
                            } else {
                                reOrderedSingleObject[key] = employee[key];
                            }
                        }
                    }
                )
                reOrderedObjects.push(reOrderedSingleObject);

            });

            const names = [];

            reOrderedObjects.forEach((employee) => {
                const tableRow = document.createElement('tr');
                tableRow.className = "mt-5";
                tableRow.id = employee.id;

                for (const property in employee) {
                    const tableCell = document.createElement('td');
                    tableCell.textContent = employee[property];
                    tableRow.appendChild(tableCell);
                }

                // Create Update Button
                const buttonCell = tableRow.insertCell();
                const button = document.createElement("button");
                button.className = "btn text-success";
                button.type = "button";
                button.dataset.bsToggle = "modal";
                button.dataset.bsTarget = "#exampleModal";
                button.onclick = function () {
                    update_employee(employee.id);
                };
                button.innerHTML = 'update <i class="bi bi-pencil-fill"></i>';
                buttonCell.appendChild(button);

                //Creat Delete Button
                const buttonCell2 = tableRow.insertCell();
                const button2 = document.createElement("button");
                button2.className = "btn text-danger";
                button2.type = "button";
                button2.dataset.bsToggle = "modal";
                button2.dataset.bsTarget = "#deleteModel";
                button2.onclick = function () {
                    delete_employee(employee.id);
                };
                button2.innerHTML = 'delete <i class="bi bi-trash3-fill"></i>';
                buttonCell2.appendChild(button2);

                tbody.appendChild(tableRow);
            });


        })
        .catch(function (res) {
            console.log(res)
        })
}

function getDeleteModel(id) {

    var modelTitle = document.getElementById("deleteModel-title");
    var modelBody = document.getElementById("deleteModel-body");
    var modelSave = document.getElementById("deleteModel-save");
    var modelClose = document.getElementById("deleteModel-close");

    var rowData = document.getElementById(id);

    modelTitle.innerText = "Deleting User : " + id;
    modelSave.innerHTML = "Confirm Delete";
    modelSave.className = "btn btn-danger";
    modelBody.innerText = "Do you Really want to Delete User " + id +
        "\n Name : " + rowData.cells.item(1).innerHTML +
        "\n Department : " + rowData.cells.item(3).innerHTML;

    modelSave.onclick = function () {
        confirmDelete(id);
    }

}

function getUpdateModel(id) {
    var modelBody = document.getElementById("exampleModal");
    var modelTitle = document.getElementById("exampleModalLabel");

    modelTitle.innerText = "UPDATE USER : " + id;

    var rowData = document.getElementById(id);
    document.getElementById("name").value = rowData.cells.item(1).innerHTML;
    document.getElementById("position").value = rowData.cells.item(2).innerHTML;
    document.getElementById("department").value = rowData.cells.item(3).innerHTML;
    document.getElementById("hiredate").value = rowData.cells.item(4).innerHTML;
    document.getElementById("salary").value = rowData.cells.item(5).innerHTML;

    document.getElementById("update-model-save").onclick = function () {
        confirm_update(id);
    };


}

function getAlertModel() {
    var modelTitle = document.getElementById("deleteModel-title");
    var modelBody = document.getElementById("deleteModel-body");
    var modelSave = document.getElementById("deleteModel-save");
    var modelClose = document.getElementById("deleteModel-close");


}

function clearTableBody() {
    var tbody = document.querySelector('#table tbody');
    while (tbody.firstChild) {
        tbody.removeChild(tbody.firstChild);
    }
}
