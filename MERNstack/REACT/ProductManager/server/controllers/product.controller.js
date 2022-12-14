const Product = require("../models/product.model");


module.exports.createProduct = (request, response) => {
  const { title, price, description } = request.body;
  Product.create({
      title,
      price,
      description
  })
      .then(product => response.json(product))
      .catch(err => response.json(err));
}


module.exports.findAllProducts = (req, res) => {
  Product.find()
    .then(allDaProducts => res.json( allDaProducts ))
    .catch(err => res.json({ message: "Something went wrong", error: err }));
};

module.exports.findOneSingleProduct = (req, res) => {
	Product.findOne({ _id: req.params.id })
		.then(oneSingleProduct => res.json( oneSingleProduct))
		.catch(err => res.json({ message: "Something went wrong", error: err }));
};

module.exports.createNewProduct = (req, res) => {
  Product.create(req.body)
    .then(newlyCreatedProduct => res.json( newlyCreatedProduct ))
    .catch(err => res.status(400).json({ message: "Something went wrong", error: err }));
};

module.exports.updateExistingProduct = (req, res) => {
  Product.findOneAndUpdate({ _id: req.params.id }, req.body, { new: true, runValidators:true })
    .then(updatedProduct => res.json( updatedProduct ))
    .catch(err => res.status(400).json({ message: "Something went wrong", error: err }));
};

module.exports.deleteAnExistingProduct = (req, res) => {
  Product.deleteOne({ _id: req.params.id })
    .then(result => res.json(result))
    .catch(err => res.json({ message: "Something went wrong", error: err }));
};


module.exports.getRandomProduct = (req, res) => {
	Product.aggregate([{ $sample: { size: 1 } }])
		.then(randomProduct => res.json( randomProduct ))
		.catch(err => res.json({ message: "Something went wrong", error: err }));
};

