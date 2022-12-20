const mongoose = require('mongoose');
 
const ProductSchema = new mongoose.Schema({
    title: {type:String , required:[true, "title is required"
    ]
},
    price: Number,
    description: String
}, { timestamps: true });
 
const Product = mongoose.model('Product', ProductSchema);
 
module.exports = Product;
