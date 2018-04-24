var express = require('express');
var app = express();
var db = require('./db');

//User controller
var UserController = require('./user/UserController');
app.use('/users', UserController);

//Auth Controller
var AuthController = require('./auth/AuthController');
app.use('/api/auth', AuthController);

//Product Controller
var ProductController = require('./product/ProductController');
app.use('/api', ProductController);

module.exports = app;