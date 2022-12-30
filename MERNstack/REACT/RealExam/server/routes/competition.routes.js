const CompetitionController = require("../controllers/competition.controller");

module.exports = app => {
    app.get("/api/competitions/", CompetitionController.findAllCompetitions);
    app.get("/api/topThree", CompetitionController. getTopThree);
    app.post('/api/competition/new', CompetitionController.createCompetition)
    app.get("/api/competition/:id", CompetitionController.findOneSingleCompetition);
    app.put("/api/competition/update/:id", CompetitionController.updateExistingCompetition);
    app.delete("/api/competition/:id", CompetitionController.deleteAnExistingCompetition);

};