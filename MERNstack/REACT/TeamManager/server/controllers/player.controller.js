const Player = require("../models/player.model");


module.exports.createPlayer = (request, response) => {
  const { name, position } = request.body;
  Player.create({
      name,
      position,
  })
      .then(player => response.json(player))
      .catch(err => response.status(400).json(err));
}


module.exports.findAllPlayers = (req, res) => {
  Player.find()
    .then(allDaPlayers => res.json( allDaPlayers ))
    .catch(err => res.json({ message: "Something went wrong", error: err }));
};

module.exports.findOneSinglePlayer = (req, res) => {
	Player.findOne({ _id: req.params.id })
		.then(oneSinglePlayer => res.json( oneSinglePlayer))
		.catch(err => res.json({ message: "Something went wrong", error: err }));
};

module.exports.createNewPlayer = (req, res) => {
  Player.create(req.body)
    .then(newlyCreatedPlayer => res.json( newlyCreatedPlayer ))
    .catch(err => res.status(400).json({ message: "Something went wrong", error: err }));
};

module.exports.updateExistingPlayer = (req, res) => {
  Player.findOneAndUpdate({ _id: req.params.id }, req.body, { new: true, runValidators:[true, "{PATH} is required"] })
    .then(updatedPlayer => res.json( updatedPlayer ))
    .catch(err => res.status(400).json(err));
};

module.exports.deleteAnExistingPlayer = (req, res) => {
  Player.deleteOne({ _id: req.params.id })
    .then(result => res.json(result))
    .catch(err => res.json({ message: "Something went wrong", error: err }));
};


module.exports.getRandomPlayer = (req, res) => {
	Player.aggregate([{ $sample: { size: 1 } }])
		.then(randomPlayer => res.json( randomPlayer ))
		.catch(err => res.json({ message: "Something went wrong", error: err }));
};

