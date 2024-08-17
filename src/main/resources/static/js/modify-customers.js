"use strict";

async function loadCustomer(){
    if(isNew()){
        return;
    }

    let id = getCustomerId();
    let customer = await getCustomerById(id);

    document.querySelector("#txtFirstName").value = customer.firstname;
    document.querySelector("#txtLastName").value = customer.lastname;
    document.querySelector("#txtEmailAddress").value = customer.email;
    document.querySelector("#txtAddress").value = customer.address;
}

function getCustomerId(){
    let auxSplit = window.location.href.split('id_customer=');
    let id = auxSplit[1];
    return id;
}

function isNew(){
    let hasIdInUrl = window.location.href.includes('id_customer=');
    return !hasIdInUrl;
}

async function getCustomerById(id_customer){
    let url = URL_SERVER + 'customer/' + id_customer;
    let response = await fetch(url);
    let json = await response.json();
    return json;
}

function clickCreate(){

    let firstname = document.querySelector("#txtFirstName").value;
    let lastname = document.querySelector("#txtLastName").value;
    let email = document.querySelector("#txtEmailAddress").value;
    let address = document.querySelector("#txtAddress").value;

    let customer = {
        "firstname" : firstname,
        "lastname" : lastname,
        "email" : email,
        "address" : address
    }

    console.log(customer);

    save(customer);
}

async function save(customer){
    let url = URL_SERVER + 'customer';
    let methodType = isNew() ? 'POST' : 'PUT';

    if(!isNew()){
        url += '/' + getCustomerId();
    }

    let config = {
        "method": methodType,
        "body": JSON.stringify(customer),
        "headers": {
            'Content-Type': 'application/json'
        }
    };

    await fetch(url, config);
    alert("Guardado exitosamente!");
    window.location.href = 'customers.html';
}

loadCustomer();