const express = require("express");
const app = express();
const port = 8000;

const {faker} =require('@faker-js/faker');

const User = require("./modules/User");
const Company = require("./modules/Company");
const Address = require("./modules/Address");


const createUser=()=>{
    return new User(
    faker.datatype.uuid(),
    faker.name.firstName(),
    faker.name.lastName(),
    faker.phone.number(),
    faker.internet.email(),
    faker.internet.password(),
    )
}
const createCompany=()=>{
    return new Company(
    faker.datatype.uuid(),
    faker.company.companyName(),
    createAddress()
    

    )
}
const createAddress=()=>{
    return new Address(
        faker.address.streetAddress(),
        faker.address.city(),
        faker.address.state(),
        faker.address.zipCode(),
        faker.address.country()
    )
}

const users = createUser();
console.log(users);
const company=createCompany();
console.log(company);
const address=createAddress();
console.log(address)

const usersAndCompany = {users, company};

app.get("/api/users/new", (req, res) => {
    res.json({ users })});

    app.get("/api/company/new", (req, res) => {
        res.json({ company })});

        app.get("/api/address/new", (req, res) => {
        res.json({ address })});

        app.get("/api/users/company", (req, res) => {
            res.json({ usersAndCompany })});
app.listen(port)