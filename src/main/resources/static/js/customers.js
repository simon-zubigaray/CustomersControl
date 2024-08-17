"use strict";

function init(){
    renderCustomers();
}

async function getCustomers(){
    let url = URL_SERVER + 'customers';
    
    let response = await fetch(url);
    let json = await response.json();

    return json;
}

function getHtmlRowCustomer(customer){
    return `
        <tr>
            <td>${customer.id_customer}</td>
            <td>${customer.firstname} ${customer.lastname} </td>
            <td>${customer.email}</td>
            <td>${customer.address}</td>
            <td>
                <a href="#" onclick="editCustomer(${customer.id_customer})" class="btn btn-primary btn-circle btn-sm">
                    <i class="fas fa-edit"></i>
                </a>
                <a href="#" onclick="removeCustomer(${customer.id_customer})"  class="btn btn-danger btn-circle btn-sm btn-remove-customer">
                    <i class="fas fa-trash"></i>
                </a>
            </td>
        </tr>
    `;
}

async function renderCustomers(){
    let customers = await getCustomers();
    let html = '';

    for(let customer of customers){
        html += getHtmlRowCustomer(customer);
    }

    let tbody = document.querySelector('#tbody-customers');
    tbody.innerHTML = html;    
}

async function removeCustomer(id_customer){
    let response = confirm("¿Quieres eliminar a este cliente?");

    if(!response){
        return;
    }

    let url = URL_SERVER + 'customer/' + id_customer;
    let config = {
        method: 'DELETE'
    };
    await fetch(url, config);
    renderCustomers();
}

function editCustomer(id_customer){
    window.location.href = 'modify-customer.html?id_customer=' + id_customer;
}

init();