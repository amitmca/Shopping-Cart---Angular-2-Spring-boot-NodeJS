var mongoose = require('mongoose');
var Schema = mongoose.Schema;
// var ProductSchema = new mongoose.Schema({
//   _id: Number,
//   name: String,
//   src: String,
//   info: String,
//   price: Number
// });
// mongoose.model('Product', ProductSchema);

module.exports = mongoose.model('Product',
  new Schema({
    _id: Number,
    name: String,
    src: String,
    info: String,
    price: Number
  }),'Product');