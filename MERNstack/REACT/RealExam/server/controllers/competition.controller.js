const Competition = require("../models/competition.model");


module.exports.createCompetition = (request, response) => {
  const { question, country1, country2, country3} = request.body;
  Competition.create({
      question,
      country1,
      country2,
      country3
  })
      .then(competition => response.json(competition))
      .catch(err => response.status(400).json(err));
}


module.exports.findAllCompetitions = (req, res) => {
  Competition.find()
    .then(allDaCompetitions => res.json( allDaCompetitions ))
    .catch(err => res.json({ message: "Something went wrong", error: err }));
};

module.exports.findOneSingleCompetition = (req, res) => {
	Competition.findOne({ _id: req.params.id })
		.then(oneSingleCompetition => res.json( oneSingleCompetition))
		.catch(err => res.json({ message: "Something went wrong", error: err }));
};

module.exports.createNewCompetition = (req, res) => {
  Competition.create(req.body)
    .then(newlyCreatedCompetition => res.json( newlyCreatedCompetition ))
    .catch(err => res.status(400).json({ message: "Something went wrong", error: err }));
};

module.exports.updateExistingCompetition = (req, res) => {
  Competition.findOneAndUpdate({ _id: req.params.id }, req.body, { new: true, runValidators:[true, "{PATH} is required"] })
    .then(updatedCompetition => res.json( updatedCompetition ))
    .catch(err => res.status(400).json(err));
};

module.exports.deleteAnExistingCompetition = (req, res) => {
  Competition.deleteOne({ _id: req.params.id })
    .then(result => res.json(result))
    .catch(err => res.json({ message: "Something went wrong", error: err }));
};


module.exports.getRandomCompetition = (req, res) => {
	Competition.aggregate([{ $sample: { size: 1 } }])
		.then(randomCompetition => res.json( randomCompetition ))
		.catch(err => res.json({ message: "Something went wrong", error: err }));
};

module.exports.getTopThree = (req, res) => {
  Competition.find().sort({ vote1: -1,vote2:-1,vote3:-1 }).limit(3)
    .then(allDaTop => res.json(allDaTop))
    .catch(err => res.json({ message: "Something went wrong", error: err }));
};
